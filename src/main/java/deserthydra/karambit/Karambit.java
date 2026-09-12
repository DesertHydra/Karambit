package deserthydra.karambit;

import deserthydra.karambit.block.KarambitBlocks;
import deserthydra.karambit.item.KarambitItemGroups;
import deserthydra.karambit.item.KarambitItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.mixin.transfer.ItemStackAccessor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.HitResult;

import java.util.Map;

public class Karambit implements ModInitializer {

    @Override
    public void onInitialize() {

        KarambitCommon.init();
        KarambitItemGroups.registerItemGroups();
        registerSignBlocks();

        StrippableBlockRegistry.register(KarambitBlocks.ROSEWATER_STEM, KarambitBlocks.STRIPPED_ROSEWATER_STEM);
        StrippableBlockRegistry.register(KarambitBlocks.AZURITE_STEM, KarambitBlocks.STRIPPED_AZURITE_STEM);

        StrippableBlockRegistry.register(KarambitBlocks.ROSEWATER_HYPHAE, KarambitBlocks.STRIPPED_ROSEWATER_HYPHAE);
        StrippableBlockRegistry.register(KarambitBlocks.AZURITE_HYPHAE, KarambitBlocks.STRIPPED_AZURITE_HYPHAE);

        var washableToWashedMap = Map.ofEntries(
                Map.entry(Items.CRIMSON_STEM, KarambitBlocks.ROSEWATER_STEM));

        for (var entry: washableToWashedMap.entrySet()) {
            UseItemCallback.EVENT.register(((player, level, hand) -> {
                var stack = player.getItemInHand(hand);
                if (stack.is(entry.getKey())) {
                    var blockHitResult = ItemStackAccessor.callRaycast(world, player, RaycastContext.FluidHandling.SOURCE_ONLY);
                    if (blockHitResult.getType() == HitResult.Type.BLOCK) {
                        var blockPos = blockHitResult.getBlockPos();
                        if (!level.canPlayerModifyAt(player, blockPos)) {
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

            }));
        }


    }

    private static void registerSignBlocks() {
        FabricBlockEntityType sign = (FabricBlockEntityType) BuiltInRegistries.BLOCK_ENTITY_TYPE.getValue(Identifier.withDefaultNamespace("sign"));
        FabricBlockEntityType hangingSign = (FabricBlockEntityType) BuiltInRegistries.BLOCK_ENTITY_TYPE.getValue(Identifier.withDefaultNamespace("hanging_sign"));

        sign.addValidBlock(KarambitBlocks.ROSEWATER_SIGN);
        sign.addValidBlock(KarambitBlocks.ROSEWATER_WALL_SIGN);
        sign.addValidBlock(KarambitBlocks.AZURITE_SIGN);
        sign.addValidBlock(KarambitBlocks.AZURITE_WALL_SIGN);

        hangingSign.addValidBlock(KarambitBlocks.ROSEWATER_HANGING_SIGN);
        hangingSign.addValidBlock(KarambitBlocks.ROSEWATER_WALL_HANGING_SIGN);
        hangingSign.addValidBlock(KarambitBlocks.AZURITE_HANGING_SIGN);
        hangingSign.addValidBlock(KarambitBlocks.AZURITE_WALL_HANGING_SIGN);
    }
}
