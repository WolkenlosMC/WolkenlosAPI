# ItemBuilder
ItemBuilder is a class that allows you to create items with ease.
It is a wrapper for the Bukkit class `ItemStack`.

## Create
To create an ItemBuilder, you need to use the constructor. The `amount` is optional 
and defaults to `1`.

=== "Kotlin"

    ```kotlin title="Main.kt"
    val item = ItemBuilder(material, amount)
    
    // OR
    
    val item = ItemBuilder(itemStack)
    ```
=== "Java"

    ```java title="Main.java"
    ItemStack item = new ItemBuilder(material, amount);

    // OR

    ItemStack item = new ItemBuilder(itemStack);
    ```

## Amount
To set the amount of the item, you can use the `amount` property in the constructor or
the `setAmount` method.

=== "Kotlin"

    ```kotlin title="Main.kt"
    item.setAmount(5)
    ```

=== "Java"

    ```java title="Main.java"
    item.setAmount(5);
    ```

## Display Name
To set the display name of the item, you can use the `setDisplayName` method. This
method uses the [Adventure Color Codes](https://docs.advntr.dev/minimessage/format.html).

=== "Kotlin"

    ```kotlin title="Main.kt"
    item.setDisplayName("My Item")
    ```

=== "Java"

    ```java title="Main.java"
    item.setDisplayName("My Item");
    ```
## Lore
To set the lore of the item, you can use the `setLore` method or the `addLore` method.
This method uses the [Adventure Color Codes](https://docs.advntr.dev/minimessage/format.html).

=== "Kotlin"

    ```kotlin title="Main.kt"
    item.setLore(listOf("Line 1", "Line 2")) // Sets the lore
    item.addLore("Line 3") // Adds a line to the lore
    ```

=== "Java"

    ```java title="Main.java"
    item.setLore(Arrays.asList("Line 1", "Line 2")); // Sets the lore
    item.addLore("Line 3"); // Adds a line to the lore
    ```
## Invisible Enchantment
To toggle the invisible enchantment, you can use the `setInvisibleEnchantment` method.

=== "Kotlin"

    ```kotlin title="Main.kt"
    item.setInvisibleEnchantment(true) // Makes the item glow
    ```
=== "Java"

    ```java title="Main.java"
    item.setInvisibleEnchantment(true); // Makes the item glow
    ```

!!! Note "Not finished"
    This method is not finished yet. It will get more options in the future.
