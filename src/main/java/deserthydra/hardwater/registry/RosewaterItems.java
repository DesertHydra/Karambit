package deserthydra.hardwater.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static deserthydra.hardwater.HardWater.MOD_ID;

public class RosewaterItems {

    public static final Item ROSEWATER_STEM = register("rosewater_stem", new BlockItem(RosewaterBlocks.ROSEWATER_STEM, new FabricItemSettings()));
    public static final Item ROSEWATER_HYPHAE = register("rosewater_hyphae", new BlockItem(RosewaterBlocks.ROSEWATER_HYPHAE, new FabricItemSettings()));

    public static final Item STRIPPED_ROSEWATER_STEM = register("stripped_rosewater_stem.json", new BlockItem(RosewaterBlocks.STRIPPED_ROSEWATER_STEM, new FabricItemSettings()));
    public static final Item STRIPPED_ROSEWATER_HYPHAE = register("stripped_rosewater_hyphae", new BlockItem(RosewaterBlocks.STRIPPED_ROSEWATER_HYPHAE, new FabricItemSettings()));

    public static final Item ROSEWATER_PLANKS = register("rosewater_planks", new BlockItem(RosewaterBlocks.ROSEWATER_PLANKS, new FabricItemSettings()));
    public static final Item ROSEWATER_STAIRS = register("rosewater_stairs", new BlockItem(RosewaterBlocks.ROSEWATER_STAIRS, new FabricItemSettings()));
    public static final Item ROSEWATER_SLAB = register("rosewater_slab", new BlockItem(RosewaterBlocks.ROSEWATER_SLAB, new FabricItemSettings()));

    public static final Item ROSEWATER_FENCE = register("rosewater_fence", new BlockItem(RosewaterBlocks.ROSEWATER_FENCE, new FabricItemSettings()));
    public static final Item ROSEWATER_FENCE_GATE = register("rosewater_fence_gate", new BlockItem(RosewaterBlocks.ROSEWATER_FENCE_GATE, new FabricItemSettings()));

    public static final Item ROSEWATER_DOOR = register("rosewater_door", new BlockItem(RosewaterBlocks.ROSEWATER_DOOR, new FabricItemSettings()));
    public static final Item ROSEWATER_TRAPDOOR = register("rosewater_trapdoor", new BlockItem(RosewaterBlocks.ROSEWATER_TRAPDOOR, new FabricItemSettings()));
    public static final Item ROSEWATER_PRESSURE_PLATE = register("rosewater_pressure_plate", new BlockItem(RosewaterBlocks.ROSEWATER_PRESSURE_PLATE, new FabricItemSettings()));
    public static final Item ROSEWATER_BUTTON = register("rosewater_button", new BlockItem(RosewaterBlocks.ROSEWATER_BUTTON, new FabricItemSettings()));

    public static final Item ROSEWATER_SIGN = register("rosewater_sign", new BlockItem(RosewaterBlocks.ROSEWATER_SIGN, new FabricItemSettings()));
    public static final Item ROSEWATER_HANGING_SIGN = register("rosewater_hanging_sign", new BlockItem(RosewaterBlocks.ROSEWATER_HANGING_SIGN, new FabricItemSettings()));


    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, id), item);}

}
