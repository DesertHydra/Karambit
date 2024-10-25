package deserthydra.karambit.wood;

import deserthydra.karambit.registry.KarambitRegistry;
import deserthydra.karambit.tags.KarambitItemTags;
import net.minecraft.item.*;
import net.minecraft.registry.tag.TagKey;

public class WoodItems {
    private final String NAME;

    public final Item stem;
    public final Item hyphae;
    public final Item planks;
    public final Item slab;
    public final Item stairs;
    public final Item fence;
    public final Item fenceGate;
    public final Item door;
    public final Item button;
    public final Item pressurePlate;
    public final Item sign;
    public final Item hangingSign;
    public final Item trapdoor;
    public final Item strippedStem;
    public final Item strippedHyphae;
    public final Item boat;
    public final Item chestBoat;
    public final TagKey<Item> logsTag;

    private WoodItems(String name, WoodBlocks blocks, WoodBoats boats) {
        this.NAME = name;

        stem = KarambitRegistry.registerBlockItem(blocks.stem);
        strippedStem = KarambitRegistry.registerBlockItem(blocks.strippedStem);

        planks = KarambitRegistry.registerBlockItem(blocks.planks);
        slab = KarambitRegistry.registerBlockItem(blocks.slab);
        stairs = KarambitRegistry.registerBlockItem(blocks.stairs);
        fence = KarambitRegistry.registerBlockItem(blocks.fence);
        fenceGate = KarambitRegistry.registerBlockItem(blocks.fenceGate);
        door = KarambitRegistry.registerBlockItem(blocks.door);
        button = KarambitRegistry.registerBlockItem(blocks.button);
        pressurePlate = KarambitRegistry.registerBlockItem(blocks.pressurePlate);
        trapdoor = KarambitRegistry.registerBlockItem(blocks.trapdoor);
        // TODO - Fix me!
        sign = KarambitRegistry.register(blocks.sign, (block, settings) -> new SignItem(block, blocks.wallSign, settings), new Item.Settings().maxCount(16));
        hangingSign = KarambitRegistry.register(blocks.hangingSign, (block, settings) -> new SignItem(block, blocks.wallHangingSign, settings), new Item.Settings().maxCount(16));
        boat = KarambitRegistry.register(name + "_boat", settings -> new BoatItem(boats.boat, settings), new Item.Settings());
        chestBoat = KarambitRegistry.register(name + "_chest_boat", settings -> new BoatItem(boats.chestBoat, settings), new Item.Settings());

        if (blocks.hasHyphae()) {
            hyphae = KarambitRegistry.registerBlockItem(blocks.hyphae);
            strippedHyphae = KarambitRegistry.registerBlockItem(blocks.strippedHyphae);
            logsTag = KarambitItemTags.of(name + "_stems");
        } else {
            hyphae = null;
            strippedHyphae = null;
            logsTag = null;
        }
    }

    public static WoodItems register(String name, WoodBlocks blocks, WoodBoats boats) {
        return new WoodItems(name, blocks, boats);
    }

    public String getName() {
        return NAME;
    }

    public boolean hasHyphae() {
        return (hyphae != null && strippedHyphae != null);
    }

    public boolean hasBoat() {
        return (boat != null && chestBoat != null);
    }
}
