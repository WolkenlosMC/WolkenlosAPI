package eu.wolkenlosmc.api.main

import org.bukkit.plugin.java.JavaPlugin

class WolkenlosAPI(plugin: JavaPlugin) {

    companion object {
        lateinit var instance : JavaPlugin
    }

    init {
        instance = plugin
    }

}