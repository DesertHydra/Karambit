package deserthydra.karambit.data;

import deserthydra.karambit.registry.KarambitItems;
import deserthydra.karambit.tags.KarambitBlockTags;
import deserthydra.karambit.tags.KarambitItemTags;
import deserthydra.karambit.wood.WoodItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class KarambitItemTagProvider extends FabricTagProvider.ItemTagProvider {
    protected KarambitItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, BlockTagProvider blockTagProvider) {
        super(output, registriesFuture, blockTagProvider);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup registries) {
        copy(BlockTags.BUTTONS, ItemTags.BUTTONS);

        copy(BlockTags.DIRT, ItemTags.DIRT);

        copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);

        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);

        copy(BlockTags.OAK_LOGS, ItemTags.OAK_LOGS);

        copy(BlockTags.PLANKS, ItemTags.PLANKS);

        copy(BlockTags.SAND, ItemTags.SAND);

        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

        copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);

        copy(BlockTags.SLABS, ItemTags.SLABS);

        copy(BlockTags.STAIRS, ItemTags.STAIRS);

        copy(BlockTags.WALLS, ItemTags.WALLS);

        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);

        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);

        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);

        copy(KarambitBlockTags.STRIPPED_STEMS, KarambitItemTags.STRIPPED_STEMS);

        copy(KarambitBlockTags.STRIPPED_HYPHAE, KarambitItemTags.STRIPPED_HYPHAE);

        // wood type tags
        copy(KarambitBlockTags.ROSEWATER_STEMS, KarambitItemTags.ROSEWATER_STEMS);
        copy(KarambitBlockTags.AZURITE_STEMS, KarambitItemTags.AZURITE_STEMS);

        // wood items
        addWood(KarambitItems.ROSEWATER);
        addWood(KarambitItems.AZURITE);
    }

    private void addWood(WoodItems woodItem) {
        // Add boats if they exist via the WoodItem.
        if (woodItem.boat != null) {
            getOrCreateTagBuilder(ItemTags.BOATS).add(woodItem.boat);
        }
        if (woodItem.chestBoat != null) {
            getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(woodItem.chestBoat);
        }
    }
}

