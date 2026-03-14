package com.agent772.jadeaddontfmgcompat;

import com.drmangotea.tfmg.content.electricity.measurement.MultimeterItem;
import net.minecraft.world.entity.player.Player;
import net.neoforged.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;

/**
 * Optional Curios integration. Checks curio slots for a held MultimeterItem.
 * All Curios API references are isolated in this class so they are only
 * classloaded when Curios is actually present at runtime.
 */
public class CuriosCompat {

    /**
     * Returns true if the player holds a MultimeterItem in either hand
     * OR has one equipped in any Curios slot (when Curios is loaded).
     */
    public static boolean isHoldingMultimeterAnywhere(Player player) {
        if (MultimeterItem.isHeldByPlayer(player)) {
            return true;
        }
        if (!ModList.get().isLoaded("curios")) {
            return false;
        }
        return hasCurioMultimeter(player);
    }

    private static boolean hasCurioMultimeter(Player player) {
        return CuriosApi.getCuriosInventory(player)
                .flatMap(inv -> inv.findFirstCurio(stack -> stack.getItem() instanceof MultimeterItem))
                .isPresent();
    }
}
