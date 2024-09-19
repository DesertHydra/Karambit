package deserthydra.karambit.tags;

import deserthydra.karambit.Karambit;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class KarambitItemTags {
    public static final TagKey<Item> ROSEWATER_STEMS = KarambitItemTags.of("rosewater_stems");
    public static final TagKey<Item> AZURITE_STEMS = KarambitItemTags.of("azurite_stems");
    public static final TagKey<Item> STRIPPED_STEMS = KarambitItemTags.of(Identifier.of("c", "stripped_stems"));
    public static final TagKey<Item> STRIPPED_HYPHAE = KarambitItemTags.of(Identifier.of("c", "stripped_hyphae"));

    @SuppressWarnings("UnnecessaryReturnStatement")
    private KarambitItemTags() {
        return;
    }

    public static TagKey<Item> of(String path) {
        return KarambitItemTags.of(Identifier.of(Karambit.MOD_ID, path));
    }

    public static TagKey<Item> of(Identifier id) {
        return TagKey.of(RegistryKeys.ITEM, id);
    }
}
