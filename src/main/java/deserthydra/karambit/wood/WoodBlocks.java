package deserthydra.karambit.wood;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.wood.api.block.PillarLogHelper;
import deserthydra.karambit.Karambit;
import deserthydra.karambit.registry.KarambitRegistry;
import deserthydra.karambit.tags.KarambitBlockTags;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

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
    public final TerraformSignBlock sign;
    public final TerraformWallSignBlock wallSign;
    public final TerraformHangingSignBlock hangingSign;
    public final TerraformWallHangingSignBlock wallHangingSign;
    public final TrapdoorBlock trapdoor;
    public final Block strippedStem;
    public final Block strippedHyphae;
    public final TagKey<Block> logsTag;

    private WoodBlocks(String name, WoodColors colors) {
        this.NAME = name;
        this.COLORS = colors;

        planks = KarambitRegistry.register(name + "_planks", new Block(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).mapColor(colors.planks)));
        slab = KarambitRegistry.register(name + "_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_SLAB).mapColor(colors.planks)));
        stairs = KarambitRegistry.register(name + "_stairs", new StairsBlock(planks.getDefaultState(), AbstractBlock.Settings.copy(Blocks.CRIMSON_STAIRS).mapColor(colors.planks)));
        fence = KarambitRegistry.register(name + "_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_FENCE).mapColor(colors.planks)));
        fenceGate = KarambitRegistry.register(name + "_fence_gate", new FenceGateBlock(WoodType.CRIMSON, AbstractBlock.Settings.copy(Blocks.CRIMSON_FENCE_GATE).mapColor(colors.planks)));
        door = KarambitRegistry.register(name + "_door", new DoorBlock(BlockSetType.CRIMSON, AbstractBlock.Settings.copy(Blocks.CRIMSON_DOOR).mapColor(colors.planks)));
        button = KarambitRegistry.register(name + "_button", new ButtonBlock(BlockSetType.CRIMSON, 30, AbstractBlock.Settings.copy(Blocks.CRIMSON_BUTTON).mapColor(colors.planks)));
        pressurePlate = KarambitRegistry.register(name + "_pressure_plate", new PressurePlateBlock(BlockSetType.CRIMSON, AbstractBlock.Settings.copy(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(colors.planks)));
        trapdoor = KarambitRegistry.register(name + "_trapdoor", new TrapdoorBlock(BlockSetType.CRIMSON, AbstractBlock.Settings.copy(Blocks.CRIMSON_TRAPDOOR).mapColor(colors.planks)));

        Identifier signTexture = Identifier.of(Karambit.MOD_ID, "entity/signs/" + name);
        sign = KarambitRegistry.register(name + "_sign", new TerraformSignBlock(signTexture, AbstractBlock.Settings.copy(Blocks.CRIMSON_SIGN).mapColor(colors.planks)));
        wallSign = KarambitRegistry.register(name + "_wall_sign", new TerraformWallSignBlock(signTexture, AbstractBlock.Settings.copy(Blocks.CRIMSON_WALL_SIGN).mapColor(colors.planks).lootTable(sign.getLootTableKey())));

        Identifier hangingSignTexture = Identifier.of(Karambit.MOD_ID, "entity/signs/hanging/" + name);
        Identifier hangingSignGuiTexture = Identifier.of(Karambit.MOD_ID, "textures/gui/hanging_signs/" + name);
        hangingSign = KarambitRegistry.register(name + "_hanging_sign", new TerraformHangingSignBlock(hangingSignTexture, hangingSignGuiTexture, AbstractBlock.Settings.copy(Blocks.CRIMSON_HANGING_SIGN).mapColor(colors.planks)));
        wallHangingSign = KarambitRegistry.register(name + "_wall_hanging_sign", new TerraformWallHangingSignBlock(hangingSignTexture, hangingSignGuiTexture, AbstractBlock.Settings.copy(Blocks.CRIMSON_WALL_HANGING_SIGN).mapColor(colors.planks).lootTable(hangingSign.getLootTableKey())));

        stem = KarambitRegistry.register(name + "_stem", PillarLogHelper.ofNether(colors.planks, colors.bark));
        strippedStem = KarambitRegistry.register("stripped_" + name + "_stem",  PillarLogHelper.ofNether(colors.planks));
        hyphae = KarambitRegistry.register(name + "_hyphae", PillarLogHelper.ofNether(colors.planks, colors.bark));
        strippedHyphae = KarambitRegistry.register("stripped_" + name + "_hyphae",  PillarLogHelper.ofNether(colors.planks));

        logsTag = KarambitBlockTags.of(name + "_stems");

    }

    public static WoodBlocks register(String name, WoodColors colors) {
        WoodBlocks blocks = new WoodBlocks(name, colors);
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
