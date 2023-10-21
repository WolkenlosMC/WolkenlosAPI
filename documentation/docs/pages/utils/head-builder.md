# HeadBuilder
HeadBuilder is a class that allows you to create heads. It returns an 
[ItemBuilder](item-builder.md) with the head as the item. It is a wrapper
for the Bukkit class `ItemStack`.

## Create
To create a HeadBuilder, you need to use the constructor.

=== "Kotlin"

    ```kotlin title="Main.kt"
    val head = HeadBuilder(player)
    
    // OR

    val head = HeadBuilder(texture)
    ```
=== "Java"

    ```java title="Main.java"
    ItemStack head = new HeadBuilder(player);

    // OR

    ItemStack head = new HeadBuilder(texture);
    ```

## Get Builder
To get the builder, you can use the `getBuilder` method. This will return an
[ItemBuilder](item-builder.md) with the head as the item.

=== "Kotlin"

    ```kotlin title="Main.kt"
    val builder = head.getBuilder()
    ```

=== "Java"

    ```java title="Main.java"
    ItemBuilder builder = head.getBuilder();
    ```

!!! note
    The method to get the head of a player-name will be added soon.