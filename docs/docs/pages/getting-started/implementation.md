# Implementation
This section describes how to implement the [API](https://github.com/WolkenlosMC/WolkenlosAPI) in your project. It is made for PaperMC plugins, so
we highly recommend you to use [PaperMC](https://papermc.io) as your server software.

=== "Maven"

    To use the API in your project, you have to add the following dependency to your `pom.xml`:
    ```xml title="pom.xml"
    <dependency>
        <groupId>eu.wolkenlosmc</groupId>
        <artifactId>wolkenlosapi</artifactId>
        <version>1.1.3</version>
    </dependency>
    ```

=== "Gradle"

    To use the API in your project, you have to add the following dependency to your `build.gradle`:
    ```kotlin title="build.gradle.kts"
    repositories {
        mavenCentral()
    }
    
    dependencies {
        implementation("eu.wolkenlosmc:wolkenlosapi:1.1.3")
    }
    ```

