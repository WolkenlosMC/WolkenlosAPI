package eu.wolkenlosmc.api.utils

import eu.wolkenlosmc.api.extensions.component
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

/**
 * This class is used to create items
 * @param material The material of the item
 * @param amount The amount of the item
 * @since 1.1
 * @author TheSkyScout
 */
class ItemBuilder(material: Material) {
    private var amount:Int = 1
    private var lore = ArrayList<Component>()
    private var itemStack:ItemStack
    private var itemMeta:ItemMeta

    constructor(material: Material, amount: Int): this(material) {
        this.amount = amount
        this.itemStack.amount = amount
    }
    constructor(itemStack: ItemStack): this(itemStack.type) {
        this.itemStack = itemStack
        this.itemMeta = itemStack.itemMeta
    }
    init {
        itemStack = ItemStack(material, amount)
        itemMeta = itemStack.itemMeta
    }

    /**
     * This function is used to set the display name of the item
     * @param displayName The display name of the item
     * @return The [ItemBuilder] instance
     * @since 1.1
     * @author TheSkyScout
     */
    fun setDisplayName(displayName:String):ItemBuilder {
        itemMeta.displayName(component(displayName))
        return this
    }
    fun setDisplayName(displayName:Component):ItemBuilder {
        itemMeta.displayName(displayName)
        return this
    }

    /**
     * This function is used to set the amount of the item
     * @param amount The amount of the item
     * @return The [ItemBuilder] instance
     * @since 1.1
     * @author TheSkyScout
     */
    fun setAmount(amount: Int):ItemBuilder {
        itemStack.amount = amount
        return this
    }

    /**
     * This function is used to set the lore of the item
     * @param list The lore of the item
     * @return The [ItemBuilder] instance
     * @since 1.1
     * @author TheSkyScout
     */
    fun setLore(list:ArrayList<Component>):ItemBuilder {
        lore = list
        return this
    }
    fun addLore(text: String):ItemBuilder {
        lore.add(component(text))
        return this
    }
    fun editLore(line:Int, text: String):ItemBuilder {
        lore.removeAt(line - 1)
        lore.add(line-1, component(text))
        return this
    }

    /**
     * This function is used to set the enchantment of the item
     * @param enchantment The enchantment of the item
     * @param level The level of the enchantment
     * @return The [ItemBuilder] instance
     * @since 1.1
     * @author TheSkyScout
     */
    fun setInvisibleEnchant(boolean: Boolean):ItemBuilder {
        if(boolean) {
            this.itemMeta.addEnchant(Enchantment.CHANNELING, 1, true);
            this.itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        return this
    }

    /**
     * This function builds the item
     * @return The item
     * @since 1.1
     * @author TheSkyScout
     */
    fun toItemStack(): ItemStack {
        itemMeta.lore(lore)
        itemStack.itemMeta = itemMeta
        return itemStack
    }
}