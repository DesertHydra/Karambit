package deserthydra.karambit;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import deserthydra.karambit.registry.KarambitBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class KarambitClient implements ClientModInitializer {
    @SuppressWarnings("unused")
    private static final RenderLayer DOOR_BLOCK_LAYER = RenderLayer.getCutout();
    private static final RenderLayer PLANT_BLOCK_LAYER = RenderLayer.getCutout();

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlocks(
                DOOR_BLOCK_LAYER,
                KarambitBlocks.ROSEWATER.door,
                KarambitBlocks.AZURITE.door
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(
                PLANT_BLOCK_LAYER,
                KarambitBlocks.ROSEWATER.stem,
                KarambitBlocks.ROSEWATER.strippedStem,
                KarambitBlocks.AZURITE.stem,
                KarambitBlocks.AZURITE.strippedStem
        );

                BlockRenderLayerMap.INSTANCE.putBlock(
                KarambitBlocks.ROSEWATER.trapdoor, RenderLayer.getCutout());

        registerEntityRenderers();
    }

    private void registerEntityRenderers() {
        TerraformBoatClientHelper.registerModelLayers(Identifier.of(Karambit.MOD_ID, "rosewater"), false);
        TerraformBoatClientHelper.registerModelLayers(Identifier.of(Karambit.MOD_ID, "azurite"), false);
    }
}
