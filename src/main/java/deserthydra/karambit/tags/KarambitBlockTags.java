package deserthydra.karambit.tags;

import deserthydra.karambit.Karambit;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class KarambitBlockTags {
    public static final TagKey<Block> ROSEWATER_STEMS = KarambitBlockTags.of("rosewater_stems");
    public static final TagKey<Block> AZURITE_STEMS = KarambitBlockTags.of("azurite_stems");
    public static final TagKey<Block> STRIPPED_STEMS = KarambitBlockTags.of(Identifier.of("c", "stripped_stems"));
    public static final TagKey<Block> STRIPPED_HYPHAE = KarambitBlockTags.of(Identifier.of("c", "stripped_hyphae"));

    @SuppressWarnings("UnnecessaryReturnStatement")
    private KarambitBlockTags() {
        return;
    }

    public static TagKey<Block> of(String path) {
        return KarambitBlockTags.of(Identifier.of(Karambit.MOD_ID, path));
    }

    public static TagKey<Block> of(Identifier id) {
        return TagKey.of(RegistryKeys.BLOCK, id);
    }
}
