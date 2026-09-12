package deserthydra.karambit;

import deserthydra.karambit.client.KarambitModelLayers;
import deserthydra.karambit.entity.KarambitEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import org.intellij.lang.annotations.Identifier;
import org.w3c.dom.Text;

public class KarambitClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerModelLayers();
        registerBoatRenderers();

    }

    private static void registerModelLayers() {

        ModelLayerRegistry.registerModelLayer(KarambitModelLayers.ROSEWATER_BOAT, BoatModel::createBoatModel);
        ModelLayerRegistry.registerModelLayer(KarambitModelLayers.ROSEWATER_CHEST_BOAT, BoatModel::createChestBoatModel);
        ModelLayerRegistry.registerModelLayer(KarambitModelLayers.AZURITE_BOAT, BoatModel::createBoatModel);
        ModelLayerRegistry.registerModelLayer(KarambitModelLayers.AZURITE_CHEST_BOAT, BoatModel::createChestBoatModel);
    }

    private static void registerBoatRenderers() {
        EntityRenderers.register(KarambitEntity.ROSEWATER_BOAT, context -> new BoatRenderer(context, KarambitModelLayers.ROSEWATER_BOAT));
        EntityRenderers.register(KarambitEntity.ROSEWATER_CHEST_BOAT, context -> new BoatRenderer(context, KarambitModelLayers.ROSEWATER_CHEST_BOAT));
        EntityRenderers.register(KarambitEntity.AZURITE_BOAT, context -> new BoatRenderer(context, KarambitModelLayers.AZURITE_BOAT));
        EntityRenderers.register(KarambitEntity.AZURITE_CHEST_BOAT, context -> new BoatRenderer(context, KarambitModelLayers.AZURITE_CHEST_BOAT));
    }

}
