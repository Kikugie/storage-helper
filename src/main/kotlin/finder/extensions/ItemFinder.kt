package finder.extensions

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.annotation.KordPreview
import finder.TEST_SERVER_ID
import finder.utils.NameConverter

@OptIn(KordPreview::class)
class ItemFinder : Extension() {
    override val name = "test"

    override suspend fun setup() {
        publicSlashCommand(::FinderArgs) {
            name = "find"
            description = "Locate item in the storage"

            guild(TEST_SERVER_ID)  // Otherwise it'll take an hour to update

            action {
                val item = NameConverter.convert(arguments.item)


                respond {
                    content = "*Nothing here yet, but you asked for ${item}*"
                }
            }
        }
    }

    inner class FinderArgs : Arguments() {

        val item by string {
            name = "item"

            description = "Item name you want to find"
        }
    }
}
