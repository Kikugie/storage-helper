package finder.extensions.item_finder

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.ephemeralSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.rest.builder.message.create.embed
import finder.TEST_SERVER_ID
import finder.utils.convertToDisplay
import finder.utils.convertToMC
import kotlinx.datetime.Clock

class ItemFinder : Extension() {
    override val name = "test"
    override suspend fun setup() {
        ephemeralSlashCommand(::FinderArgs) {
            name = "find"
            description = "Locate item in the storage"

            guild(TEST_SERVER_ID)  // Otherwise it'll take an hour to update

            action {
                val item = convertToMC(arguments.item)

                val displayItem = convertToDisplay(item)

                if (displayItem !== null) {
                    respond {
                        embed {
                            thumbnail { url = CONFIG["icon_repository"].toString() + "$item.png" }
                            field {
                                name = "Item: ${convertToDisplay(item)}"
                                value = getItemData(item)
                            }
                            footer { text = "[Storage Item Locator]" }
                            color = getColorData(item)
                            timestamp = Clock.System.now()
                        }
                    }
                } else {
                    respond { content = "**ERROR**: Invalid item name" }
                }
            }
        }

        ephemeralSlashCommand {
            name = "reload"
            description = "Reload item data"

            requirePermission(Permission.ManageGuild)

            guild(TEST_SERVER_ID)  // Otherwise it'll take an hour to update

            action {
                updateItemData()

                respond { content = "> `Data reloaded`" }
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
