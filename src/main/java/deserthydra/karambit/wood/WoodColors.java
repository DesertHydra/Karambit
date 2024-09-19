package deserthydra.karambit.wood;

import net.minecraft.block.MapColor;

public class WoodColors {

    public static final WoodColors ROSEWATER;
    public static final WoodColors AZURITE;

    static {
        ROSEWATER = new WoodColors();
        ROSEWATER.planks = MapColor.PINK;
        ROSEWATER.bark = MapColor.TERRACOTTA_LIGHT_BLUE;

        AZURITE = new WoodColors();
        AZURITE.planks = MapColor.BLUE;
        AZURITE.bark = MapColor.BLUE;
    }

    public MapColor bark;
    public MapColor planks;
}
