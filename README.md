# WolkenlosAPI
**Latest Version:** `1.1.3`

WolkenlosAPI is a Kotlin libary for Minecaft(Spigot). It adds a lot of features for 
building own plugins for Wolkenlos. 

## Dependency
WolkenlosAPI is available on Maven Central.
Gradle:
```kt
implementation("eu.wolkenlosmc:wolkenlosapi:$VERSION")
```
## Guide
At first you have to register the API in your plugin! For this you add following line
in your `onEnable()` funcation:
```kt
override fun onEnable() {
  val wAPI = WolkenlosAPI(this)
}
```
And from now on you can use every function of the api, withoud any problems.

### GUI's
This allows you to easily create clickable GUI's in Minecraft.
```kt
player.gui(GUIType.TWENTY_SEVEN, component("Title")) {
   page(0) {
      background(Material.BLACK_STAINED_GLASS_PANE)
      item(0, ItemStack(Material.STICK)) {
         onClick = { event, gui, player ->
            event.player.sendMessage("You clicked a Stick")
         }
         condition({!it.hasPermission("test.admin")}, ItemStack(Material.BARRIER))
      }
      row(Row.ONE, ItemStack(Material.DIAMOND))
      column(Column.TWO, ItemStack(Material.EMERALD))
   }
}
```
### Listener
This allows you to create Listeners without register them and all that weird stuff.
```kt
listen<EntityDamageEvent> { event ->
   if(event.enity !is Player) return
   val player = event.entity as Player
   player.sendMessage("You got damage :C")
}
```
