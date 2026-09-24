package deserthydra.karambit;

import deserthydra.karambit.block.KarambitBlocks;
import deserthydra.karambit.item.KarambitItemGroups;
import deserthydra.karambit.item.KarambitItems;
import deserthydra.karambit.mixin.ItemAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.v1.FluidFlowEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.mixin.transfer.ItemStackAccessor;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipBlockStateContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.HitResult;

import java.util.Map;
import java.util.Random;

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
                Map.entry(Blocks.CRIMSON_STEM, KarambitBlocks.ROSEWATER_STEM));

        FluidFlowEvents.ALLOW.register((fluid, level, position) -> {
            if (fluid.is(FluidTags.WATER)) {
                RandomSource randomSource = level.getRandom();
                for (Direction dir : Direction.values()) {
                    BlockState state = level.getBlockState(position.relative(dir));

                    if (washableToWashedMap.containsKey(state.getBlock())) {
                        level.setBlock(position.relative(dir), washableToWashedMap.get(state.getBlock()).withPropertiesOf(state), 3);
                        level.playSound(null, position.relative(dir), SoundEvents.LAVA_EXTINGUISH, SoundSource.NEUTRAL, 1.0F, 1.0F);
                        if(level instanceof ServerLevel)
                            ((ServerLevel) level).sendParticles(ParticleTypes.SMOKE, position.getX(), position.getY(), position.getZ(), 6, 0.0,0.7,0.0,0.2f);

                    }
                }
            }

            return true;
        });
    }
        private static boolean touchesLiquid (final Level level, final BlockPos pos){
            boolean touchesLiquid = false;
            BlockPos.MutableBlockPos testPos = pos.mutable();

            for (Direction direction : Direction.values()) {
                BlockState blockState = level.getBlockState(testPos);
                if (direction != Direction.DOWN || blockState.getFluidState().is(FluidTags.WATER)) {
                    testPos.setWithOffset(pos, direction);
                    blockState = level.getBlockState(testPos);
                    if (blockState.getFluidState().is(FluidTags.WATER) && !blockState.isFaceSturdy(level, pos, direction.getOpposite())) {
                        touchesLiquid = true;
                        break;
                    }
                }
            }

            return touchesLiquid;
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
