# GUIClickEvent
This event is called when a player clicks on an item in a GUI. 

## Properties
| Name          | Type                  | Description                        |
|---------------|-----------------------|------------------------------------|
| `bukkitEvent` | `InventoryClickEvent` | The standard bukkit event          |
| `guiInstance` | `GUIInstance`         | The GUIInstance of the clicked GUI |
| `player`      | `Player`              | The Player who clicked the gui     |

!!! Warning "Important"
    This is not a typical Bukkit event. 
    It is a custom event called by the GUIManager. 
    It is not registered in the Bukkit event system.


