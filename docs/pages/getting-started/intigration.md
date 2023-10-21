# Intigration 
This is a small guide how to integrate the API in your minecraft plugin. 

=== "Kotlin"

    ??? note "Recommended"
        We recommend you to use [Kotlin](https://kotlinlang.org) as your programming language, because the API is written in Kotlin.
        But you can also use [Java](https://java.com) if you want.

    To use this API you have to implement it, you cann see how to do this in the [Implementation](../../../pages/getting-started/implementation/) section.
    Then you have to register the API in your `onEnable` method:
    ```kotlin title="Main.kt"
    companion object {
        lateinit var api: WolkenlosAPI
    }
    
    override fun onEnable() {
        api = WolkenlosAPI(this)
    }
    ```

=== "Java"

    To use this API you have to implement it, you cann see how to do this in the [Implementation](../../../pages/getting-started/implementation/) section.
    Then you have to register the API in your `onEnable` method:
    ```java title="Main.java"
    public class Main extends JavaPlugin {
        public static WolkenlosAPI api;
    
        @Override
        public void onEnable() {
            api = new WolkenlosAPI(this);
        }
    }
    ```
    !!! warning "Warning"
        The `WolkenlosAPI` was never tested in Java, so it may not work.
