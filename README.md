
<h1>Cool stuff</h1>

<h2>Updates:</h2>

12/17/2024:

    Init

        basic modding needs
    
        update gitignore
    
        Basic Items
    
        added steel

    Blocks

        added steel Blocks
    
        added steel block item

12/18/2024:

    Tabs

        added creative mode tabs
    
        added multiple states for fuel tank

    Crafting and Loot Tables

        added crafting for steel family
    
        added drops to all blocks
    
        minimum tool requirement added

    Chisel stuf

        Added chisel and uses
    
        Added chisel recipes

02/27/2025:

    GUI Fixes & Improvements

        Implemented proper packet handling for GUI opening

        Fixed NullPointerException in FuelTankMenu.java
    
        Ensured ServerPlayer.openMenu() sends BlockPos to client
    
        Refactored Fuel Tank menu logic for stability

    Containers & Inventory Handling
    
        Fixed slot handling in FuelTankMenu
        
        Synced container data between server and client
        
        Registered menu screens correctly to prevent missing GUI issues
    
    Block Entity Improvements
    
        Verified FuelTankBlockEntity implements MenuProvider properly
        
        Ensured correct ContainerData syncing
        
        Optimized interaction logic for fuel tank

02/28/2025:

    Mod Cleanup & Code Refinements
    
        Removed deprecated NetworkHooks.openScreen()
        
        Updated Forge compatibility to 1.21
        
        Refactored block interaction logic for cleaner implementation
        
        Registered all menus and blocks in correct mod lifecycle order
    
    Testing & Debugging
    
        Successfully tested GUI functionality in singleplayer
        
        Resolved desync issues between client and server for Fuel Tank
        
        No further crashes detected when opening inventory screens

03/4/2025:
    
    More Mod Cleanup & Simplification
        
        Cleaned up code in Blocks

        simpleified datagen to support tags

    First Official Release

        Mods first official release is out

        Packaged for use in singleplayer and multiplayer

        Server/Client support

        Issues now mainted on git and discord

If you want to help, message my Discord Tag: <b>deltaV0rtex</b>

Any issues can be reported to the [Github Issues Page](https://github.com/Dareto-Dream/Rocketry/issues) or to the **[Discord Server](https://discord.gg/ne6tnZx9KC)**