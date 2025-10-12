## About

Created for our college Minecraft server (derex smp), check this plugin in action at server ip 
```
mc.longhorns.dev
```


Guests is a lightweight Bukkit plugin for managing guest players on your Minecraft server. Using a permission system and config, server owners can leave their whitelists off to make a server public, but still vet people who join by turning on a guest mode by default, and setting unverified players to spectator mode. 

It allows you to restrict block breaking, block placing, block interaction, and chat for guests, with configurable options. The plugin uses a simple permission system to control guest and member states, making it easy to manage server access and player abilities.

Recommend using [LuckPerms](https://modrinth.com/plugin/luckperms) to manage the groups, and adding guest.guest and other permissions to the "default" group. 

## Features

- Force players into spectator mode on join (configurable)
- Prevent guests from breaking, placing, or interacting with blocks (configurable)
- Optionally mute guest chat (configurable)
- Easy promotion from guest to member with full permissions
- All restrictions and states are managed via plugin permissions

## Permissions

- `guests.guest` \— Assigned to guest players
- `guests.spectator` \— Forces spectator mode
- `guests.muted` \— Restricts chat
- `guests.limited` \— Restricts block interaction
- `guests.member` \— Full member access

## Configuration

All features can be toggled in the `config.yml` file:

## Credits

Created for the UT Austin Minecraft server, check this plugin in action at mc.longhorns.dev

Developed by Derex (derec4, derex_, derexXD, dereXD, derexwq, DereC_, CORRUPT_Greninja, lordnexus123, and other username iterations).
