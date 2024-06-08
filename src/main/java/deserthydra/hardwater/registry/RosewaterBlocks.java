package deserthydra.hardwater.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static deserthydra.hardwater.HardWater.MOD_ID;
import static net.minecraft.block.Blocks.*;

public class RosewaterBlocks {


    public static final Block ROSEWATER_STEM = register("rosewater_stem", new PillarBlock(FabricBlockSettings.copyOf(CRIMSON_STEM).mapColor(MapColor.PINK)));
    public static final Block ROSEWATER_HYPHAE = register("rosewater_hyphae", new Block(FabricBlockSettings.copyOf(CRIMSON_HYPHAE).mapColor(MapColor.PINK)));

    public static final Block STRIPPED_ROSEWATER_STEM = register("stripped_rosewater_stem.json", new PillarBlock(FabricBlockSettings.copyOf(STRIPPED_CRIMSON_STEM).mapColor(MapColor.PINK)));
    public static final Block STRIPPED_ROSEWATER_HYPHAE = register("stripped_rosewater_hyphae", new Block(FabricBlockSettings.copyOf(STRIPPED_CRIMSON_HYPHAE).mapColor(MapColor.PINK)));

    public static final Block ROSEWATER_PLANKS = register("rosewater_planks", new Block(FabricBlockSettings.copyOf(CRIMSON_PLANKS)));
    public static final Block ROSEWATER_STAIRS = register("rosewater_stairs", new StairsBlock(ROSEWATER_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(CRIMSON_STAIRS)));
    public static final Block ROSEWATER_SLAB = register("rosewater_slab", new SlabBlock(FabricBlockSettings.copyOf(CRIMSON_SLAB)));

    public static final Block ROSEWATER_FENCE = register("rosewater_fence", new FenceBlock(FabricBlockSettings.copyOf(CRIMSON_FENCE)));
    public static final Block ROSEWATER_FENCE_GATE = register("rosewater_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(CRIMSON_FENCE_GATE).mapColor(MapColor.PINK), WoodType.CRIMSON));

    public static final Block ROSEWATER_DOOR = register("rosewater_door", new DoorBlock(FabricBlockSettings.copyOf(CRIMSON_DOOR).mapColor(MapColor.PINK), BlockSetType.CRIMSON));
    public static final Block ROSEWATER_TRAPDOOR = register("rosewater_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(CRIMSON_TRAPDOOR).mapColor(MapColor.PINK), BlockSetType.CRIMSON));
    public static final Block ROSEWATER_PRESSURE_PLATE = register("rosewater_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(CRIMSON_PRESSURE_PLATE).mapColor(MapColor.PINK), BlockSetType.CRIMSON));
    public static final Block ROSEWATER_BUTTON = register("rosewater_button", new ButtonBlock(FabricBlockSettings.copyOf(CRIMSON_BUTTON).mapColor(MapColor.PINK),BlockSetType.CRIMSON, 30, true));

    public static final Block ROSEWATER_SIGN = register("rosewater_sign", new SignBlock(FabricBlockSettings.copyOf(CRIMSON_SIGN), WoodType.CRIMSON));
    public static final Block ROSEWATER_HANGING_SIGN = register("rosewater_hanging_sign", new HangingSignBlock(FabricBlockSettings.copyOf(CRIMSON_HANGING_SIGN), WoodType.CRIMSON));


    private static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, id), block);}

}
