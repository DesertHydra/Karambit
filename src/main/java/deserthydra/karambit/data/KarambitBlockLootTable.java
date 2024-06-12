package deserthydra.karambit.data;

import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.wood.WoodBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class KarambitBlockLootTable extends FabricBlockLootTableProvider {
    protected KarambitBlockLootTable(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(){
        addWoodDrops(KarambitBlocks.AZURITE);
    }

    private void addWoodDrops(WoodBlocks woodBlock){
        addDrop(woodBlock.button);
        addDrop(woodBlock.door, this::doorDrops);
        addDrop(woodBlock.fence);
        addDrop(woodBlock.fenceGate);
        addDrop(woodBlock.hangingSign);
        addDrop(woodBlock.stem);
        addDrop(woodBlock.planks);
        addDrop(woodBlock.pressurePlate);
        addDrop(woodBlock.sign);
        addDrop(woodBlock.slab, this::slabDrops);
        addDrop(woodBlock.stairs);
        addDrop(woodBlock.strippedStem);
        addDrop(woodBlock.trapdoor);
        addDrop(woodBlock.wallHangingSign);
        addDrop(woodBlock.wallSign);

        if (woodBlock.hasHyphae()) {
            addDrop(woodBlock.hyphae);
            addDrop(woodBlock.strippedHyphae);
        }

    }
}
