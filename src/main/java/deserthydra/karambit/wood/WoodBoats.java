package deserthydra.karambit.wood;

import deserthydra.karambit.registry.KarambitItems;
import deserthydra.karambit.registry.KarambitRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;

public class WoodBoats {
    public final EntityType<BoatEntity> boat;
    public final EntityType<ChestBoatEntity> chestBoat;

    public WoodBoats(String name, WoodItems items) {
        this.boat = KarambitRegistry.register(
                name + "_boat",
                EntityType.Builder.create(EntityType.getBoatFactory(() -> items.boat), SpawnGroup.MISC)
                        .dropsNothing()
                        .dimensions(1.375F, 0.5625F)
                        .eyeHeight(0.5625F)
                        .maxTrackingRange(10)
        );

        this.chestBoat = KarambitRegistry.register(
                name + "_chest_boat",
                EntityType.Builder.create(EntityType.getChestBoatFactory(() -> items.chestBoat), SpawnGroup.MISC)
                        .dropsNothing()
                        .dimensions(1.375F, 0.5625F)
                        .eyeHeight(0.5625F)
                        .maxTrackingRange(10)
        );
    }
}
