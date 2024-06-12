package deserthydra.karambit.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

import static deserthydra.karambit.registry.BoatItems.ROSEWATER_BOAT;
import static deserthydra.karambit.registry.BoatItems.ROSEWATER_CHEST_BOAT;
import static deserthydra.karambit.registry.RosewaterBlocks.*;

public class CreativeTabOrder {

    public static void register() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.addAfter(Items.CRIMSON_BUTTON,
                ROSEWATER_STEM, ROSEWATER_HYPHAE, STRIPPED_ROSEWATER_STEM, STRIPPED_ROSEWATER_HYPHAE, ROSEWATER_PLANKS, ROSEWATER_STAIRS, ROSEWATER_SLAB, ROSEWATER_FENCE,
                ROSEWATER_FENCE_GATE, ROSEWATER_DOOR, ROSEWATER_TRAPDOOR, ROSEWATER_PRESSURE_PLATE, ROSEWATER_BUTTON));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addAfter(Items.CRIMSON_HANGING_SIGN, ROSEWATER_SIGN, ROSEWATER_HANGING_SIGN));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(Items.CHERRY_CHEST_BOAT, ROSEWATER_BOAT, ROSEWATER_CHEST_BOAT));
    }
}
