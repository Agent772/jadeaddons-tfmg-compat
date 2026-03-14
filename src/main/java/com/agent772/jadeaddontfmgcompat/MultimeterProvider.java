package com.agent772.jadeaddontfmgcompat;

import com.drmangotea.tfmg.content.electricity.base.IElectric;
import com.simibubi.create.content.equipment.goggles.GoggleOverlayRenderer;
import com.simibubi.create.content.equipment.goggles.GogglesItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.PlainTextContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import snownee.jade.addon.create.CreatePlugin;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElementHelper;

import java.util.ArrayList;
import java.util.List;

public class MultimeterProvider implements IBlockComponentProvider {

    // JadeAddons GOGGLES config key — when OFF, TFMG's own HUD is active and we must not duplicate it
    private static final ResourceLocation JADE_ADDONS_GOGGLES = CreatePlugin.GOGGLES;

    @Override
    public ResourceLocation getUid() {
        return TFMGPlugin.MULTIMETER;
    }

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        // Only show when JadeAddons integrated-goggles mode is active.
        // When it's off, TFMG's own screen-space HUD handles display — don't duplicate it here.
        if (!config.get(JADE_ADDONS_GOGGLES)) {
            return;
        }

        // If detailed-only mode is on, require the player to be sneaking
        if (config.get(TFMGPlugin.MULTIMETER_DETAILED) && !accessor.showDetails()) {
            return;
        }

        Level world = accessor.getLevel();
        // Resolve through proxy blocks (e.g. multi-block structures) same as Create's own renderer
        BlockPos pos = GoggleOverlayRenderer.proxiedOverlayPosition(world, accessor.getPosition());
        BlockEntity be = world.getBlockEntity(pos);

        if (!(be instanceof IElectric electric)) {
            return;
        }

        if (config.get(TFMGPlugin.REQUIRES_MULTIMETER) && !CuriosCompat.isHoldingMultimeterAnywhere(accessor.getPlayer())) {
            return;
        }

        if (config.get(TFMGPlugin.REQUIRES_GOGGLES) && !GogglesItem.isWearingGoggles(accessor.getPlayer())) {
            return;
        }

        List<Component> lines = new ArrayList<>();
        boolean added = electric.makeMultimeterTooltip(lines, accessor.showDetails());

        if (!added || lines.isEmpty()) {
            return;
        }

        IElementHelper helper = IElementHelper.get();
        boolean isHeader = true;
        for (Component c : lines) {
            if (c.getString().isBlank()) {
                tooltip.add(helper.spacer(3, 3));
                continue;
            }
            // Strip the 4-space indent TFMG's forGoggles() adds, keep sibling styles
            MutableComponent processed;
            if (c.getContents() instanceof PlainTextContents.LiteralContents lc
                    && lc.text().startsWith("    ")) {
                processed = Component.literal(lc.text().substring(4)).withStyle(c.getStyle());
                c.getSiblings().forEach(processed::append);
            } else {
                processed = c.copy();
            }
            // Header line ("Multimeter"): flatten to plain string so Jade's default gray applies
            if (isHeader) {
                processed = Component.literal(processed.getString());
                isHeader = false;
            }
            tooltip.add(helper.text(processed));
        }
    }

    @Override
    public boolean enabledByDefault() {
        return true;
    }
}
