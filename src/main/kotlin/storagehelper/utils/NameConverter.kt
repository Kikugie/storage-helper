package storagehelper.utils

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.File

private val pattern = Regex("[a-z]+")
@OptIn(ExperimentalSerializationApi::class)
private val lang = Json.decodeFromStream<Map<String, String>>(File("src/main/resources/item_finder/lang.json").inputStream())

fun convertToMC(name: String): String {
    val words = pattern.findAll(name.lowercase()).map { it.value }.toList()
    return words.joinToString("_")
}

fun convertToDisplay(name: String): String? {
    return lang[name]
}