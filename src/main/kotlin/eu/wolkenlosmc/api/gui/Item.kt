package eu.wolkenlosmc.api.gui

import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class Item(
    val page: Page,
    index: Int,
    private val itemStackOrigin: ItemStack,
    val onClick: (InventoryClickEvent, GUI) -> Unit,
) {

    val itemStack : ItemStack
        get() {
            var itemStack = itemStackOrigin.clone()
            conditionItemStacks.forEach { (condition, stack) ->
                if (condition(page.gui.player)) {
                    itemStack = stack.clone()
                }
            }
            return itemStack
        }
    private val conditionItemStacks = mutableMapOf<(Player) -> Boolean, ItemStack>()

    init {
        page.items[index] = this
    }

    fun condition(condition: (Player) -> Boolean, itemStack: ItemStack) : Item {
        conditionItemStacks[condition] = itemStack
        return this
    }
}