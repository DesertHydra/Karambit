package deserthydra.karambit;

import deserthydra.karambit.registry.KarambitBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class KarambitClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(
                KarambitBlocks.ROSEWATER.trapdoor, RenderLayer.getCutout());
    }
}
