package deserthydra.hardwater;

import com.google.common.reflect.Reflection;
import deserthydra.hardwater.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;

import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.block.LeveledCauldronBlock.LEVEL;
import static net.minecraft.block.LeveledCauldronBlock.decrementFluidLevel;
import static net.minecraft.item.Items.CAULDRON;
import static net.minecraft.item.Items.CRIMSON_PLANKS;
import static net.minecraft.registry.tag.BlockTags.*;
import static deserthydra.hardwater.registry.RawDiamondRegistry.*;


public class HardWater implements ModInitializer {
	public static final String MOD_ID = "hardwater";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		register();
		CreativeTabOrder.register();
		Reflection.initialize(RosewaterBlocks.class, RosewaterItems.class);

		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

			if (player.getMainHandStack().isEmpty() &&
				!player.isCreative() && !player.isSpectator() &&
				!(world.getBlockState(pos).getHardness(world, pos) == 0.0F) &&
				!world.getBlockState(pos).isIn(SNOW) &&
				!world.getBlockState(pos).isIn(LEAVES)
			){
					return ActionResult.SUCCESS;
				}
			return ActionResult.PASS;
		});


		// stone diamond
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {

			if (player.getStackInHand(hand).getItem() == RAW_DIAMOND && !player.isSpectator() &&
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