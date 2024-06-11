package deserthydra.karambit;

import com.google.common.reflect.Reflection;
import deserthydra.karambit.registry.CreativeTabOrder;
import deserthydra.karambit.registry.RosewaterBlocks;
import deserthydra.karambit.registry.RosewaterItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Karambit implements ModInitializer {
	public static final String MOD_ID = "karambit";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CreativeTabOrder.register();
		Reflection.initialize(RosewaterBlocks.class, RosewaterItems.class);
		RosewaterBlocks.registerBlockProperties();
	}
}