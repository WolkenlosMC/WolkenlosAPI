package eu.wolkenlosmc.api

import eu.wolkenlosmc.api.WolkenlosGUI.gui
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Test {

    fun test(player: Player) {
        player.gui("Test", 9) {
            page(0) {
                item(0, itemStack = ItemStack(Material.DIAMOND)) { _, gui ->
                    gui.player.sendMessage("You clicked on a diamond!")
                }
            }
        }
    }
}