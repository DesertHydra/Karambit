package deserthydra.karambit.data;

import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.registry.KarambitItems;
import deserthydra.karambit.wood.WoodBlocks;
import deserthydra.karambit.wood.WoodBoats;
import deserthydra.karambit.wood.WoodItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class KarambitItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public KarambitItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        copy(BlockTags.LOGS, ItemTags.LOGS);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);


        nonFlammableWood(KarambitItems.AZURITE);
        nonFlammableWood(KarambitItems.ROSEWATER);

        boats(KarambitItems.AZURITE);
        chestBoats(KarambitItems.AZURITE);
        boats(KarambitItems.ROSEWATER);
        chestBoats(KarambitItems.ROSEWATER);

        copyLogsTag(KarambitBlocks.AZURITE, KarambitItems.AZURITE);
        copyLogsTag(KarambitBlocks.ROSEWATER, KarambitItems.ROSEWATER);
    }

    private void boats(WoodItems items) {
        getOrCreateTagBuilder(ItemTags.BOATS)
                .add(
                        items.boat);
    }

    private void chestBoats(WoodItems items) {
        getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
                .add(
                        items.chestBoat);
    }

    private void nonFlammableWood(WoodItems items) {
        var nonFlammableWoodTag = getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
                .add(
                        items.strippedStem,
                        items.stem,
                        items.planks,
                        items.slab,
                        items.pressurePlate,
                        items.fence,
                        items.trapdoor,
                        items.fenceGate,
                        items.stairs,
                        items.button,
                        items.door,
                        items.sign,
                        items.hangingSign
                );

        if(items.hasHyphae()) {
            nonFlammableWoodTag.add(items.hyphae, items.strippedHyphae);
        }

        if(items.hasBoat()) {
            nonFlammableWoodTag.add(items.boat, items.chestBoat);
        }
    }

    private void copyLogsTag(WoodBlocks blocks, WoodItems items) {
        copy(blocks.logsTag, items.logsTag);
    }
}
