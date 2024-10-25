package deserthydra.karambit.registry;

import deserthydra.karambit.wood.WoodItems;

@SuppressWarnings("WeakerAccess")
public class KarambitItems {

    public static WoodItems ROSEWATER;
    public static WoodItems AZURITE;

    public static void init() {
        ROSEWATER = WoodItems.register("rosewater", KarambitBlocks.ROSEWATER, KarambitBoats.ROSEWATER);
        AZURITE = WoodItems.register("azurite", KarambitBlocks.AZURITE, KarambitBoats.AZURITE);
    }
}
