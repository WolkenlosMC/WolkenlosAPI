# GUI Pages
This section describes how to create a GUI page. A GUI page is a page in a GUI. 
You can create as many pages as you want and navigate between them.

## Creating a GUI page
To create a GUI page you have to call the `page` method in the GUI builder.
This method allows you to create a GUI page in a GUI.

=== "Kotlin"
    ```kotlin title="GUI.kt"
    page(index) {
        // here you can register items and more
        item(index, itemStack)
    }
    ```
=== "Java"
    ```java title="GUI.java"
    page(index, page -> {
        // here you can register items and more
        page.item(index, itemStack);
    });
    ```

## Background
You can set a background for a page. This background is an item displayed
in every slot of the page.

=== "Kotlin"

    ```kotlin title="GUI.kt"
    page(index) {
        background(itemStack)
        // OR
        background(material)
        // In this case the amount is 1 and the display name is null
    }
    ```
=== "Java"

    ```java title="GUI.java"
    page(index, page -> {
        page.background(itemStack);
        // OR
        page.background(material);
        // In this case the amount is 1 and the display name is null
    });
    ```

## Forms
You can create a form of items in a GUI page. A form is a grid of items. Also, you can
add a [onClick](pages/gui/item/#onClick) event to the form. This event is called when a player clicks on any item
in the form.

### Row
You can create a row of items in a GUI page. A row is a horizontal line of items. 

=== "Kotlin"

    ```kotlin title="GUI.kt"
    page(index) {
        row(Row.ONE, itemStack)
    }
    ```

=== "Java"

    ```java title="GUI.java"
    page(index, page -> {
        page.row(Row.ONE, itemStack);
    });
    ```
### Column
You can create a column of items in a GUI page. A column is a vertical line of items.

=== "Kotlin"

    ```kotlin title="GUI.kt"
    page(index) {
        column(Column.ONE, itemStack)
    }
    ```
=== "Java"

    ```java title="GUI.java"
    page(index, page -> {
        page.column(Column.ONE, itemStack);
    });
    ```
### Fill
You can fill a specific area of a GUI page with items.

=== "Kotlin"

    ```kotlin title="GUI.kt"
    page(index) {
        fill(startSlot, endSlot, itemStack)
    }
    ```
=== "Java"

    ```java title="GUI.java"
    page(index, page -> {
        page.fill(startSlot, endSlot, itemStack);
    });
    ```
### Square
You can create a square of items in a GUI page. A square is a grid of items.

=== "Kotlin"

    ```kotlin title="GUI.kt"
    page(index) {
        square(startSlot, height, width, itemStack)
    }
    ```
=== "Java"

    ```java title="GUI.java"
    page(index, page -> {
        page.square(startSlot, height, width, itemStack);
    });
    ```

## Copy from another page
You can copy the content of another page to a page. This is useful if you want to create
a page with the same content as another page.

=== "Kotlin"

    ```kotlin title="GUI.kt"
    val pageOne = page(index) {
        copyFrom(page)
    }

    page(index) {
        copyFrom(pageOne)
    }
    
    // OR

    page(index) {
        copyFrom(pageIndex)
    }
    ```
=== "Java"

    ```java title="GUI.java"
    Page pageOne = page(index, page -> {
        page.copyFrom(page);
    });
    
    page(index, page -> {
        page.copyFrom(pageOne);
    });
    
    // OR

    page(index, page -> {
        page.copyFrom(pageIndex);
    });
    ```

