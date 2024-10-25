package deserthydra.karambit.data;

import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.registry.KarambitItems;
import deserthydra.karambit.wood.WoodBlocks;
import deserthydra.karambit.wood.WoodItems;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlags;

public class KarambitRecipeGenerator extends RecipeGenerator {

    public KarambitRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
    }

    @Override
    public void generate() {
        createBlockFamily(KarambitItems.AZURITE, KarambitBlocks.AZURITE, exporter);
        createBlockFamily(KarambitItems.ROSEWATER, KarambitBlocks.ROSEWATER, exporter);
    }

    private void createBlockFamily(WoodItems items, WoodBlocks blocks, RecipeExporter exporter) {

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

        generateFamily(blockFamily, FeatureFlags.VANILLA_FEATURES);
        offerPlanksRecipe(blocks.planks, items.logsTag, 4);
        offerHangingSignRecipe(blocks.hangingSign, blocks.strippedStem);

        if (blocks.hasHyphae()) {
            offerBarkBlockRecipe(blocks.hyphae, blocks.stem);
        }

        if (items.hasBoat()) {
            offerBoatRecipe(items.boat, blocks.planks);
            offerChestBoatRecipe(items.chestBoat, items.boat);
        }
    }
}
