package deserthydra.karambit;

import deserthydra.karambit.mixin.ItemAccessor;
import deserthydra.karambit.registry.KarambitBlocks;
import deserthydra.karambit.registry.KarambitBoats;
import deserthydra.karambit.registry.KarambitItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.RaycastContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class Karambit implements ModInitializer {
	public static final String MOD_ID = "karambit";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@NotNull
	public static Identifier id(@NotNull String path) {
		return Identifier.of(MOD_ID, path);
	}

	@NotNull
	public static ResourceLocation id(@NotNull String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	private static void register() {
		KarambitBlocks.init();
		KarambitBoats.init();
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
			UseItemCallback.EVENT.register((player, world, hand) -> {
				var stack = player.getStackInHand(hand);
				if (stack.isOf(entry.getKey())) {
					var blockHitResult = ItemAccessor.callRaycast(world, player, RaycastContext.FluidHandling.SOURCE_ONLY);
					if (blockHitResult.getType() == HitResult.Type.BLOCK) {
						var blockPos = blockHitResult.getBlockPos();
						if (!world.canPlayerModifyAt(player, blockPos)) {
							return ActionResult.PASS;
						}

						if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
							world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
							if (!player.getAbilities().creativeMode) {
								stack.decrement(1);
							}
							player.setStackInHand(hand, stack);
							player.getInventory().offerOrDrop(entry.getValue().getDefaultStack());
							return ActionResult.SUCCESS;
						}
					}
				}

				return ActionResult.PASS;
			});
		}
	}
}
