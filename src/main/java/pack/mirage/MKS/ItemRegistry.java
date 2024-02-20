package pack.mirage.MKS;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pack.mirage.MKS.flint.FlintKnifeItem;
import pack.mirage.MKS.flint.FlintMaterial;

import static net.minecraft.item.Items.register;
import static pack.mirage.MKS.MKS.MOD_ID;

public class ItemRegistry {

    public static final Item SHARP_FLINT = new Item(new Item.Settings());
    public static final Item FLINT_KNIFE = new FlintKnifeItem(new FlintMaterial(), (int) 1f, -3.2f, new Item.Settings());
    public static final Item GRASS_FIBER = new Item(new Item.Settings());

    public static final Item STONE_DIAMOND = new Item(new Item.Settings());
    public static final Item DEEPSLATE_DIAMOND = new Item(new Item.Settings());

    public static void register() {

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sharp_flint"), SHARP_FLINT);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "flint_knife"), FLINT_KNIFE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "grass_fiber"), GRASS_FIBER);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "stone_diamond"), STONE_DIAMOND);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "deepslate_diamond"), DEEPSLATE_DIAMOND);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(Items.FLINT, SHARP_FLINT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(Items.STONE_HOE, FLINT_KNIFE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(Items.STRING, GRASS_FIBER));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(Items.LAPIS_LAZULI, STONE_DIAMOND, DEEPSLATE_DIAMOND));
    }
}
