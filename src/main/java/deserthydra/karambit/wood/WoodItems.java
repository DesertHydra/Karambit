package deserthydra.karambit.wood;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.impl.item.TerraformBoatItem;
import deserthydra.karambit.registry.KarambitRegistry;
import deserthydra.karambit.tags.KarambitItemTags;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.registry.tag.TagKey;

public class WoodItems {
    private final String NAME;
    private final TerraformBoatType BOAT_TYPE;

    public final BlockItem stem;
    public final BlockItem hyphae;
    public final BlockItem planks;
    public final BlockItem slab;
    public final BlockItem stairs;
    public final BlockItem fence;
    public final BlockItem fenceGate;
    public final BlockItem door;
    public final BlockItem button;
    public final BlockItem pressurePlate;
    public final SignItem sign;
    public final HangingSignItem hangingSign;
    public final BlockItem trapdoor;
    public final BlockItem strippedStem;
    public final BlockItem strippedHyphae;
    public final TerraformBoatItem boat;
    public final TerraformBoatItem chestBoat;
    public final TagKey<Item> logsTag;

    private WoodItems(String name, WoodBlocks blocks) {
        this.NAME = name;

        stem = KarambitRegistry.registerBlockItem(name + "_stem", blocks.stem);
        strippedStem = KarambitRegistry.registerBlockItem("stripped_" + name + "_stem", blocks.strippedStem);

        planks = KarambitRegistry.registerBlockItem(name + "_planks", blocks.planks);
        slab = KarambitRegistry.registerBlockItem(name + "_slab", blocks.slab);
        stairs = KarambitRegistry.registerBlockItem(name + "_stairs", blocks.stairs);
        fence = KarambitRegistry.registerBlockItem(name + "_fence", blocks.fence);
        fenceGate = KarambitRegistry.registerBlockItem(name + "_fence_gate", blocks.fenceGate);
        door = KarambitRegistry.registerBlockItem(name + "_door", blocks.door);
        button = KarambitRegistry.registerBlockItem(name + "_button", blocks.button);
        pressurePlate = KarambitRegistry.registerBlockItem(name + "_pressure_plate", blocks.pressurePlate);
        trapdoor = KarambitRegistry.registerBlockItem(name + "_trapdoor", blocks.trapdoor);
        sign = KarambitRegistry.register(name + "_sign", new SignItem(new Item.Settings().maxCount(16), blocks.sign, blocks.wallSign));
        hangingSign = KarambitRegistry.register(name + "_hanging_sign", new HangingSignItem(blocks.hangingSign, blocks.wallHangingSign, new Item.Settings().maxCount(16)));

        BOAT_TYPE = WoodBoats.register(name, planks);
        if (BOAT_TYPE != null) {
            boat = (TerraformBoatItem) BOAT_TYPE.getItem();
            chestBoat = (TerraformBoatItem) BOAT_TYPE.getChestItem();
        } else {
            boat = null;
            chestBoat = null;
        }

        if (blocks.hasHyphae()) {
            hyphae = KarambitRegistry.registerBlockItem(name + "_hyphae", blocks.hyphae);
            strippedHyphae = KarambitRegistry.registerBlockItem("stripped_" + name + "_hyphae", blocks.strippedHyphae);
            logsTag = KarambitItemTags.of(name + "_stems");
        } else {
            hyphae = null;
            strippedHyphae = null;
            logsTag = null;
        }
    }

    public static WoodItems register(String name, WoodBlocks blocks) {
        return new WoodItems(name, blocks);
    }

    public String getName() {
        return NAME;
    }

    public boolean hasHyphae() {
        return (hyphae != null && strippedHyphae != null);
    }

    public boolean hasBoat() {
        return (BOAT_TYPE != null && boat != null && chestBoat != null);
    }
}
