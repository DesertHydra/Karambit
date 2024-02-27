package pack.mirage.MKS.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Shadow
    private int scaledWidth;

    @Shadow
    private int scaledHeight;

    @Shadow
    public abstract TextRenderer getTextRenderer();

    @Unique
    private int dayCounterTimerFade;

    // TODO - make this Not Permanent
    @Inject(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;renderStatusBars(Lnet/minecraft/client/gui/DrawContext;)V"
            )
    )
    private void renderStuff(DrawContext context, float tickDelta, CallbackInfo ci) {
        context.getMatrices().push();
        context.drawCenteredTextWithShadow(
                this.getTextRenderer(),
                Text.translatable("hud.mirage-kitchens-sink.day_counter", this.client.world.getTimeOfDay() / 24000L),
                this.scaledWidth / 2,
                this.scaledHeight - 48,
                Colors.WHITE
        );
        context.getMatrices().pop();
    }
}
