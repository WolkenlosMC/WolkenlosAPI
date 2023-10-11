package eu.wolkenlosmc.api.gui.elements

import eu.wolkenlosmc.api.gui.GUIClickEvent
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

/**
* This class is used to store the ItemStack, the onClick event and the conditions for the item
* @param itemStack The ItemStack of the item
* @param onClick The onClick event of the item
* @param conditions The conditions for the item
*/
class GUIItem (
    val itemStack: ItemStack,
    val onClick: ((GUIClickEvent) -> Unit)?,
    val conditions: HashMap<(Player) -> Boolean, ItemStack>
)
