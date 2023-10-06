package eu.wolkenlosmc.api.gui

import eu.wolkenlosmc.api.gui.elements.GUIItem
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

fun gui(
    type: GUIType,
    title: Component,
    builder: GUIBuilder.() -> Unit
): GUI {
    return GUIBuilder(type, title).apply(builder).build()
}

/**
 * Opens a GUI for the player
 *
 * @param type The type of the GUI
 * @param title The title of the GUI
 * @param builder The builder for the GUI
 * @since 1.0
 * @author TheSkyScout
 */
fun Player.gui(
    type: GUIType,
    title: Component,
    builder: GUIBuilder.() -> Unit
): GUI {
    return GUIBuilder(type, title).apply(builder).build().also { it.open(this) }
}

fun Player.openGUI(gui: GUI) {
    gui.open(this)
}

/**
 * Builder for a GUI
 *
 * @param type The type of the GUI
 * @param title The title of the GUI
 * @property pagesMap The pages of the GUI
 * @property defaultPage The default page of the GUI
 * @property onClose The action to be executed when the GUI is closed
 * @since 1.0
 * @author TheSkyScout
 */
class GUIBuilder(
    val type: GUIType,
    val title: Component,
) {
    private val pagesMap = ArrayList<GUIPage>()

    var defaultPage: Int = 0

    var onClose: ((GUICloseEvent) -> Unit)? = null

    /**
     * Adds a page to the GUI
     *
     * @param index The index of the page
     * @param builder The builder for the page
     * @since 1.0
     * @author TheSkyScout
     */
    fun page(index: Int, builder: GUIPageBuilder.() -> Unit) {
        pagesMap.add(GUIPageBuilder(index).apply(builder).build())
    }

    /**
     * Builds the GUI
     *
     * @return The GUI
     * @since 1.0
     * @author TheSkyScout
     */
    fun build(): GUI {
        return GUI(GUIData(type, title, pagesMap, defaultPage, onClose))
    }

}

/**
 * Builder for a GUI page
 * @param index The index of the page
 * @property items The items of the page
 * @property backgroundItemStack The background item of the page
 * @since 1.0
 * @author TheSkyScout
 */
class GUIPageBuilder(
    val index: Int,
) {

    private val items = HashMap<Int, GUIItem>()
    private var backgroundItemStack: ItemStack? = null

    /**
     * Adds an item to the page
     * @param slot The slot of the item
     * @param itemStack The item stack of the item
     * @param builder The builder for the item
     * @since 1.0
     * @author TheSkyScout
     */
    fun item(slot: Int, itemStack: ItemStack, builder: GUIItemBuilder.() -> Unit){
        items[slot] = GUIItemBuilder(slot, itemStack).apply(builder).build()
    }

    /**
     * Sets the background of the page
     * @param itemStack The item stack of the background
     * @since 1.0
     * @author TheSkyScout
     */
    fun background(itemStack: ItemStack){
        backgroundItemStack = itemStack
    }

    /**
     * Builds the page
     * @return The page
     * @since 1.0
     * @author TheSkyScout
     */
    internal fun build() = GUIPage(index, items, backgroundItemStack)
}

/**
 * Builder for a GUI item
 * @param slot The slot of the item
 * @param itemStack The item stack of the item
 * @property onClick The action to be executed when the item is clicked
 * @property conditions The conditions for the item
 * @since 1.0
 * @author TheSkyScout
 */
class GUIItemBuilder(
    val slot: Int,
    val itemStack: ItemStack,
) {

    var onClick: ((GUIClickEvent) -> Unit)? = null
    private val conditions = HashMap<(Player) -> Boolean, ItemStack>()

    /**
     * Adds a condition for the item
     * @param condition The condition
     * @param itemStack The item stack to be displayed if the condition is true
     * @since 1.0
     * @author TheSkyScout
     */
    fun condition(condition: (Player) -> Boolean, itemStack: ItemStack){
        conditions[condition] = itemStack
    }

    /**
     * Builds the item
     * @return The item
     * @since 1.0
     * @author TheSkyScout
     */
    fun build() = GUIItem(itemStack, onClick, conditions)
}
