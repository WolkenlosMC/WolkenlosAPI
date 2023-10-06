package eu.wolkenlosmc.api.gui

import eu.wolkenlosmc.api.events.listen
import eu.wolkenlosmc.api.gui.elements.GUIItem
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

/**
 * This class contains all the data that is needed to create a GUI
 * @author TheSkyScout
 * @since 1.0
 * @param type The type of the GUI
 * @param title The title of the GUI
 * @param pages The pages of the GUI
 * @param defaultPage The default page of the GUI
 * @param onClose The function that will be called when the GUI is closed
 */
data class GUIData(
    val type: GUIType,
    val title: Component,
    val pages: List<GUIPage>,
    val defaultPage: Int,
    val onClose: ((GUICloseEvent) -> Unit)?,
)

/**
 * This is the main class of the GUI API
 * @param data The data of the GUI
 * @property instances The instances of the GUI
 * @property bukkitInventory The bukkit inventory of the GUI
 * @property currentPageIndex The index of the current page
 * @property currentPage The current page
 * @constructor Creates a new GUI
 * @since 1.0
 * @author TheSkyScout
 */
class GUI(
    val data: GUIData
) {
    val instances = HashMap<Player, GUIInstance>()
    val bukkitInventory: Inventory = data.type.createInventory(title = data.title)
    var currentPageIndex: Int = data.defaultPage
    val currentPage: GUIPage
        get() = data.pages[currentPageIndex]

    /**
     * This function is used to register the events of the GUI
     * @since 1.0
     * @author TheSkyScout
     */
    init {
        listen<InventoryClickEvent> {
            if (it.view.title() == data.title) {
                val player = it.whoClicked as Player
                val guiInstance = getInstance(player)
                val guiItem = currentPage.items[it.slot]
                if(it.clickedInventory != bukkitInventory) return@listen
                if (guiItem != null ) guiItem.onClick?.invoke(GUIClickEvent(it, guiInstance, player))
                it.isCancelled = true
                guiInstance.refresh()
            }
        }
        listen<InventoryCloseEvent> {
            if (it.view.title() == data.title) {
                val guiInstance = instances[it.player] ?: return@listen
                data.onClose?.invoke(GUICloseEvent(it, guiInstance, it.player as Player))
                deleteInstance(it.player as Player)
            }
        }
    }

    /**
     * This function is used to get the real ItemStack of a GUIItem, because the ItemStack of a GUIItem can be changed by conditions
     * @param guiItem The GUIItem
     * @param player The player
     * @return The real ItemStack of the GUIItem
     * @since 1.0
     * @author TheSkyScout
     */
    fun getRealItemStack(guiItem: GUIItem, player: Player): ItemStack {
        var itemStack = guiItem.itemStack
        guiItem.conditions.toList().reversed().forEach { (condition, item) ->
            if (condition.invoke(player)) {
                itemStack = item
            }
        }
        return itemStack
    }

    /**
     * This function is used to delete an instance of the GUI
     * @param player The player
     * @throws NullPointerException If the GUIInstance for the player is not found
     * @since 1.0
     * @author TheSkyScout
     */
    @Throws(NullPointerException::class)
    fun deleteInstance(player: Player) {
        instances.remove(player) ?: error("GUIInstance for player ${player.name} not found")
    }

    /**
     * This function is used to get all instances of the GUI
     * @return All instances of the GUI
     * @since 1.0
     * @author TheSkyScout
     */
    fun getInstances(): List<GUIInstance> {
        return instances.values.toList()
    }

    /**
     * This function is used to get the instance of the GUI for a player
     * @param player The player
     * @return The instance of the GUI for the player
     * @throws NullPointerException If the GUIInstance for the player is not found
     * @since 1.0
     * @author TheSkyScout
     */
    @Throws(NullPointerException::class)
    fun getInstance(player: Player): GUIInstance {
        return instances[player] ?: error("GUIInstance for player ${player.name} not found")
    }

    /**
     * This function is used to create an instance of the GUI for a player
     * @param player The player
     * @return The instance of the GUI for the player
     * @since 1.0
     * @author TheSkyScout
     */
    fun createInstance(player: Player): GUIInstance {
        return GUIInstance(this, player)
    }

    /**
     * This function is used to open the GUI for a player
     * @param player The player
     * @since 1.0
     * @throws NullPointerException If the GUIInstance for the player is not found
     * @throws IndexOutOfBoundsException If the currentPageIndex is out of bounds
     * @throws IllegalStateException If the GUIInstance for the player is already open
     * @since 1.0
     * @author TheSkyScout
     */
    fun open(player: Player) {
        createInstance(player).openPage(currentPageIndex)
    }

    /**
     * This function is used to open the GUI for a player at a specific page
     * @param player The player
     * @param pageIndex The index of the page
     * @throws NullPointerException If the GUIInstance for the player is not found
     * @throws IndexOutOfBoundsException If the currentPageIndex is out of bounds
     * @throws IllegalStateException If the GUIInstance for the player is already open
     * @since 1.0
     * @author TheSkyScout
     */
    fun open(player: Player, pageIndex: Int) {
        createInstance(player).openPage(pageIndex)
    }

    /**
     * This function is used to open the GUI for a player at the default page
     * @param player The player
     * @throws NullPointerException If the GUIInstance for the player is not found
     * @throws IndexOutOfBoundsException If the currentPageIndex is out of bounds
     * @throws IllegalStateException If the GUIInstance for the player is already open
     * @since 1.0
     */
    fun refresh(player: Player) {
        getInstance(player).refresh()
    }

    /**
     * This function is used to open the GUI for a player at the default page
     * @param player The player
     * @throws NullPointerException If the GUIInstance for the player is not found
     * @throws IndexOutOfBoundsException If the currentPageIndex is out of bounds
     * @throws IllegalStateException If the GUIInstance for the player is already open
     * @since 1.0
     * @author TheSkyScout
     */
    @Throws(NullPointerException::class, IndexOutOfBoundsException::class, IllegalStateException::class)
    fun GUIInstance.refresh() {
        loadPageContent(currentPageIndex)
    }
}

