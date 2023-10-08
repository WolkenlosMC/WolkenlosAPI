package eu.wolkenlosmc.api.database

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import eu.wolkenlosmc.api.main.WolkenlosAPI.Companion.instance
import kotlin.reflect.KClass


class MongoDB(
    val connectionString: String,
    val databaseName: String,
    val collectionsList: Map<String, Any>
) {
    companion object {
        lateinit var client: MongoClient
        lateinit var database: MongoDatabase
        lateinit var collections: HashMap<String, MongoCollection<DataClass>>
        var connected = false
    }

    fun connect() {
        try {
            client = MongoClient.create(connectionString)
            database = client.getDatabase(databaseName)
            collectionsList.forEach { (name, dataClass) ->
                collections[name] = database.getCollection(name)
            }
            instance.logger.info("Connected to MongoDB!")
            connected = true
        } catch (e: Exception) {
            instance.logger.warning("Could not connect to MongoDB!")
            e.printStackTrace()
        }
    }

}