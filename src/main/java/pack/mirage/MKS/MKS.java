package pack.mirage.MKS;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.item.Items.FLINT;
import static net.minecraft.registry.tag.BlockTags.LOGS;


public class MKS implements ModInitializer {
	public static final String MOD_ID = "mirage-kitchen-sink";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		ItemRegistry.register();

		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

			if (player.getMainHandStack().isEmpty() &&
				!player.isCreative() && !player.isSpectator() &&
				world.getBlockState(pos).isIn(LOGS)){
					return ActionResult.SUCCESS;
				}

			return ActionResult.PASS;
		});

		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {

            if (player.getStackInHand(hand).getItem() == Items.FLINT && !player.isSpectator() &&
					world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.STONE)) {
				player.giveItemStack(ItemRegistry.SHARP_FLINT.getDefaultStack());
				player.getMainHandStack().decrement(1);
				return ActionResult.SUCCESS;
			}

			return ActionResult.PASS;

		});

	}


}