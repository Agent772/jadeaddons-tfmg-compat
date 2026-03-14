package com.agent772.jadeaddontfmgcompat;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(TFMGJadeAddon.MOD_ID)
public class TFMGJadeAddon {

    public static final String MOD_ID = "jadeaddontfmgcompat";

    public TFMGJadeAddon(IEventBus modBus) {
        // Jade discovers TFMGPlugin via @WailaPlugin — no manual registration needed here
    }
}
