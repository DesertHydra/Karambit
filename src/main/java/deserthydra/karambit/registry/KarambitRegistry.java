package deserthydra.karambit.registry;

import deserthydra.karambit.Karambit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.BiFunction;
import java.util.function.Function;

public class KarambitRegistry {
    @SuppressWarnings("UnnecessaryReturnStatement")
    public KarambitRegistry() { return; }

    public static Item registerBlockItem(Block block) {
        return register(block, BlockItem::new, new Item.Settings());
    }

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
        var key = RegistryKey.of(RegistryKeys.ITEM, block.getRegistryEntry().registryKey().getValue());
        return register(
                key, settings_ -> factory.apply(block, settings_), settings.useBlockPrefixedTranslationKey()
        );
    }

    public static <I extends Item> I register(String name, Function<Item.Settings, I> factory, Item.Settings settings) {
        var key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Karambit.MOD_ID, name));
        return Registry.register(Registries.ITEM, key, factory.apply(settings.registryKey(key)));
    }

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    public static <B extends Block> B register(String name, B block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Karambit.MOD_ID, name), block);
    }

    public static <B extends Block> B register(String name, Function<AbstractBlock.Settings, B> factory, AbstractBlock.Settings settings) {
        var key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Karambit.MOD_ID, name));
        return Registry.register(Registries.BLOCK, key, factory.apply(settings.registryKey(key)));
    }

    public static <E extends Entity> EntityType<E> register(String name, EntityType.Builder<E> entityType) {
        return Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(Karambit.MOD_ID, name),
                entityType.build(
                        RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Karambit.MOD_ID, name))
                )
        );
    }
}


