<div align="center">

<img src="Logo.png" alt="Jade Addon: TFMG Compat Logo" width="128"/>

# Jade Addon: TFMG Compat

**See TFMG electrical data right inside Jade's tooltip HUD — no extra overlay needed.**

[![CurseForge](https://img.shields.io/curseforge/dt/1357568?logo=curseforge&label=CurseForge&color=F16436)](https://www.curseforge.com/minecraft/mc-mods/1357568)
[![Modrinth](https://img.shields.io/modrinth/dt/gv5RRavC?logo=modrinth&label=Modrinth&color=00AF5C)](https://modrinth.com/mod/gv5RRavC)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-62B47A?logo=creeper)](https://www.minecraft.net/)
[![NeoForge](https://img.shields.io/badge/NeoForge-21.1.209+-orange)](https://neoforged.net/)

</div>

---

## What is this?

[Create: The Factory Must Grow (TFMG)](https://www.curseforge.com/minecraft/mc-mods/create-the-factory-must-grow) adds electric machines that show voltage, current, and power usage through a dedicated screen-space overlay — TFMG's own "goggles" view.

[Jade Addons](https://www.curseforge.com/minecraft/mc-mods/jade-addons-forge) brings Create's goggle readout into [Jade](https://www.curseforge.com/minecraft/mc-mods/jade)'s block tooltip panel. But out of the box it knows nothing about TFMG's electrical system.

**This mod fills that gap.** It hooks TFMG's Multimeter data directly into Jade's tooltip so you can inspect any electric machine just by looking at it — the same way you already inspect every other Create block.

## Features

- **Multimeter data in Jade** — voltage, current, and power are displayed in Jade's HUD panel for any TFMG electric block, including multi-block structures.
- **Respects Jade Addons' goggle mode** — the provider is automatically suppressed when Jade Addons' integrated-goggles mode is active, so you never see duplicated information.
- **Three configurable toggles** (adjustable in Jade's in-game config panel):

  | Toggle | Default | Description |
  |---|---|---|
  | Requires Multimeter | off | Only show data when holding a Multimeter in a hand or Curios slot |
  | Requires Goggles | off | Only show data when wearing Create Goggles |
  | Detailed mode | off | Only show data while sneaking |

- **Curios belt slot for the Multimeter** — all 17 colour variants of the TFMG Multimeter can be worn in a Curios belt slot so they count as "held" without occupying your hands.

## Requirements

| Mod | Version |
|---|---|
| Minecraft | 1.21.1 |
| NeoForge | 21.1.209+ |
| [Create](https://www.curseforge.com/minecraft/mc-mods/create) | 6.0.7 – 6.1.x |
| [Jade](https://www.curseforge.com/minecraft/mc-mods/jade) | 15.x |
| [Jade Addons](https://www.curseforge.com/minecraft/mc-mods/jade-addons-forge) | 6.1.x |
| [Create: The Factory Must Grow](https://www.curseforge.com/minecraft/mc-mods/create-the-factory-must-grow) | 1.2.x |
| [Curios API](https://www.curseforge.com/minecraft/mc-mods/curios) | 9.0.0+ *(optional)* |

Curios is fully optional. Without it, the "Requires Multimeter" toggle only checks your main hand and off-hand.
