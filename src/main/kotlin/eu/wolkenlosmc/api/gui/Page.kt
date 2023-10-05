package eu.wolkenlosmc.api.gui

import org.bukkit.Bukkit
import org.bukkit.inventory.ItemStack
import eu.wolkenlosmc.api.adventures.Adventures.miMe
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.PlayerInventory

class Page(
    index: Int,
    val gui : GUI,
    private val name: String = gui.title,
    private val size: Int = gui.size,
): Listener {

    val items = mutableMapOf<Int, Item>()
    private val inventory = Bukkit.createInventory(null, size, miMe.deserialize(name))
    var backgroundItem : ItemStack? = null

    init {
        gui.pages[index] = this
    }

    fun item(index: Int, itemStack: ItemStack, onClick: (InventoryClickEvent, GUI) -> Unit) = Item(this, index, itemStack, onClick)

    fun open() {
        val openedInventory = gui.player.openInventory
        if(openedInventory is PlayerInventory
            && openedInventory.topInventory.size == size
            && openedInventory.title() == miMe.deserialize(name)) {
            generateInventory(openedInventory.topInventory)
            return
        }
        generateInventory()
        gui.player.closeInventory()
        gui.player.openInventory(inventory)
    }

    //Listeners
    @EventHandler
    fun onClick(event: InventoryClickEvent) {
        if (event.view.title() != miMe.deserialize(name)) return
        event.isCancelled = true
        val item = items[event.slot] ?: return
        item.onClick(event, gui)
    }

    //Generate Inventory
    private fun generateInventory() {
        buildBackground(inventory)
        items.forEach { (index, item) ->
            inventory.setItem(index, item.itemStack)
        }
    }

    private fun generateInventory(inventory: Inventory) {
        buildBackground(inventory)
        items.forEach { (index, item) ->
            inventory.setItem(index, item.itemStack)
        }
    }

    private fun buildBackground(inventory: Inventory) {
        if (backgroundItem == null) return
        for (i in 0 until size) {
            inventory.setItem(i, backgroundItem)
        }
    }
}