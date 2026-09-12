package deserthydra.karambit.item;

import deserthydra.karambit.KarambitCommon;
import deserthydra.karambit.block.KarambitBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class KarambitItemGroups {

    public static final CreativeModeTab KARAMBIT_ITEM_GROUP = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(KarambitCommon.MOD_ID, "karambit_item_group"),
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .title(Component.translatable("itemgroup.karambit_item_group"))
                    .icon(() -> new ItemStack(KarambitBlocks.AZURITE_STEM))
                    .displayItems((parameters, output) -> {
                        output.accept(KarambitBlocks.ROSEWATER_STEM);
                        output.accept(KarambitBlocks.STRIPPED_ROSEWATER_STEM);
                        output.accept(KarambitBlocks.ROSEWATER_HYPHAE);
                        output.accept(KarambitBlocks.STRIPPED_ROSEWATER_HYPHAE);
                        output.accept(KarambitBlocks.ROSEWATER_PLANKS);
                        output.accept(KarambitItems.ROSEWATER_SIGN);
                        output.accept(KarambitItems.ROSEWATER_HANGING_SIGN);
                        output.accept(KarambitBlocks.ROSEWATER_SLAB);
                        output.accept(KarambitBlocks.ROSEWATER_STAIRS);
                        output.accept(KarambitBlocks.ROSEWATER_FENCE);
                        output.accept(KarambitBlocks.ROSEWATER_FENCE_GATE);
                        output.accept(KarambitBlocks.ROSEWATER_DOOR);
                        output.accept(KarambitBlocks.ROSEWATER_TRAPDOOR);
                        output.accept(KarambitBlocks.ROSEWATER_BUTTON);
                        output.accept(KarambitBlocks.ROSEWATER_PRESSURE_PLATE);
                        output.accept(KarambitItems.ROSEWATER_BOAT);
                        output.accept(KarambitItems.ROSEWATER_CHEST_BOAT);

                        output.accept(KarambitBlocks.AZURITE_STEM);
                        output.accept(KarambitBlocks.STRIPPED_AZURITE_STEM);
                        output.accept(KarambitBlocks.AZURITE_HYPHAE);
                        output.accept(KarambitBlocks.STRIPPED_AZURITE_HYPHAE);
                        output.accept(KarambitBlocks.AZURITE_PLANKS);
                        output.accept(KarambitItems.AZURITE_SIGN);
                        output.accept(KarambitItems.AZURITE_HANGING_SIGN);
                        output.accept(KarambitBlocks.AZURITE_SLAB);
                        output.accept(KarambitBlocks.AZURITE_STAIRS);
                        output.accept(KarambitBlocks.AZURITE_FENCE);
                        output.accept(KarambitBlocks.AZURITE_FENCE_GATE);
                        output.accept(KarambitBlocks.AZURITE_DOOR);
                        output.accept(KarambitBlocks.AZURITE_TRAPDOOR);
                        output.accept(KarambitBlocks.AZURITE_BUTTON);
                        output.accept(KarambitBlocks.AZURITE_PRESSURE_PLATE);
                        output.accept(KarambitItems.AZURITE_BOAT);
                        output.accept(KarambitItems.AZURITE_CHEST_BOAT);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        KarambitCommon.LOGGER.info("Registering items for " + KarambitCommon.MOD_ID);
    }

}