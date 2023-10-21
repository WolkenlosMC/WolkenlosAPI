# GUI's 
The API provides a simple way to create GUI's. 

## Create a GUI
There are two ways to create and open a GUI. The first way is to create a new GUI
object and then open it. The second way is to use the `Player.gui()` method.

=== "Kotlin"

    ```kotlin title="GUI.kt"
    // This is an example to create a GUI
    val gui = GUI(GUIType.FIVTY_FOUR, component("Test")) {
        // This adds a page to the GUI
        page(0) {
        // This adds an item to the GUI
            item(0, ItemStack(Material.DIAMOND))
        }
    }
    
    // This opens the GUI
    gui.open(player) 
    // OR
    player.openGUI(gui)
    ```

=== "Java"
    
    ```java title="GUI.java"
    // This is an example to create a GUI
    GUI gui = new GUI(GUIType.FIVTY_FOUR, component("Test"), gui -> {
        // This adds a page to the GUI
        gui.page(0, page -> {
            // This adds an item to the GUI
            page.item(0, new ItemStack(Material.DIAMOND));
        });
    });
    
    // This opens the GUI
    gui.open(player);
    // OR
    player.openGUI(gui);
    ```

Or you can use the `Player.gui()` method:

=== "Kotlin"

    ```kotlin title="GUI.kt"
    // This is a example to create a GUI
    player.gui(GUIType.FIVTY_FOUR, component("Test")) {
        // This adds a page to the GUI
        page(0) {
        // This adds a item to the GUI
            item(0, ItemStack(Material.DIAMOND))
        }
    }
    ```

=== "Java"
    
    ```java title="GUI.java"
    // This is a example to create a GUI
    player.gui(GUIType.FIVTY_FOUR, component("Test"), gui -> {
        // This adds a page to the GUI
        gui.page(0, page -> {
            // This adds a item to the GUI
            page.item(0, new ItemStack(Material.DIAMOND));
        });
    });
    ```

## onClose
The `onClose` method is called when the GUI is closed. This method is called
when the GUI is closed by the player or when the GUI is closed by the server.
It returns a [GUICloseEvent](../../../pages/gui/close-event).

=== "Kotlin" 

    ```kotlin title="GUI.kt"
    // This is a example to create a GUI
    player.gui(GUIType.FIVTY_FOUR, component("Test")) {
        
        // This is called when the GUI is closed by the player
        onClose { event ->
            // Your code here
        }
    }
    ```

=== "Java"
        
    ```java title="GUI.java"
    // This is a example to create a GUI
    player.gui(GUIType.FIVTY_FOUR, component("Test"), gui -> {
        
        // This is called when the GUI is closed by the player
        gui.onClose(event -> {
            // Your code here
        });
    });
    ```
