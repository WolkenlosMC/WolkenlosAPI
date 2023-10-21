# GUI Item
This is a guide to creating items in a GUI. You can create items in a GUI with the `item` method.

## Create 
You can create an item in a GUI with the `item` method. Als every form from the 
[GUI Page](/pages/gui/page) is an item, so you can use all forms as items.

=== "Kotlin"

    ```kotlin title="GUI.kt"
    page(index) {
        item(index, itemStack)
    }
    ```
=== "Java"
    
    ```java title="GUI.java"
    page(index, page -> {
        page.item(index, itemStack);
    });
    ```

## onClick
You can add a `onClick` event to an item. This event is called when a player 
clicks on the item. It returns a [GUIClickEvent](/pages/gui/click-event).

=== "Kotlin"

    ```kotlin title="GUI.kt"
    page(index) {
        item(index, itemStack) {
            onClick = { event ->
                // Your code
            }
        }
    }
    ```
=== "Java"
    
    ```java title="GUI.java"
    page(index, page -> {
        page.item(index, itemStack, item -> {
            item.onClick(event -> {
                // Your code
            });
        });
    });
    ```
## Conditions
You can add conditions to an item. When the condition is true, the Condition-Item is shown. 
When the condition is false, the normal item is shown. You can use the `condition` method to 
add a condition to an item.

=== "Kotlin"

    ```kotlin title="GUI.kt"
    page(index) {
        item(index, itemStack) {
            condition(contition, itemStack)
        }
    }
    ```
=== "Java"
    
    ```java title="GUI.java"
    page(index, page -> {
        page.item(index, itemStack, item -> {
            item.condition(contition, itemStack);
        });
    });
    ```
