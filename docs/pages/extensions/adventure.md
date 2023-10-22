# AdventureExtensions
This adds some useful extensions to the [AdventureAPI](https://docs.advntr.dev/).

## Component 
To create a component, you can use the `component` method. This method uses the [Adventure Color Codes](https://docs.advntr.dev/minimessage/format.html).

=== "Kotlin"

    ```kotlin title="Main.kt"
    val component = component("Hello World")
    ```
=== "Java"

    ```java title="Main.java"
    Component component = AdventureExtensions.component("Hello World");
    ```

## Context
To get the context of a component, you can use the `context` method. This will return
a `String` with the context of the component.

=== "Kotlin"

    ```kotlin title="Main.kt"
    val context = context(component)
    ```
=== "Java"

    ```java title="Main.java"
    String context = AdventureExtensions.context(component);
    ```
