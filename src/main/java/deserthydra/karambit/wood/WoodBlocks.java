package deserthydra.karambit.wood;

import deserthydra.karambit.Karambit;
import deserthydra.karambit.registry.KarambitRegistry;
import deserthydra.karambit.tags.KarambitBlockTags;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;

public class WoodBlocks {

    private final String NAME;
    private final WoodColors COLORS;

    public final Block stem;
    public final Block hyphae;
    public final Block planks;
    public final SlabBlock slab;
    public final StairsBlock stairs;
    public final FenceBlock fence;
    public final FenceGateBlock fenceGate;
    public final DoorBlock door;
    public final ButtonBlock button;
    public final PressurePlateBlock pressurePlate;
    public final SignBlock sign;
    public final WallSignBlock wallSign;
    public final HangingSignBlock hangingSign;
    public final WallHangingSignBlock wallHangingSign;
    public final TrapdoorBlock trapdoor;
    public final Block strippedStem;
    public final Block strippedHyphae;
    public final TagKey<Block> logsTag;

    private WoodBlocks(String name, WoodColors colors, WoodWood wood) {
        this.NAME = name;
        this.COLORS = colors;

        planks = KarambitRegistry.register(name + "_planks", Block::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).mapColor(colors.planks));
        slab = KarambitRegistry.register(name + "_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_SLAB).mapColor(colors.planks));
        stairs = KarambitRegistry.register(name + "_stairs", settings -> new StairsBlock(planks.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_STAIRS).mapColor(colors.planks));
        fence = KarambitRegistry.register(name + "_fence", FenceBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_FENCE).mapColor(colors.planks));
        fenceGate = KarambitRegistry.register(name + "_fence_gate", settings -> new FenceGateBlock(WoodType.CRIMSON, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_FENCE_GATE).mapColor(colors.planks));
        door = KarambitRegistry.register(name + "_door", settings -> new DoorBlock(BlockSetType.CRIMSON, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_DOOR).mapColor(colors.planks));
        button = KarambitRegistry.register(name + "_button", settings -> new ButtonBlock(BlockSetType.CRIMSON, 30, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_BUTTON).mapColor(colors.planks));
        pressurePlate = KarambitRegistry.register(name + "_pressure_plate", settings -> new PressurePlateBlock(BlockSetType.CRIMSON, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(colors.planks));
        trapdoor = KarambitRegistry.register(name + "_trapdoor", settings -> new TrapdoorBlock(BlockSetType.CRIMSON, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_TRAPDOOR).mapColor(colors.planks));

        sign = KarambitRegistry.register(name + "_sign", settings -> new SignBlock(wood.woodType, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_SIGN).mapColor(colors.planks));
        wallSign = KarambitRegistry.register( name + "_wall_sign", settings -> new WallSignBlock(wood.woodType, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_WALL_SIGN).mapColor(colors.planks).lootTable(sign.getLootTableKey()));
        hangingSign = KarambitRegistry.register(  name + "_hanging_sign", settings -> new HangingSignBlock(wood.woodType, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_HANGING_SIGN).mapColor(colors.planks));
        wallHangingSign = KarambitRegistry.register(  name + "_wall_hanging_sign", settings -> new WallHangingSignBlock(wood.woodType, settings), AbstractBlock.Settings.copy(Blocks.CRIMSON_WALL_HANGING_SIGN).mapColor(colors.planks).lootTable(hangingSign.getLootTableKey()));

        stem = KarambitRegistry.register(name + "_stem", PillarBlock::new, Blocks.createNetherStemSettings(colors.bark));
        strippedStem = KarambitRegistry.register("stripped_" + name + "_stem", PillarBlock::new, Blocks.createNetherStemSettings(colors.bark));
        hyphae = KarambitRegistry.register(name + "_hyphae", PillarBlock::new, Blocks.createNetherStemSettings(colors.bark));
        strippedHyphae = KarambitRegistry.register("stripped_" + name + "_hyphae", PillarBlock::new, Blocks.createNetherStemSettings(colors.bark));

        logsTag = KarambitBlockTags.of(name + "_stems");

    }

    public static WoodBlocks register(String name, WoodColors colors, WoodWood wood) {
        WoodBlocks blocks = new WoodBlocks(name, colors, wood);
        blocks.addStrippables();
        return blocks;
    }

    private void addStrippables() {
        if (stem != null && strippedStem != null) {
            StrippableBlockRegistry.register(stem, strippedStem);
        }
        if (hasHyphae()) {
            StrippableBlockRegistry.register(hyphae, strippedHyphae);
        }
    }

    public String getName() {
        return NAME;
    }

    public WoodColors getColors() {
        return COLORS;
    }

    public boolean hasHyphae() {
        return (hyphae != null && strippedHyphae != null);
    }
}
