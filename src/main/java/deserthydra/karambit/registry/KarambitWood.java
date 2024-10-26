package deserthydra.karambit.registry;

import deserthydra.karambit.wood.WoodWood;

public class KarambitWood {
    public static WoodWood ROSEWATER;
    public static WoodWood AZURITE;

    public static void init() {
        ROSEWATER = WoodWood.register("rosewater");
        AZURITE = WoodWood.register("azurite");
    }
}
