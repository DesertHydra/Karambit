package deserthydra.karambit.data;

import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.tags.KarambitBlockTags;
import deserthydra.karambit.wood.WoodBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class KarambitBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    protected KarambitBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup registries) {

        addWood(KarambitBlockTags.ROSEWATER_STEMS, KarambitBlocks.ROSEWATER);
        addWood(KarambitBlockTags.AZURITE_STEMS, KarambitBlocks.AZURITE);
    }

    private void addWood(TagKey<Block> stemTag, WoodBlocks woodBlock) {
        FabricTagBuilder woodBuilder = getOrCreateTagBuilder(stemTag);
        woodBuilder
                .add(woodBlock.stem)
                .add(woodBlock.strippedStem);
        getOrCreateTagBuilder(KarambitBlockTags.STRIPPED_STEMS).add(woodBlock.strippedStem);

        if (woodBlock.hasHyphae()) {
            woodBuilder
                    .add(woodBlock.hyphae)
                    .add(woodBlock.strippedHyphae);
            getOrCreateTagBuilder(KarambitBlockTags.STRIPPED_HYPHAE).add(woodBlock.strippedHyphae);
        }

        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(woodBlock.fenceGate);
        getOrCreateTagBuilder(BlockTags.PLANKS).add(woodBlock.planks);
        getOrCreateTagBuilder(BlockTags.SLABS).add(woodBlock.slab);
        getOrCreateTagBuilder(BlockTags.STAIRS).add(woodBlock.stairs);
        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(woodBlock.sign);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(woodBlock.wallSign);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(woodBlock.hangingSign);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(woodBlock.wallHangingSign);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(woodBlock.button);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(woodBlock.door);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(woodBlock.fence);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(woodBlock.pressurePlate);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(woodBlock.slab);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(woodBlock.stairs);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(woodBlock.trapdoor);
    }
}