/**
 * This class is the instance of a GUI for a player, so that every player can have their own GUI
 * @param gui The GUI
 * @param player The player
 * @since 1.0
 * @author TheSkyScout
 */
class GUIInstance(
    val gui: GUI,
    val player: Player,
) {

    init {
        gui.instances[player] = this
    }

    /**
     * This function is used to open the GUI for the player
     * @param pageIndex The index of the page that should be opened
     * @throws IndexOutOfBoundsException If the pageIndex is out of bounds
     * @since 1.0
     * @author TheSkyScout
     */
    fun openPage(pageIndex: Int) {
        loadPageContent(pageIndex)
        player.openInventory(gui.bukkitInventory)
    }

    /**
     * This function is used to open the GUI for the player at the default page
     * @throws IndexOutOfBoundsException If the default page is out of bounds
     * @since 1.0
     * @author TheSkyScout
     */
    fun nextPage() {
        if (gui.currentPageIndex + 1 >= gui.data.pages.size) return
        loadPageContent(gui.currentPageIndex + 1)
        gui.currentPageIndex++
    }

    /**
     * This function is used to open the GUI for the player at the default page
     * @throws IndexOutOfBoundsException If the default page is out of bounds
     * @since 1.0
     * @author TheSkyScout
     */
    fun previousPage() {
        if (gui.currentPageIndex - 1 < 0) return
        loadPageContent(gui.currentPageIndex - 1)
        gui.currentPageIndex--
    }

    /**
     * This function builds the GUI for the player
     * @throws IndexOutOfBoundsException If the default page is out of bounds
     * @since 1.0
     * @author TheSkyScout
     */
    fun loadContent() {
        loadPageContent(gui.currentPageIndex)
    }

    /**
     * This function builds the GUI for the player
     * @param pageIndex The index of the page that should be loaded
     * @throws IndexOutOfBoundsException If the default page is out of bounds
     * @since 1.0
     * @author TheSkyScout
     */
    fun loadPageContent(pageIndex: Int) {
        gui.bukkitInventory.clear()
        loadBackground()
        gui.data.pages[pageIndex].items.forEach { (slot, guiItem) ->
            var itemStack = guiItem.itemStack
            guiItem.conditions.toList().reversed().forEach { (condition, item) ->
                if (condition.invoke(player)) {
                    itemStack = item
                }
            }
            gui.bukkitInventory.setItem(slot, itemStack)
        }
    }

    /**
     * This function is used to build the background of the GUI
     * @since 1.0
     * @author TheSkyScout
     */
    private fun loadBackground() {
        if (gui.currentPage.backgroundItem == null) return
        for (i in 0 until gui.bukkitInventory.size) {
            if (gui.bukkitInventory.getItem(i) == null) {
                gui.bukkitInventory.setItem(i, gui.currentPage.backgroundItem)
            }
        }
    }

    /**
     * This function is used to close the GUI for the player
     * @since 1.0
     * @author TheSkyScout
     */
    fun close() {
        player.closeInventory()
        gui.deleteInstance(player)
    }

}

/**
 * This enum contains all the types of GUIs that are supported by the API
 * @param size The size of the GUI
 * @param type The bukkit inventory type of the GUI
 * @since 1.0
 * @author TheSkyScout
 */
enum class GUIType(val size: Int, val type: InventoryType?) {
    NINE(9, null),
    EIGHT_TEEN(18, null),
    TWENTY_SEVEN(27, null),
    THIRTY_SIX(36, null),
    FORTY_FIVE(45, null),
    FIFTY_FOUR(54, null),
    ANVIL(3, InventoryType.ANVIL),
    BARREL(27, InventoryType.BARREL),
    BEACON(1, InventoryType.BEACON),
    BLAST_FURNACE(3, InventoryType.BLAST_FURNACE),
    BREWING_STAND(5, InventoryType.BREWING),
    CARTOGRAPHY(3, InventoryType.CARTOGRAPHY),
    CHEST(27, InventoryType.CHEST),
    CRAFTING(5, InventoryType.CRAFTING),
    DISPENSER(9, InventoryType.DISPENSER),
    DROPPER(9, InventoryType.DROPPER),
    ENCHANTING(2, InventoryType.ENCHANTING),
    ENDER_CHEST(27, InventoryType.ENDER_CHEST),
    FURNACE(3, InventoryType.FURNACE),
    GRINDSTONE(3, InventoryType.GRINDSTONE),
    HOPPER(5, InventoryType.HOPPER),
    LECTERN(1, InventoryType.LECTERN),
    LOOM(4, InventoryType.LOOM),
    MERCHANT(3, InventoryType.MERCHANT),
    SHULKER_BOX(27, InventoryType.SHULKER_BOX),
    SMITHING(2, InventoryType.SMITHING),
    SMOKER(3, InventoryType.SMOKER),
    STONECUTTER(2, InventoryType.STONECUTTER);

    /**
     * This function is used to create an inventory of the GUI
     * @param holder The holder of the inventory
     * @param title The title of the inventory
     * @return The inventory of the GUI
     * @since 1.0
     * @author TheSkyScout
     */
    fun createInventory(holder: InventoryHolder? = null, title: Component = Component.empty()): Inventory {
        return when {
            type == null -> Bukkit.createInventory(holder, size, title)
            else -> Bukkit.createInventory(holder, type, title)
        }
    }
}