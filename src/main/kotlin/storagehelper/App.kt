/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package storagehelper

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.common.entity.Snowflake
import storagehelper.extensions.item_finder.ItemFinder
import storagehelper.extensions.item_finder.updateItemData

val TEST_SERVER_ID = Snowflake(
    env("TEST_SERVER").toLong()  // Get the test server ID from the env vars or a .env file
)

private val TOKEN = env("TOKEN")   // Get the bot' token from the env vars or a .env file

suspend fun main() {
    val bot = ExtensibleBot(TOKEN) {
        extensions {
            add(::ItemFinder)
        }
    }

    updateItemData()
    bot.start()
}
