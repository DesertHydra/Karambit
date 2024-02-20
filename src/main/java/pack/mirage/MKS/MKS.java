package pack.mirage.MKS;

import com.mojang.brigadier.ParseResults;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.item.Items.FLINT;
import static net.minecraft.registry.tag.BlockTags.LOGS;
import static pack.mirage.MKS.ItemRegistry.DEEPSLATE_DIAMOND;
import static pack.mirage.MKS.ItemRegistry.STONE_DIAMOND;


public class MKS implements ModInitializer {
	public static final String MOD_ID = "mirage-kitchen-sink";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ItemRegistry.register();

		// trees
		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

			if (player.getMainHandStack().isEmpty() &&
				!player.isCreative() && !player.isSpectator() &&
				world.getBlockState(pos).isIn(LOGS)){
					return ActionResult.SUCCESS;
				}

			return ActionResult.PASS;
		});

		// flint
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {

            if (player.getStackInHand(hand).getItem() == Items.FLINT && !player.isSpectator() &&
					world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.STONE)) {
				player.giveItemStack(ItemRegistry.SHARP_FLINT.getDefaultStack());
				player.getMainHandStack().decrement(1);
				world.playSound(player, hitResult.getBlockPos(), SoundEvent.of(SoundEvents.ITEM_FLINTANDSTEEL_USE.getId()), SoundCategory.PLAYERS, 1.0F, 1.0F);
				return ActionResult.SUCCESS;
			}

			return ActionResult.PASS;

		});

		// stone diamond
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {

			if (player.getStackInHand(hand).getItem() == STONE_DIAMOND && !player.isSpectator() &&
				world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.GRINDSTONE)) {
					player.getInventory().offerOrDrop(Items.DIAMOND.getDefaultStack());
					player.getInventory().offerOrDrop(Items.DIAMOND.getDefaultStack());
					player.getMainHandStack().decrement(1);
					player.playSound(SoundEvent.of(SoundEvents.BLOCK_GRINDSTONE_USE.getId()), SoundCategory.BLOCKS, 1.0F, 1.0F);
					return ActionResult.SUCCESS;
			}

			return ActionResult.PASS;

		});

		// deepslate diamond
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {

			if (player.getStackInHand(hand).getItem() == DEEPSLATE_DIAMOND && !player.isSpectator() &&
				world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.GRINDSTONE)) {
					player.getInventory().offerOrDrop(Items.DIAMOND.getDefaultStack());
					player.getMainHandStack().decrement(1);
					player.playSound(SoundEvent.of(SoundEvents.BLOCK_GRINDSTONE_USE.getId()), SoundCategory.BLOCKS, 1.0F, 1.0F);
					return ActionResult.SUCCESS;
			}

			return ActionResult.PASS;

		});

	}


}