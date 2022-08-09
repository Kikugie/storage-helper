package finder.utils

class NameConverter {
    companion object {
        private val pattern = Regex("[a-z]+")

        @JvmStatic
        fun convert(name: String): String {
            val words = pattern.findAll(name.lowercase()).map { it.value }.toList()
            return "minecraft:${words.joinToString("_")}"
        }
    }
}