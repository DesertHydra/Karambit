package deserthydra.karambit;

import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.registry.KarambitItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodType;
import net.minecraft.item.Item;
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

import java.util.Map;


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

		var washableToWashedMap = Map.ofEntries(
				Map.entry(Items.CRIMSON_STEM, KarambitItems.ROSEWATER.stem),
				Map.entry(Items.CRIMSON_HYPHAE, KarambitItems.ROSEWATER.hyphae),
				Map.entry(Items.STRIPPED_CRIMSON_STEM, KarambitItems.ROSEWATER.strippedStem),
				Map.entry(Items.STRIPPED_CRIMSON_HYPHAE, KarambitItems.ROSEWATER.strippedHyphae),
				Map.entry(Items.CRIMSON_PLANKS, KarambitItems.ROSEWATER.planks),
				Map.entry(Items.CRIMSON_STAIRS, KarambitItems.ROSEWATER.stairs),
				Map.entry(Items.CRIMSON_SLAB, KarambitItems.ROSEWATER.slab),
				Map.entry(Items.WARPED_STEM, KarambitItems.AZURITE.stem),
				Map.entry(Items.WARPED_HYPHAE, KarambitItems.AZURITE.hyphae),
				Map.entry(Items.STRIPPED_WARPED_STEM, KarambitItems.AZURITE.strippedStem),
				Map.entry(Items.STRIPPED_WARPED_HYPHAE, KarambitItems.AZURITE.strippedHyphae),
				Map.entry(Items.WARPED_PLANKS, KarambitItems.AZURITE.planks),
				Map.entry(Items.WARPED_STAIRS, KarambitItems.AZURITE.stairs),
				Map.entry(Items.WARPED_SLAB, KarambitItems.AZURITE.slab));

		for (var entry: washableToWashedMap.entrySet()) {
			UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
				if (player.getStackInHand(hand).getItem().equals(entry.getKey()) && !player.isSpectator() &&
						world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.WATER)){
					player.getInventory().offerOrDrop(entry.getValue().getDefaultStack());
					player.getStackInHand(hand).decrement(1);
					player.playSound(SoundEvent.of(SoundEvents.BLOCK_GRINDSTONE_USE.getId()), SoundCategory.BLOCKS, 1.0F, 1.0F);
					return ActionResult.SUCCESS;
				}

				return ActionResult.PASS;
			});
		}
	}
}