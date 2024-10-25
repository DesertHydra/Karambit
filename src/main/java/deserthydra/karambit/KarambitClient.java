package deserthydra.karambit;

import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.registry.KarambitBoats;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
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

        BlockEntityType.SIGN.addSupportedBlock(KarambitBlocks.ROSEWATER.sign);
        BlockEntityType.SIGN.addSupportedBlock(KarambitBlocks.AZURITE.sign);
        BlockEntityType.SIGN.addSupportedBlock(KarambitBlocks.ROSEWATER.wallSign);
        BlockEntityType.SIGN.addSupportedBlock(KarambitBlocks.AZURITE.wallSign);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(KarambitBlocks.ROSEWATER.hangingSign);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(KarambitBlocks.AZURITE.hangingSign);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(KarambitBlocks.ROSEWATER.wallHangingSign);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(KarambitBlocks.AZURITE.wallHangingSign);

        ResourceManagerHelper.registerBuiltinResourcePack(
                Identifier.of(Karambit.MOD_ID, "karambit_overrides"),
                FabricLoader.getInstance().getModContainer(Karambit.MOD_ID).orElseThrow(),
                Text.translatable("resourcepack.karambit.name"),
                ResourcePackActivationType.ALWAYS_ENABLED
        );

        registerEntityRenderers();
    }

    private void registerEntityRenderers() {
        var rosewaterModelLayer = new EntityModelLayer(Identifier.of(Karambit.MOD_ID, "boat/rosewater"), "main");
        EntityModelLayerRegistry.registerModelLayer(rosewaterModelLayer, BoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(KarambitBoats.ROSEWATER.boat, context -> new BoatEntityRenderer(context, rosewaterModelLayer));

        var rosewaterChestModelLayer = new EntityModelLayer(Identifier.of(Karambit.MOD_ID, "chest_boat/rosewater"), "main");
        EntityModelLayerRegistry.registerModelLayer(rosewaterChestModelLayer, BoatEntityModel::getChestTexturedModelData);
        EntityRendererRegistry.register(KarambitBoats.ROSEWATER.chestBoat, context -> new BoatEntityRenderer(context, rosewaterChestModelLayer));

        var azuriteModelLayer = new EntityModelLayer(Identifier.of(Karambit.MOD_ID, "boat/azurite"), "main");
        EntityModelLayerRegistry.registerModelLayer(azuriteModelLayer, BoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(KarambitBoats.AZURITE.boat, context -> new BoatEntityRenderer(context, azuriteModelLayer));

        var azuriteChestModelLayer = new EntityModelLayer(Identifier.of(Karambit.MOD_ID, "chest_boat/azurite"), "main");
        EntityModelLayerRegistry.registerModelLayer(azuriteChestModelLayer, BoatEntityModel::getChestTexturedModelData);
        EntityRendererRegistry.register(KarambitBoats.AZURITE.chestBoat, context -> new BoatEntityRenderer(context, azuriteChestModelLayer));
    }
}
