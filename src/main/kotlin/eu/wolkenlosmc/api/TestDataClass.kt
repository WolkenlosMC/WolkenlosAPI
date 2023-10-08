package eu.wolkenlosmc.api

import eu.wolkenlosmc.api.database.DataClass

data class TestDataClass(
    override val id: String,
    val name: String,
    val age: Int
) : DataClass