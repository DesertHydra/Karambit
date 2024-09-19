package deserthydra.karambit.wood;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import deserthydra.karambit.Karambit;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class WoodBoats {
    public static TerraformBoatType register(String path, BlockItem planks) {
        Identifier typeId = Identifier.of(Karambit.MOD_ID, path);
        Identifier boatId = Identifier.of(Karambit.MOD_ID, path + "_boat");
        Identifier chestId = Identifier.of(Karambit.MOD_ID, path + "_chest_boat");
        RegistryKey<TerraformBoatType> boatKey = TerraformBoatTypeRegistry.createKey(typeId);

        return Registry.register(TerraformBoatTypeRegistry.INSTANCE, typeId,
                new TerraformBoatType.Builder()
                        .item(TerraformBoatItemHelper.registerBoatItem(boatId, boatKey, false))
                        .chestItem(TerraformBoatItemHelper.registerBoatItem(chestId, boatKey, true))
                        .planks(planks)
                        .build());
    }
}
