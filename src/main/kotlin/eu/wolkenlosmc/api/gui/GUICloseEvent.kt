package eu.wolkenlosmc.api.gui

import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryCloseEvent

/**
 * This class represents a gui close event
 * @param bukkitEvent The bukkit event
 * @param guiInstance The gui instance
 * @param player The player
 */
class GUICloseEvent(
    val bukkitEvent: InventoryCloseEvent,
    val guiInstance: GUIInstance,
    val player: Player
)
