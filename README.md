## About
![Plugin demo](https://cdn.modrinth.com/data/cached_images/7eff3189965f38a9ac2197e3cbbb817183df83a4_0.webp)
Created for our college Minecraft server (derex smp), check this plugin in action at server ip 
```
mc.longhorns.dev
```

Running a public Minecraft survival server today often means [dealing with organized griefing groups and automated server scanners](https://share.google/aimode/LK3uqaxPv5qWEaNxY), forcing many servers to run `/whitelist on` just to stay safe. But that comes at the cost of accessibility, what if you actually want people to join and explore?

Guests is a lightweight Bukkit plugin for managing guest players on your Minecraft server. Using a permission system and config, server owners can leave their whitelists off to make a server public, but still vet people who join by turning on a guest mode by default, and setting unverified players to spectator mode. 

It allows you to restrict block breaking, block placing, block interaction, and chat for guests, with configurable options. 

You use the various permission nodes given and apply them to permission groups to enable or disable guest behavior. A good way is to give guest permissions to the "default" permission group all players get on join, and have a method to promote them upwards once they are whitelisted / verified. 

## Usage

I recommend using [LuckPerms](https://modrinth.com/plugin/luckperms) to manage the groups, and adding guest.guest and other permissions to the "default" group. You can use /lp promote to promote specified users.

If you have any suggestions on how to improve this system plz let me know on the GitHub! 

## Features

- Force players into spectator mode on join 
- Prevent guests from breaking, placing, or interacting with blocks
- Prevent guests from talking in chat (prevents spam bots, or griefing organizations from spamming Discord invites)
- Prevent guests from picking up items
- Prevent guests from damaging entities
- Easy promotion from guest to member with full permissions
- All restrictions and states are managed via plugin permissions
- Exposes APIs for guest joins and chat blocking for plugins like DiscordSRV to use in alerts

## Permissions

- `guests.guest` \— Assigned to guest players
- `guests.spectator` \— Forces spectator mode
- `guests.muted` \— Restricts chat
- `guests.limited` \— Restricts block interaction
- `guests.damage` \— Allows guests to damage entities
- `guests.pickup` \— Allows guests to pickup items
- `guests.reload` \- Reload config

## Configuration

All features can be toggled in the `config.yml` file:

## Join our dev discord!  
![Discord](https://i.imgur.com/u3V5mdF.png)
[https://discord.gg/HM5XEe6pW6](https://discord.gg/HM5XEe6pW6)

## Credits

Created for the UT Austin Minecraft server, check this plugin in action at mc.longhorns.dev

Developed by Derex (derec4, derex_, derexXD, dereXD, derexwq, DereC_, CORRUPT_Greninja, lordnexus123, and other username iterations).
