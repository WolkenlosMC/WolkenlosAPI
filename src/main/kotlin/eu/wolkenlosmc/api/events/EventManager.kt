package eu.wolkenlosmc.api.events

import eu.wolkenlosmc.api.extensions.pluginManager
import eu.wolkenlosmc.api.main.WolkenlosAPI.Companion.instance
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener

fun Listener.unregister() = HandlerList.unregisterAll(this)

fun WEvent<*>.unregister() = HandlerList.unregisterAll(this)

inline fun <reified T : Event>Listener.register(
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = false,
    noinline action: (Listener, Event) -> Unit,
) {
        pluginManager.registerEvent(
            T::class.java,
            this,
            priority,
            action,
            instance,
            ignoreCancelled
        )
}

abstract class WEvent<T : Event>(
    val priority: EventPriority = EventPriority.NORMAL,
    val ignoreCancelled: Boolean = false
): Listener {
    abstract fun onEvent(event: T)
}

inline fun <reified T : Event> WEvent<T>.register() {
    pluginManager.registerEvent(
        T::class.java,
        this,
        priority,
        { _, event -> onEvent(event as T) },
        instance,
        ignoreCancelled
    )
}


inline fun <reified T : Event> listen(
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = false,
    register: Boolean = true,
    noinline action: (T) -> Unit,
): WEvent<T> {
    val listener = object : WEvent<T>(priority, ignoreCancelled) {
        override fun onEvent(event: T) = action(event)
    }
    if (register) listener.register()
    return listener
}