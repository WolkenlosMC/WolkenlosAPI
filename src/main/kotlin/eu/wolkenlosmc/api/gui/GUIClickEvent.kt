package eu.wolkenlosmc.api.gui

import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent

/**
 * This class is used to represent a click event in a GUI
 * @param bukkitEvent the bukkit event
 * @param guiInstance the gui instance
 * @param player the player who clicked
 */
class GUIClickEvent(
    val bukkitEvent: InventoryClickEvent,
    val guiInstance: GUIInstance,
    val player: Player
)
