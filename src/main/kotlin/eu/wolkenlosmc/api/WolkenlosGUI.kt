package eu.wolkenlosmc.api

import eu.wolkenlosmc.api.gui.GUI
import org.bukkit.entity.Player

object WolkenlosGUI {

    fun Player.gui(title: String, size: Int, init: GUI.() -> Unit) = GUI(title, size).apply(init).open(this)
}