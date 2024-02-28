package pack.mirage.MKS.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
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

    @Unique
    private int dayCount;

    @Inject(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;renderStatusBars(Lnet/minecraft/client/gui/DrawContext;)V"
            )
    )
    private void renderStuff(DrawContext context, float tickDelta, CallbackInfo ci) {
        if (this.dayCounterTimerFade > 0) {
            float timeLeft = this.dayCounterTimerFade - tickDelta;
            int alpha = 255;

            if (this.dayCounterTimerFade > 20 + 100) {
                float progress = (20.0F + 100.0F + 20.0F) - timeLeft;
                alpha = (int) ((progress * 255.0F) / 20.0F);
            }

            if (this.dayCounterTimerFade <= 20) {
                alpha = (int) ((timeLeft * 255.0F) / 20.0F);
            }

            alpha = MathHelper.clamp(alpha, 0, 255);

            if (alpha > 8) {
                context.getMatrices().push();
                context.drawCenteredTextWithShadow(
                        this.getTextRenderer(),
                        Text.translatable("hud.mirage-kitchens-sink.day_counter", this.client.world.getTimeOfDay() / 24000L),
                        this.scaledWidth / 2,
                        this.scaledHeight - 48,
                        0x00FFFFFF | (alpha << 24 & 0xFF000000)
                );
                context.getMatrices().pop();
            }
        }
    }

    // TODO - perhaps find a more optimal way of doing this
    @Inject(method = "tick()V", at = @At("TAIL"))
    private void tickStuff(CallbackInfo ci) {
        if (this.client.world != null) {
            if (this.dayCounterTimerFade > 0) {
                this.dayCounterTimerFade--;
            } else {
                if ((int) (this.client.world.getTimeOfDay() / 24000L) != this.dayCount) {
                    this.dayCount = (int) (this.client.world.getTimeOfDay() / 24000L);
                    if (this.dayCount % 5 == 0) {
                        this.dayCounterTimerFade = 20 + 100 + 20;
                    }
                }
            }
        } else {
            this.dayCount = -1;
        }
    }
}
