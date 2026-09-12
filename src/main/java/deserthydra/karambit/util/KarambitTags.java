package deserthydra.karambit.util;

import deserthydra.karambit.KarambitCommon;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;


public class KarambitTags {

    public static final TagKey<Item> ROSEWATER_STEM = createTag("rosewater_stem");
    public static final TagKey<Item> AZURITE_STEM = createTag("azurite_stem");

    private static TagKey<Item> createTag(String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(KarambitCommon.MOD_ID, name));
    }
}
