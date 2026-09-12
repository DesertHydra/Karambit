package deserthydra.karambit.item;

import deserthydra.karambit.KarambitCommon;
import deserthydra.karambit.block.KarambitBlocks;
import deserthydra.karambit.entity.KarambitEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;

import java.util.function.Function;

public class KarambitItems {

    public static final Item ROSEWATER_BOAT = registerItem("rosewater_boat",
            properties -> new BoatItem(KarambitEntity.ROSEWATER_BOAT, properties.stacksTo(1)));
    public static final Item ROSEWATER_CHEST_BOAT = registerItem("rosewater_chest_boat",
            properties -> new BoatItem(KarambitEntity.ROSEWATER_CHEST_BOAT, properties.stacksTo(1)));

    public static final Item AZURITE_BOAT = registerItem("azurite_boat",
            properties -> new BoatItem(KarambitEntity.AZURITE_BOAT, properties.stacksTo(1)));
    public static final Item AZURITE_CHEST_BOAT = registerItem("azurite_chest_boat",
            properties -> new BoatItem(KarambitEntity.AZURITE_CHEST_BOAT, properties.stacksTo(1)));

    public static final Item ROSEWATER_SIGN = registerItem("rosewater_sign",
            properties -> new SignItem(KarambitBlocks.ROSEWATER_SIGN, KarambitBlocks.ROSEWATER_WALL_SIGN, properties.stacksTo(16)));
    public static final Item ROSEWATER_HANGING_SIGN = registerItem("rosewater_hanging_sign",
            properties -> new HangingSignItem(KarambitBlocks.ROSEWATER_HANGING_SIGN, KarambitBlocks.ROSEWATER_WALL_HANGING_SIGN, properties.stacksTo(16)));

    public static final Item AZURITE_SIGN = registerItem("azurite_sign",
            properties -> new SignItem(KarambitBlocks.AZURITE_SIGN, KarambitBlocks.AZURITE_WALL_SIGN, properties.stacksTo(16)));
    public static final Item AZURITE_HANGING_SIGN = registerItem("azurite_hanging_sign",
            properties -> new HangingSignItem(KarambitBlocks.AZURITE_HANGING_SIGN, KarambitBlocks.AZURITE_WALL_HANGING_SIGN, properties.stacksTo(16)));


    private static Item registerItem(String name, Function<Item.Properties, Item> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(KarambitCommon.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        Item item = factory.apply(new Item.Properties().setId(key));
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void registerModItems() {
        KarambitCommon.LOGGER.info("Registering ModItems for " + KarambitCommon.MOD_ID);
    }

}
