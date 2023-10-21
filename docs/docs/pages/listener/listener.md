# Listeners
This page describes how to use Listeners with the API. As you know there are already
ways to register listeners in Bukkit, but we made it a lot easier for you.

## Registering Listeners
To register a listener you have to call the `listen` method. This method allows you
to register Listeners in a method.

=== "Kotlin"

    ```kotlin title="Listener.kt"
    // This is a example to register a Listener
    fun registerListeners() {
        listen<PlayerJoinEvent> {
            it.player.sendMessage("Welcome to the server!")
        }
    }
    
    // This is a example to register a Listener in a method
    // This method is for example called when you use a command
    fun onCommand() {
        listen<PlayerJoinEvent> {
            it.player.sendMessage("Welcome to the server!")
        }
    }
    ```

=== "Java"

    ```java title="Listener.java"
    // This is a example to register a Listener
    public void registerListeners() {
        WolkenlosAPI.listen(PlayerJoinEvent.class, event -> {
            event.getPlayer().sendMessage("Welcome to the server!");
        });
    }
    
    // This is a example to register a Listener in a method
    // This method is for example called when you use a command
    public void onCommand() {
        WolkenlosAPI.listen(PlayerJoinEvent.class, event -> {
            event.getPlayer().sendMessage("Welcome to the server!");
        });
    }
    ```

## Unregister Listeners
To unregister a listener you have to save the Listener in a variable 
and then call the `unregister()` method.

=== "Kotlin"

    ```kotlin title="Listener.kt"
    // This is a example to unregister a Listener
    val listener = listen<PlayerJoinEvent> {
        it.player.sendMessage("Welcome to the server!")
    }
    listener.unregister()
    ```

=== "Java"

    ```java title="Listener.java"
    // This is a example to unregister a Listener
    Listener listener = WolkenlosAPI.listen(PlayerJoinEvent.class, event -> {
        event.getPlayer().sendMessage("Welcome to the server!");
    });
    listener.unregister();
    ```

