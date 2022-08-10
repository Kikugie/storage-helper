package finder.extensions.item_finder

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.File

private val mapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())

// TODO: Make into a data class
val CONFIG: Map<*, *> = mapper.readValue(File("src/main/resources/config.yaml"), Map::class.java)