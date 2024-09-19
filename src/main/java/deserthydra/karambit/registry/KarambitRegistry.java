package deserthydra.karambit.registry;

import deserthydra.karambit.Karambit;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class KarambitRegistry {
    @SuppressWarnings("UnnecessaryReturnStatement")
    public KarambitRegistry() { return; }

    public static BlockItem registerBlockItem(String name, Block block) {
        BlockItem item = new BlockItem(block, new Item.Settings());
        return register(name, item);
    }

    public static <I extends Item> I register(String name, I item) {
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, blockItem);
        }
        return Registry.register(Registries.ITEM, Identifier.of(Karambit.MOD_ID, name), item);
    }

    public static <B extends Block> B register(String name, B block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Karambit.MOD_ID, name), block);
    }

}


