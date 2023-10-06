package eu.wolkenlosmc.api.gui

import eu.wolkenlosmc.api.gui.elements.GUIItem
import org.bukkit.inventory.ItemStack

/**
 * This class is used to represent a page in a GUI
 * @param index the index of the page
 * @param items the items of the page
 * @param backgroundItem the background item of the page
 */
class GUIPage(
    val index: Int,
    internal val items: Map<Int, GUIItem>,
    val backgroundItem: ItemStack? = null,
)