package deserthydra.karambit;

import deserthydra.karambit.block.KarambitBlocks;
import deserthydra.karambit.entity.KarambitEntity;
import deserthydra.karambit.item.KarambitItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KarambitCommon {

    public static final String  MOD_ID = "karambit";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private KarambitCommon() {
    }

    public static void init() {
        KarambitEntity.registerModEntities();
        KarambitItems.registerModItems();
        KarambitBlocks.registerModBlocks();

    }


}
