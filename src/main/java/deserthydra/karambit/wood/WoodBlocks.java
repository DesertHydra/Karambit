package deserthydra.karambit.wood;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import deserthydra.karambit.Karambit;
import deserthydra.karambit.registry.KarambitRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
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

    private WoodBlocks(String name, WoodColors colors) {
        this.NAME = name;
        this.COLORS = colors;

        planks = KarambitRegistry.register(name + "_planks", new Block(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS).mapColor(colors.planks)));
        slab = KarambitRegistry.register(name + "_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_SLAB).mapColor(colors.planks)));
        stairs = KarambitRegistry.register(name + "_stairs", new StairsBlock(planks.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CRIMSON_STAIRS).mapColor(colors.planks)));
        fence = KarambitRegistry.register(name + "_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_FENCE).mapColor(colors.planks)));
        fenceGate = KarambitRegistry.register(name + "_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_FENCE_GATE).mapColor(colors.planks), WoodType.CRIMSON));
        door = KarambitRegistry.register(name + "_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_DOOR).mapColor(colors.planks), BlockSetType.CRIMSON));
        button = KarambitRegistry.register(name + "_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_BUTTON).mapColor(colors.planks), BlockSetType.CRIMSON, 30, true));
        pressurePlate = KarambitRegistry.register(name + "_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(colors.planks), BlockSetType.CRIMSON));
        trapdoor = KarambitRegistry.register(name + "_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_TRAPDOOR).mapColor(colors.planks), BlockSetType.CRIMSON));

        Identifier signTexture = Identifier.of(Karambit.MOD_ID, "entity/signs/" + name);
        sign = KarambitRegistry.register(name + "_sign", new TerraformSignBlock(signTexture, FabricBlockSettings.copyOf(Blocks.CRIMSON_SIGN).mapColor(colors.planks)));
        wallSign = KarambitRegistry.register(name + "_wall_sign", new TerraformWallSignBlock(signTexture, FabricBlockSettings.copyOf(Blocks.CRIMSON_WALL_SIGN).mapColor(colors.planks).dropsLike(sign)));

        Identifier hangingSignTexture = Identifier.of(Karambit.MOD_ID, "entity/signs/hanging/" + name);
        Identifier hangingSignGuiTexture = Identifier.of(Karambit.MOD_ID, "textures/gui/hanging_signs/" + name);
        hangingSign = KarambitRegistry.register(name + "_hanging_sign", new TerraformHangingSignBlock(hangingSignTexture, hangingSignGuiTexture, FabricBlockSettings.copyOf(Blocks.CRIMSON_HANGING_SIGN).mapColor(colors.planks)));
        wallHangingSign = KarambitRegistry.register(name + "_wall_hanging_sign", new TerraformWallHangingSignBlock(hangingSignTexture, hangingSignGuiTexture, FabricBlockSettings.copyOf(Blocks.crimson_WALL_HANGING_SIGN).mapColor(colors.planks).dropsLike(hangingSign)));
    }


    public static WoodBlocks register(String name, WoodColors colors) {
        WoodBlocks blocks = new WoodBlocks(name, colors);
        blocks.addStrippables();
        return blocks;
    }

    public static WoodBlocks register(String name, WoodColors colors) {
        return register(name, colors);
    }

    private void addStrippables() {
        if (stem != null && strippedStem != null) {
            StrippableBlockRegistry.register(stem, strippedStem);
        }
        if (hyphae != null && strippedHyphae != null) {
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
