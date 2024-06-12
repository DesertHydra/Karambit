package deserthydra.karambit;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

import static deserthydra.karambit.registry.KarambitItems.ROSEWATER;


public class CreativeTabOrder {

    public static void register() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.addAfter(Items.CRIMSON_BUTTON, ROSEWATER.stem, ROSEWATER.hyphae, ROSEWATER.strippedStem, ROSEWATER.strippedHyphae,
                ROSEWATER.planks, ROSEWATER.stairs, ROSEWATER.slab, ROSEWATER.fence, ROSEWATER.fenceGate, ROSEWATER.door, ROSEWATER.trapdoor, ROSEWATER.pressurePlate, ROSEWATER.button));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.addAfter(Items.CRIMSON_STEM, ROSEWATER.stem));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addAfter(Items.CRIMSON_HANGING_SIGN, ROSEWATER.sign, ROSEWATER.hangingSign));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(Items.CHERRY_CHEST_BOAT, ROSEWATER.boat, ROSEWATER.chestBoat));
    }
}
