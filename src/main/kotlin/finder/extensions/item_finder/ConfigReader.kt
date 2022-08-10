package finder.extensions.item_finder

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import kotlinx.serialization.ExperimentalSerializationApi
import java.io.File

@OptIn(ExperimentalSerializationApi::class)
//val CONFIG = Json.decodeFromStream<Map<String, String>>(File("src/main/resources/config.json").inputStream())
private val mapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())

val CONFIG = mapper.readValue(File("src/main/resources/config.yaml"), Map::class.java)