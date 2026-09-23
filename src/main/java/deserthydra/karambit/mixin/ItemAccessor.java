package deserthydra.karambit.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Item.class)
public interface ItemAccessor {
    @Invoker
    static BlockHitResult callRaycast(Level level, Player player, RaycastContext.FluidHandling fluidHandling) {
        throw new IllegalStateException("Mixin injection failed");
    }
}
