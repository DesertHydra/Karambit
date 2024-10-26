package deserthydra.karambit.registry;

import deserthydra.karambit.wood.WoodBlocks;
import deserthydra.karambit.wood.WoodColors;
import deserthydra.karambit.wood.WoodWood;

@SuppressWarnings("WeakerAccess")
public class KarambitBlocks {
    public static WoodBlocks ROSEWATER;
    public static WoodBlocks AZURITE;

    public static void init() {
        ROSEWATER = WoodBlocks.register("rosewater", WoodColors.ROSEWATER, KarambitWood.ROSEWATER);
        AZURITE = WoodBlocks.register("azurite", WoodColors.AZURITE, KarambitWood.AZURITE);
    }
}
