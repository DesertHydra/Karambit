package deserthydra.karambit;

import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.registry.KarambitItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Karambit implements ModInitializer {
	public static final String MOD_ID = "karambit";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@NotNull
	public static Identifier id(@NotNull String path) {
		return new Identifier(MOD_ID, path);
	}

	private static void register() {
		KarambitBlocks.init();
		KarambitItems.init();

	}

	@Override
	public void onInitialize() {
		CreativeTabOrder.register();
		register();
	}
}