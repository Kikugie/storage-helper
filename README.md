# Storage Helper

## Kord-Ex Discord bot providing Minecraft storage utilities.

### Setup:

- Clone the repository
- Create `.env` file in root folder with the following contents:
    ```
    TOKEN = 
    TEST_SERVER = 0
    ```
  Leave `TEST_SERVER` 0 to make bot accessible in multiple servers. (Useless for now)
- Build and run project.


### Features:

- **Item locator:**  
  Finds item in storage and returns its location.  
  **Setup:**
    - Define your storage layout in `resources/item_finder/storage.json`.  
      *Json structure should follow this structure:*
        ```json
        {
          "name": "My Storage",
          "halls": [
            {
              "name": "North",
              "rows": [
              {
                "name": "Bottom Left",
                "items": [
                  "cobblestone",
                  "stone",
                  "dirt"
                  ]
                }
              ]
            }
          ],
          "extra": [
            {
              "name": "Unstackables",
              "items": [
               "iron_pickaxe"
             ]
           }
         ]
      }
        ```
      You can have any number of halls in the storage and rows in each hall. `extras` field is basically a collection of separate "rows" with unordered items. Item names should follow Minecraft namespace without `minecraft:`prefix. By default contains Wavetech MS layout.
    - Add items to `resources/item_finder/lang.json` file. (By default contains all items in vanilla Minecraft. As for now for version 1.19)  

  **Usage:**  
    Main command is `/find <item>`. Returns embed with item location specified in storage config. If item is not found, returns error message.  
    *Response examples:*  
    ![Found item in halls](https://i.imgur.com/WuJXQ0k.png "Success")
    ![Found item in extras](https://i.imgur.com/FlFvvrc.png "Extras")
    ![Item not found](https://i.imgur.com/FUjQSjy.png "Not found")

    Provided item names can be written in any way as long as words are separated and match namespace.  

  **Extra:**  
    Item icons and embed messages are specified in `recources/config.yaml` file. (By default icons are taken from gitlab repository)

### TODO:

- Multiple storages support
- Discord config upload
- Storage layout display utility
    