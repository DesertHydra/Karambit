package deserthydra.hardwater;

import deserthydra.hardwater.registry.RosewaterBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class HardWaterClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(RosewaterBlocks.ROSEWATER_TRAPDOOR, RenderLayer.getCutout());
    }
}
