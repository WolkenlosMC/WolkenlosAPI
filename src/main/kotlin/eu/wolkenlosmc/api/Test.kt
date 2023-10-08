package eu.wolkenlosmc.api

import eu.wolkenlosmc.api.database.Cache
import eu.wolkenlosmc.api.database.MongoDB

class Test {
    fun test() {
        MongoDB("", "test", mapOf("baum" to TestDataClass::class)).connect()
        Cache.getCollection<TestDataClass>("baum")?.age
    }
}