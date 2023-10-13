package eu.wolkenlosmc.api.utils
import com.mojang.authlib.GameProfile
import com.mojang.authlib.properties.Property
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import java.util.UUID

class HeadBuilder {
    private val itemStack: ItemStack = ItemStack(Material.PLAYER_HEAD)
    private val itemMeta: SkullMeta = itemStack.itemMeta as SkullMeta

    constructor(player : Player) {
        itemMeta.owningPlayer = player
        itemStack.itemMeta = itemMeta
    }
    constructor(url : String) {
        val profile = GameProfile(UUID.randomUUID(), "testABC")
        profile.properties.put("textures", Property("textures", url))
        try {
            val profileField = itemMeta.javaClass.getDeclaredField("profile")
            profileField.isAccessible = true
            profileField.set(itemMeta, profile)
        } catch (_: NoSuchFieldException) {}
        itemStack.itemMeta = itemMeta
    }

    fun getBuilder() : ItemBuilder {
        return ItemBuilder(itemStack)
    }

}