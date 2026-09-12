package deserthydra.karambit.entity;

import deserthydra.karambit.KarambitCommon;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class KarambitEntity {

    public static final EntityType<Boat> ROSEWATER_BOAT = registerBoat("rosewater_boat");
    public static final EntityType<ChestBoat> ROSEWATER_CHEST_BOAT = registerChestBoat("rosewater_chest_boat");

    public static final EntityType<Boat> AZURITE_BOAT = registerBoat("azurite_boat");
    public static final EntityType<ChestBoat> AZURITE_CHEST_BOAT = registerChestBoat("azurite_chest_boat");

    private static EntityType<Boat> registerBoat(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(KarambitCommon.MOD_ID, name);
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, id);
        Supplier<Item> itemSupplier = () -> BuiltInRegistries.ITEM.getValue(id);
        EntityType<Boat> type = EntityType.Builder.<Boat>of(
                        (entityType, level) -> new Boat(entityType, level, itemSupplier),
                        MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625f)
                .clientTrackingRange(10)
                .updateInterval(1)
                .build(key);
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id, type);
    }

    private static EntityType<ChestBoat> registerChestBoat(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(KarambitCommon.MOD_ID, name);
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, id);
        Supplier<Item> itemSupplier = () -> BuiltInRegistries.ITEM.getValue(id);
        EntityType<ChestBoat> type = EntityType.Builder.<ChestBoat>of(
                        (entityType, level) -> new ChestBoat(entityType, level, itemSupplier),
                        MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625f)
                .clientTrackingRange(10)
                .updateInterval(1)
                .build(key);
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id, type);
    }

    public static void registerModEntities() {
        KarambitCommon.LOGGER.info("Registering ModEntities for " + KarambitCommon.MOD_ID);
    }
    
}
