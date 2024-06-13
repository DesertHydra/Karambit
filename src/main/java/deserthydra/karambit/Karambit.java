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

	public static final Map<Item, Item> CRIMSON_TO_ROSEWATER = Map.of(
			Items.CRIMSON_STEM, KarambitItems.ROSEWATER.stem,
			Items.CRIMSON_HYPHAE, KarambitItems.ROSEWATER.hyphae,
			Items.STRIPPED_CRIMSON_STEM, KarambitItems.ROSEWATER.strippedStem,
			Items.STRIPPED_CRIMSON_HYPHAE, KarambitItems.ROSEWATER.strippedHyphae,
			Items.CRIMSON_PLANKS, KarambitItems.ROSEWATER.planks,
			Items.CRIMSON_STAIRS, KarambitItems.ROSEWATER.stairs,
			Items.CRIMSON_SLAB, KarambitItems.ROSEWATER.slab);


	public static final Map<Item, Item> WARPED_TO_AZURITE = Map.of(

			Items.WARPED_STEM, KarambitItems.AZURITE.stem,
			Items.WARPED_HYPHAE, KarambitItems.AZURITE.hyphae,
			Items.STRIPPED_WARPED_STEM, KarambitItems.AZURITE.strippedStem,
			Items.STRIPPED_WARPED_HYPHAE, KarambitItems.AZURITE.strippedHyphae,
			Items.WARPED_PLANKS, KarambitItems.AZURITE.planks,
			Items.WARPED_STAIRS, KarambitItems.AZURITE.stairs,
			Items.WARPED_SLAB, KarambitItems.AZURITE.slab);



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

		for (var entry: CRIMSON_TO_ROSEWATER.entrySet()) {
			System.out.println("Hey I got crimson! " + entry.getKey().toString());
			System.out.println("and I got rosewater! " + entry.getValue().toString());

			UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
				if (player.getStackInHand(hand).INTIEMHERE && player.isSpectator() &&
						world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.WATER)){
					player.getInventory().offerOrDrop(Items.OUTITEMHERE.getDefaultStack());
					player.getMainHandStack().decrement(1);
					player.playSound(SoundEvent.of(SoundEvents.BLOCK_GRINDSTONE_USE.getId()), SoundCategory.BLOCKS, 1.0F, 1.0F);
					return ActionResult.SUCCESS;

				}
			};
		}
	}
}