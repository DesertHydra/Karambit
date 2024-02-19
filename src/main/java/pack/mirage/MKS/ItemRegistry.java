package pack.mirage.MKS;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.item.Items.register;
import static pack.mirage.MKS.MKS.MOD_ID;

public class ItemRegistry {

    public static final Item SHARP_FLINT = new Item(new Item.Settings());
    public static final Item  FLINT_KNIFE = new FlintKnifeItem(new FlintMaterial(), (int) 1f, -3.2f, new Item.Settings());
    public static final Item GRASS_FIBER = new Item(new Item.Settings());

    public static void register() {

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sharp_flint"), SHARP_FLINT);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "flint_knife"), FLINT_KNIFE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "grass_fiber"), GRASS_FIBER);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(Items.FLINT, SHARP_FLINT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(Items.STONE_HOE, FLINT_KNIFE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(Items.STRING, GRASS_FIBER));
    }
// if (hand.equals(LOGS) &&
//            !player.isSpectator() &&
//            world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.STONE)) {

//        player.giveItemStack(ItemRegistry.SHARP_FLINT.getDefaultStack());
 //       player.getMainHandStack().decrement(1);
//    }
}
