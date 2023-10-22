package eu.wolkenlosmc.api.utils

import eu.wolkenlosmc.api.main.WolkenlosAPI.Companion.instance
import org.apache.commons.io.FileUtils
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class ConfigFile(fileName: String) {
    var file: File
    var config: YamlConfiguration

    init {
        file = File(instance.dataFolder, fileName)

        if(!file.exists()) {
            val stream = instance.getResource(fileName)
            if(stream != null) {
                FileUtils.copyInputStreamToFile(stream, File(instance.dataFolder, fileName))
            } else file.createNewFile()
        }

        config = YamlConfiguration.loadConfiguration(file)
    }

    fun save() {
        config.save(file)
    }
}