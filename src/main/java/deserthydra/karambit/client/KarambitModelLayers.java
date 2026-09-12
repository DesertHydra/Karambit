package deserthydra.karambit.client;

import deserthydra.karambit.KarambitCommon;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class KarambitModelLayers {

    public static final ModelLayerLocation ROSEWATER_BOAT = create("boat/rosewater");
    public static final ModelLayerLocation ROSEWATER_CHEST_BOAT = create("chest_boat/rosewater");
    public static final ModelLayerLocation AZURITE_BOAT = create("boat/azurite");
    public static final ModelLayerLocation AZURITE_CHEST_BOAT = create("chest_boat/azurite");

    private KarambitModelLayers() {
    }

    private static ModelLayerLocation create(String path) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(KarambitCommon.MOD_ID, path), "main");
    }
}
