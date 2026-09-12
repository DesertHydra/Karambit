package deserthydra.karambit.block;

import deserthydra.karambit.KarambitCommon;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Function;
import java.util.function.Supplier;

public class KarambitBlocks {
    
    //RW

    public static final Block ROSEWATER_STEM = registerBlock("rosewater_stem",
            RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM));
    public static final Block ROSEWATER_HYPHAE = registerBlock("rosewater_hyphae",
            RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HYPHAE));
    public static final Block STRIPPED_ROSEWATER_STEM = registerBlock("stripped_rosewater_stem",
            RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_STEM));
    public static final Block STRIPPED_ROSEWATER_HYPHAE = registerBlock("stripped_rosewater_hyphae",
            RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_HYPHAE));

    public static final Block ROSEWATER_PLANKS = registerBlock("rosewater_planks",
            Block::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS));
    public static final Block ROSEWATER_SLAB = registerSlabBlock("rosewater_slab");
    public static final Block ROSEWATER_STAIRS = registerStairsBlock("rosewater_stairs", ROSEWATER_PLANKS);
    public static final Block ROSEWATER_FENCE = registerFenceBlock("rosewater_fence");
    public static final Block ROSEWATER_FENCE_GATE = registerFenceGateBlock("rosewater_fence_gate", KarambitWoodTypes.ROSEWATER);
    public static final Block ROSEWATER_DOOR = registerDoorBlock("rosewater_door");
    public static final Block ROSEWATER_TRAPDOOR = registerTrapdoorBlock("rosewater_trapdoor");
    public static final Block ROSEWATER_BUTTON = registerButtonBlock("rosewater_button");
    public static final Block ROSEWATER_PRESSURE_PLATE = registerPressurePlateBlock("rosewater_pressure_plate");

    public static final Block ROSEWATER_SIGN = registerBlockWithoutItem("rosewater_sign",
            properties -> new StandingSignBlock(KarambitWoodTypes.ROSEWATER, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SIGN));
    public static final Block ROSEWATER_WALL_SIGN = registerBlockWithoutItem("rosewater_wall_sign",
            properties -> new WallSignBlock(KarambitWoodTypes.ROSEWATER, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_SIGN));
    public static final Block ROSEWATER_HANGING_SIGN = registerBlockWithoutItem("rosewater_hanging_sign",
            properties -> new CeilingHangingSignBlock(KarambitWoodTypes.ROSEWATER, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HANGING_SIGN));
    public static final Block ROSEWATER_WALL_HANGING_SIGN = registerBlockWithoutItem("rosewater_wall_hanging_sign",
            properties -> new WallHangingSignBlock(KarambitWoodTypes.ROSEWATER, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_HANGING_SIGN));

    
    // AZ

    public static final Block AZURITE_STEM = registerBlock("azurite_stem",
            RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM));
    public static final Block AZURITE_HYPHAE = registerBlock("azurite_hyphae",
            RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HYPHAE));
    public static final Block STRIPPED_AZURITE_STEM = registerBlock("stripped_azurite_stem",
            RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_STEM));
    public static final Block STRIPPED_AZURITE_HYPHAE = registerBlock("stripped_azurite_hyphae",
            RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_HYPHAE));

    public static final Block AZURITE_PLANKS = registerBlock("azurite_planks",
            Block::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS));
    public static final Block AZURITE_SLAB = registerSlabBlock("azurite_slab");
    public static final Block AZURITE_STAIRS = registerStairsBlock("azurite_stairs", AZURITE_PLANKS);
    public static final Block AZURITE_FENCE = registerFenceBlock("azurite_fence");
    public static final Block AZURITE_FENCE_GATE = registerFenceGateBlock("azurite_fence_gate", KarambitWoodTypes.AZURITE);
    public static final Block AZURITE_DOOR = registerDoorBlock("azurite_door");
    public static final Block AZURITE_TRAPDOOR = registerTrapdoorBlock("azurite_trapdoor");
    public static final Block AZURITE_BUTTON = registerButtonBlock("azurite_button");
    public static final Block AZURITE_PRESSURE_PLATE = registerPressurePlateBlock("azurite_pressure_plate");

    public static final Block AZURITE_SIGN = registerBlockWithoutItem("azurite_sign",
            properties -> new StandingSignBlock(KarambitWoodTypes.AZURITE, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SIGN));
    public static final Block AZURITE_WALL_SIGN = registerBlockWithoutItem("azurite_wall_sign",
            properties -> new WallSignBlock(KarambitWoodTypes.AZURITE, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_SIGN));
    public static final Block AZURITE_HANGING_SIGN = registerBlockWithoutItem("azurite_hanging_sign",
            properties -> new CeilingHangingSignBlock(KarambitWoodTypes.AZURITE, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HANGING_SIGN));
    public static final Block AZURITE_WALL_HANGING_SIGN = registerBlockWithoutItem("azurite_wall_hanging_sign",
            properties -> new WallHangingSignBlock(KarambitWoodTypes.AZURITE, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_HANGING_SIGN));





    private static Block registerSlabBlock(String name) {
        return registerBlock(name, SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB));
    }

    private static Block registerStairsBlock(String name, Block baseBlock) {
        return registerBlock(name,
                properties -> new StairBlock(baseBlock.defaultBlockState(), properties),
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS));
    }

    private static Block registerFenceBlock(String name) {
        return registerBlock(name, FenceBlock::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE));
    }

    private static Block registerFenceGateBlock(String name, WoodType woodType) {
        return registerBlock(name,
                properties -> new FenceGateBlock(woodType, properties),
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE_GATE));
    }

    private static Block registerDoorBlock(String name) {
        return registerBlock(name,
                properties -> new DoorBlock(BlockSetType.CRIMSON, properties),
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_DOOR));
    }

    private static Block registerTrapdoorBlock(String name) {
        return registerBlock(name,
                properties -> new TrapDoorBlock(BlockSetType.CRIMSON, properties),
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_TRAPDOOR));
    }

    private static Block registerButtonBlock(String name) {
        return registerBlock(name,
                properties -> new ButtonBlock(BlockSetType.CRIMSON, 30, properties),
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_BUTTON));
    }

    private static Block registerPressurePlateBlock(String name) {
        return registerBlock(name,
                properties -> new PressurePlateBlock(BlockSetType.CRIMSON, properties),
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PRESSURE_PLATE));
    }

    private static Block registerBlock(String name,
                                       Function<BlockBehaviour.Properties, Block> factory,
                                       Supplier<BlockBehaviour.Properties> propertiesSupplier) {
        Identifier id = Identifier.fromNamespaceAndPath(KarambitCommon.MOD_ID, name);
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);
        Block block = factory.apply(propertiesSupplier.get().setId(key));
        Block registeredBlock = Registry.register(BuiltInRegistries.BLOCK, id, block);
        registerBlockItems(name, registeredBlock);
        return registeredBlock;
    }

    private static Block registerBlockWithoutItem(String name,
                                                  Function<BlockBehaviour.Properties, Block> factory,
                                                  Supplier<BlockBehaviour.Properties> propertiesSupplier) {
        Identifier id = Identifier.fromNamespaceAndPath(KarambitCommon.MOD_ID, name);
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);
        Block block = factory.apply(propertiesSupplier.get().setId(key));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    private static void registerBlockItems(String name, Block block) {
        Identifier id = Identifier.fromNamespaceAndPath(KarambitCommon.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        Item.Properties properties = new Item.Properties().setId(key).useBlockDescriptionPrefix();
        Item item = block instanceof DoorBlock
                ? new DoubleHighBlockItem(block, properties)
                : new BlockItem(block, properties);
        Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void registerModBlocks() {
        KarambitCommon.LOGGER.info("Registering Blocks " + KarambitCommon.MOD_ID);
    }


}
