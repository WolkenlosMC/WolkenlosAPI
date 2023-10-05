package eu.wolkenlosmc.api.gui

import org.bukkit.entity.Player

class GUI(
    val title: String,
    val size: Int,
) {
    val pages = mutableMapOf<Int, Page>()
    lateinit var player: Player

    fun page(index: Int, name: String = this.title, init: Page.() -> Unit) = Page(index, this, name)

    fun open(player: Player) {
        this.player = player
        // TODO: open main page
    }
}

