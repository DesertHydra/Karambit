package deserthydra.karambit.registry;

import deserthydra.karambit.wood.WoodBlocks;
import deserthydra.karambit.wood.WoodColors;

@SuppressWarnings("WeakerAccess")
public class KarambitBlocks {
    public static WoodBlocks ROSEWATER;
    public static WoodBlocks AZURITE;

    public static void init() {
        ROSEWATER = WoodBlocks.register("rosewater", WoodColors.ROSEWATER);
        AZURITE = WoodBlocks.register("azurite", WoodColors.AZURITE);
    }
}
