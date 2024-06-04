package deserthydra.hardwater;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static deserthydra.hardwater.HardWater.MOD_ID;

public class ItemRegistry {

    public static final Item RAW_DIAMOND = new Item(new Item.Settings());

    public static void register() {

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "raw_diamond"), RAW_DIAMOND);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(Items.LAPIS_LAZULI, RAW_DIAMOND));
    }
}
