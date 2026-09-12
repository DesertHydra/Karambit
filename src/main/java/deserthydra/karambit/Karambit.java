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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
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
