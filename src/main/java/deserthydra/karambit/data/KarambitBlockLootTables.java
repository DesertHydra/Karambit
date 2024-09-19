package deserthydra.karambit.data;

import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.wood.WoodBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class KarambitBlockLootTables extends FabricBlockLootTableProvider {

    public KarambitBlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addWood(KarambitBlocks.AZURITE);
        addWood(KarambitBlocks.ROSEWATER);
    }

    private void addWood(WoodBlocks blocks) {
        addDrop(blocks.button);
        addDrop(blocks.door, this::doorDrops);
        addDrop(blocks.fence);
        addDrop(blocks.fenceGate);
        addDrop(blocks.hangingSign);
        addDrop(blocks.planks);
        addDrop(blocks.pressurePlate);
        addDrop(blocks.sign);
        addDrop(blocks.slab, this::slabDrops);
        addDrop(blocks.stairs);
        addDrop(blocks.stem);
        addDrop(blocks.strippedStem);
        addDrop(blocks.trapdoor);


        if (blocks.hasHyphae()) {
            addDrop(blocks.hyphae);
            addDrop(blocks.strippedHyphae);
        }
    }
}
