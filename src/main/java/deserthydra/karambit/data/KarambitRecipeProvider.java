package deserthydra.karambit.data;

import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.registry.KarambitItems;
import deserthydra.karambit.wood.WoodBlocks;
import deserthydra.karambit.wood.WoodItems;
import net.minecraft.data.DataOutput;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlags;

import java.util.concurrent.CompletableFuture;

public class KarambitRecipeProvider extends RecipeProvider {

    public KarambitRecipeProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        createBlockFamily(KarambitItems.AZURITE, KarambitBlocks.AZURITE, exporter);
        createBlockFamily(KarambitItems.ROSEWATER, KarambitBlocks.ROSEWATER, exporter);
    }

    private static void createBlockFamily(WoodItems items, WoodBlocks blocks, RecipeExporter exporter) {

        var blockFamily = BlockFamilies.register(blocks.planks)
                .button(blocks.button)
                .fence(blocks.fence)
                .fenceGate(blocks.fenceGate)
                .pressurePlate(blocks.pressurePlate)
                .sign(blocks.sign, blocks.wallSign)
                .slab(blocks.slab)
                .stairs(blocks.stairs)
                .door(blocks.door)
                .trapdoor(blocks.trapdoor)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();

        generateFamily(exporter, blockFamily, FeatureFlags.VANILLA_FEATURES);
        offerPlanksRecipe(exporter, blocks.planks, items.logsTag, 4);
        offerHangingSignRecipe(exporter, blocks.hangingSign, blocks.strippedStem);

        if (blocks.hasHyphae()) {
            offerBarkBlockRecipe(exporter, blocks.hyphae, blocks.stem);
        }

        if (items.hasBoat()) {
            offerBoatRecipe(exporter, items.boat, blocks.planks);
            offerChestBoatRecipe(exporter, items.chestBoat, items.boat);
        }
    }
}
