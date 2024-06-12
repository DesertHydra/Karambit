package deserthydra.karambit.mixin;
import deserthydra.karambit.registry.BoatItems;
import deserthydra.karambit.util.CustomBoatType;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBoatEntity.class)
public class ChestBoatDropsMixin {

    @Inject(method = "asItem", at = @At("RETURN"), cancellable = true)
    public void getChestModdedBoats(CallbackInfoReturnable<Item> info) {
        var boat = ChestBoatEntity.class.cast(this);
        if (boat.getVariant() == CustomBoatType.ROSEWATER) {
            info.setReturnValue(BoatItems.ROSEWATER_CHEST_BOAT);
        }
    }
}