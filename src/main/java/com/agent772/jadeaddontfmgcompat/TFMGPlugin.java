package com.agent772.jadeaddontfmgcompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class TFMGPlugin implements IWailaPlugin {

    /** UID for the multimeter block component provider */
    public static final ResourceLocation MULTIMETER = ResourceLocation.fromNamespaceAndPath(TFMGJadeAddon.MOD_ID, "multimeter");

    /** Sub-config: require the player to hold a Multimeter in either hand (default: true) */
    public static final ResourceLocation REQUIRES_MULTIMETER = ResourceLocation.fromNamespaceAndPath(TFMGJadeAddon.MOD_ID, "multimeter.requires_multimeter");

    /** Sub-config: require the player to wear Create goggles (default: false) */
    public static final ResourceLocation REQUIRES_GOGGLES = ResourceLocation.fromNamespaceAndPath(TFMGJadeAddon.MOD_ID, "multimeter.requires_goggles");

    /** Sub-config: only show the overlay when sneaking (detailed mode) (default: false) */
    public static final ResourceLocation MULTIMETER_DETAILED = ResourceLocation.fromNamespaceAndPath(TFMGJadeAddon.MOD_ID, "multimeter.detailed");

    @Override
    public void register(IWailaCommonRegistration registration) {
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void registerClient(IWailaClientRegistration registration) {
        registration.addConfig(REQUIRES_MULTIMETER, false);
        registration.addConfig(REQUIRES_GOGGLES, false);
        registration.addConfig(MULTIMETER_DETAILED, false);
        registration.registerBlockComponent(new MultimeterProvider(), Block.class);
    }
}
