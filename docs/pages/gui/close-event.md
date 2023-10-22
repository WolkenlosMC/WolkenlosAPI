# GUICloseEvent
This event is called when a player closes the GUI.

## Properties
| Name          | Type                  | Description                        |
|---------------|-----------------------|------------------------------------|
| `bukkitEvent` | `InventoryCloseEvent` | The standard bukkit event          |
| `guiInstance` | `GUIInstance`         | The GUIInstance of the clicked GUI |
| `player`      | `Player`              | The Player who clicked the gui     |

!!! Warning "Important"
    This is not a typical Bukkit event. 
    It is a custom event called by the GUIManager. 
    It is not registered in the Bukkit event system.
