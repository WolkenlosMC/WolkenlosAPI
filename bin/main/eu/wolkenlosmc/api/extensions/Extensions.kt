package eu.wolkenlosmc.api.extensions

import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Bukkit
import org.bukkit.entity.Player

val pluginManager get() = Bukkit.getPluginManager()

val miMe get () = MiniMessage.miniMessage()

