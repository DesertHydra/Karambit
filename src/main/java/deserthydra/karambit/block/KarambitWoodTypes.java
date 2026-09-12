package deserthydra.karambit.block;

import deserthydra.karambit.KarambitCommon;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class KarambitWoodTypes {
    public static final WoodType ROSEWATER = register("rosewater");
    public static final WoodType AZURITE = register("azurite");


    private KarambitWoodTypes() {
    }

    private static WoodType register(String name) {
        return WoodTypeBuilder.copyOf(WoodType.OAK)
                .register(Identifier.fromNamespaceAndPath(KarambitCommon.MOD_ID, name), BlockSetType.OAK);
    }
}
