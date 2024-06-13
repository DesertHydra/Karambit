package deserthydra.karambit;

import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.registry.KarambitItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
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