package finder.extensions.item_finder

import dev.kord.common.Color
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

private val storage =
    Json.decodeFromString(Storage.serializer(), File("src/main/resources/finder/storage.json").readText())

var itemData: Map<String, String> = mapOf()
var colorData: Map<String, Color> = mapOf()

@Serializable
data class Storage(
    val halls: List<Hall>,
    val extras: List<Row>
)

@Serializable
data class Hall(
    val name: String,
    val rows: List<Row>
)

@Serializable
data class Row(
    val name: String,
    val items: List<String>
)

fun updateItemData() {
    val tempItemData: MutableMap<String, String> = mutableMapOf()
    val tempColorData: MutableMap<String, Color> = mutableMapOf()

    storage.halls.forEach { hall ->
        hall.rows.forEach { row ->
            row.items.forEachIndexed { index, item ->
                tempItemData[item] = CONFIG["halls_message"].toString().format(
                    hall.name,
                    row.name,
                    index + 1
                )
                tempColorData[item] = Color(0x00ff00)
            }
        }
    }

    storage.extras.forEach { location ->
        location.items.forEach { item ->
            tempItemData[item] = CONFIG["extras_message"].toString().format(
                location.name
            )
            tempColorData[item] = Color(0xffff00)
        }
    }

    itemData = tempItemData
    colorData = tempColorData
}

fun getItemData(item: String): String {
    return itemData[item] ?: CONFIG["not_found_message"].toString()
}

fun getColorData(item: String): Color {
    return colorData[item] ?: Color(0xff0000)
}
