package eu.wolkenlosmc.api.extensions

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer

/**
 * This function is used to turn a [String] into a [Component]
 * @param string The string to turn into a component
 * @return The component
 * @since 1.1
 * @author TheSkyScout
 */
fun component(string: String) = miMe.deserialize(string)

/**
 * This function is used get the content of a [Component] as a [String]
 * @param component The component to get the content from
 * @return The content of the component as a [String]
 * @since 1.1
 * @author TheSkyScout
 */
fun context(component: Component) = PlainTextComponentSerializer.plainText().serialize(component)

