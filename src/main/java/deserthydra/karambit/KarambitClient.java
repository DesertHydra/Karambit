package deserthydra.karambit;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import deserthydra.karambit.registry.KarambitBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class KarambitClient implements ClientModInitializer {
    @SuppressWarnings("unused")
    private static final RenderLayer DOOR_BLOCK_LAYER = RenderLayer.getCutout();
    private static final RenderLayer TRAPDOOR_BLOCK_LAYER = RenderLayer.getCutout();
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
                KarambitBlocks.AZURITE.strippedStem);

        BlockRenderLayerMap.INSTANCE.putBlocks(
                TRAPDOOR_BLOCK_LAYER,
                KarambitBlocks.ROSEWATER.trapdoor,
                KarambitBlocks.AZURITE.trapdoor);

        ResourceManagerHelper.registerBuiltinResourcePack(
                Identifier.of(Karambit.MOD_ID, "karambit_overrides"),
                FabricLoader.getInstance().getModContainer(Karambit.MOD_ID).orElseThrow(),
                Text.translatable("resourcepack.karambit.name"),
                ResourcePackActivationType.ALWAYS_ENABLED
        );

        registerEntityRenderers();
    }

    private void registerEntityRenderers() {
        TerraformBoatClientHelper.registerModelLayers(Identifier.of(Karambit.MOD_ID, "rosewater"), false);
        TerraformBoatClientHelper.registerModelLayers(Identifier.of(Karambit.MOD_ID, "azurite"), false);
    }
}
