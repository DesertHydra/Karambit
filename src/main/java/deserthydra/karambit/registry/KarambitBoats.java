package deserthydra.karambit.registry;

import deserthydra.karambit.wood.WoodBoats;

public class KarambitBoats {
    public static WoodBoats ROSEWATER;
    public static WoodBoats AZURITE;

    public static void init() {
        ROSEWATER = new WoodBoats("rosewater", KarambitItems.ROSEWATER);
        AZURITE = new WoodBoats("azurite", KarambitItems.AZURITE);
    }
}
