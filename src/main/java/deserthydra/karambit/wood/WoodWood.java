package deserthydra.karambit.wood;

import deserthydra.karambit.Karambit;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;

public class WoodWood {
    public final BlockSetType blockSetType;
    public final WoodType woodType;

    private WoodWood(BlockSetType blockSetType, WoodType woodType) {
        this.blockSetType = blockSetType;
        this.woodType = woodType;
    }

    public static WoodWood register(String name) {
        var blockSetType = BlockSetTypeBuilder.copyOf(BlockSetType.CRIMSON).register(Karambit.id(name));
        var woodType = WoodTypeBuilder.copyOf(WoodType.CRIMSON).register(Karambit.id(name), blockSetType);

        return new WoodWood(blockSetType, woodType);
    }
}
