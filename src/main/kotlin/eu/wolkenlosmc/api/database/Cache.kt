package eu.wolkenlosmc.api.database

import com.mongodb.kotlin.client.coroutine.MongoCollection
import eu.wolkenlosmc.api.main.WolkenlosAPI.Companion.instance
import kotlinx.coroutines.runBlocking
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable

object Cache {

    private val caches = mutableMapOf<String, MongoCollection<DataClass>>()
    private val uploadCache = mutableMapOf<String, DataClass>()

    fun initialize() {
       object : BukkitRunnable() {
           override fun run() {
               runBlocking {
                   //Upload all data from cache
                   uploadCache.forEach { (id, data) ->
                       val collection = MongoDB.collections[id]
                       if(collection != null) {
                           collection.insertOne(data)
                           uploadCache.remove(id)
                       }
                   }
                   //Update all caches
                   MongoDB.collections.forEach{ (id, collection) ->
                       if(caches[id] != null && caches[id] != collection) {
                           caches[id] = collection
                       }
                   }
               }
           }
       }.runTaskTimerAsynchronously(instance, 0, 20 * 60 * 5)
    }

    fun <T : DataClass> getCollection(name: String) : T? {
        val collection = MongoDB.collections[name]
        if(collection != null) {
            caches[name] = collection
            return collection.documentClass as T
        } else {
            instance.logger.warning("Could not find collection $name!")
            return null
        }
    }


}