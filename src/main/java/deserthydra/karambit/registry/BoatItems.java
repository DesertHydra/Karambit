package deserthydra.karambit.registry;

import deserthydra.karambit.Karambit;
import deserthydra.karambit.util.CustomBoatType;

import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BoatItems {
    public static final Item ROSEWATER_BOAT = new BoatItem(false, CustomBoatType.ROSEWATER, new Item.Settings().maxCount(1));
    public static final Item ROSEWATER_CHEST_BOAT = new BoatItem(true, CustomBoatType.ROSEWATER, new Item.Settings().maxCount(1));

    public static void registerBoats() {
        Registry.register(Registries.ITEM, new Identifier(Karambit.MOD_ID, "rosewater_boat"), ROSEWATER_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Karambit.MOD_ID, "rosewater_chest_boat"), ROSEWATER_CHEST_BOAT);
    }
}
