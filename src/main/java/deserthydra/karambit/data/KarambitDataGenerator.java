package deserthydra.karambit.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class KarambitDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        var pack = generator.createPack();

        var blockTags = pack.addProvider(KarambitBlockTagProvider::new);
        pack.addProvider((output, lookup) -> new KarambitItemTagProvider(output, lookup, blockTags));
        pack.addProvider(KarambitRecipeProvider::new);
        pack.addProvider(KarambitBlockLootTables::new);
    }
}
