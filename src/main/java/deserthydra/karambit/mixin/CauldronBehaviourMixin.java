package deserthydra.karambit.mixin;

import deserthydra.karambit.registry.KarambitItems;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(CauldronBehavior.class)
public interface CauldronBehaviourMixin {
    @Shadow
    @Final
    Map<Item, CauldronBehavior> WATER_CAULDRON_BEHAVIOR = null;

    @Inject(method = "registerBehavior", at = @At("TAIL"))
    private static void makeCauldronDoTheThing(CallbackInfo ci) {
        WATER_CAULDRON_BEHAVIOR.put(
                Items.CRIMSON_STEM,
                ((state, world, pos, player, hand, stack) -> {
                    if (!world.isClient) {
                        var item = stack.getItem();
                        player.getInventory().offerOrDrop(KarambitItems.ROSEWATER.stem.getDefaultStack());
                        player.getStackInHand(hand).decrement(1);
                        LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                        world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
                    }

                    return ActionResult.SUCCESS;
                })
        );
        WATER_CAULDRON_BEHAVIOR.put(
                Items.CRIMSON_HYPHAE,
                ((state, world, pos, player, hand, stack) -> {
                    if (!world.isClient) {
                        var item = stack.getItem();
                        player.getInventory().offerOrDrop(KarambitItems.ROSEWATER.hyphae.getDefaultStack());
                        player.getStackInHand(hand).decrement(1);
                        LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                        world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
                    }

                    return ActionResult.SUCCESS;
                })
        );
        WATER_CAULDRON_BEHAVIOR.put(
                Items.STRIPPED_CRIMSON_STEM,
                ((state, world, pos, player, hand, stack) -> {
                    if (!world.isClient) {
                        var item = stack.getItem();
                        player.getInventory().offerOrDrop(KarambitItems.ROSEWATER.strippedStem.getDefaultStack());
                        player.getStackInHand(hand).decrement(1);
                        LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                        world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
                    }

                    return ActionResult.SUCCESS;
                })
        );
        WATER_CAULDRON_BEHAVIOR.put(
                Items.STRIPPED_CRIMSON_HYPHAE,
                ((state, world, pos, player, hand, stack) -> {
                    if (!world.isClient) {
                        var item = stack.getItem();
                        player.getInventory().offerOrDrop(KarambitItems.ROSEWATER.strippedHyphae.getDefaultStack());
                        player.getStackInHand(hand).decrement(1);
                        LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                        world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
                    }

                    return ActionResult.SUCCESS;
                })
        );
        WATER_CAULDRON_BEHAVIOR.put(
                Items.CRIMSON_PLANKS,
                ((state, world, pos, player, hand, stack) -> {
                    if (!world.isClient) {
                        var item = stack.getItem();
                        player.getInventory().offerOrDrop(KarambitItems.ROSEWATER.planks.getDefaultStack());
                        player.getStackInHand(hand).decrement(1);
                        LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                        world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
                    }

                    return ActionResult.SUCCESS;
                })
        );
        WATER_CAULDRON_BEHAVIOR.put(
                Items.CRIMSON_STAIRS,
                ((state, world, pos, player, hand, stack) -> {
                    if (!world.isClient) {
                        var item = stack.getItem();
                        player.getInventory().offerOrDrop(KarambitItems.ROSEWATER.stairs.getDefaultStack());
                        player.getStackInHand(hand).decrement(1);
                        LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                        world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
                    }

                    return ActionResult.SUCCESS;
                })
        );
        WATER_CAULDRON_BEHAVIOR.put(
                Items.CRIMSON_SLAB,
                ((state, world, pos, player, hand, stack) -> {
                    if (!world.isClient) {
                        var item = stack.getItem();
                        player.getInventory().offerOrDrop(KarambitItems.ROSEWATER.slab.getDefaultStack());
                        player.getStackInHand(hand).decrement(1);
                        LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                        world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
                    }

                    return ActionResult.SUCCESS;
                })
        );
    }
}
