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

    @Unique
    private int getDay() {
        return (int) (this.client.world.getTimeOfDay() / 24000L);
    }

    @Inject(method = { "<init>", "clear" }, at = @At("TAIL"))
    private void resetDayCount(CallbackInfo ci) {
        this.dayCounterTimerFade = 0;
        this.dayCount = -1;
    }

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

            if (this.dayCounterTimerFade > 15 + 100) {
                float progress = (15.0F + 100.0F + 15.0F) - timeLeft;
                alpha = (int) ((progress * 255.0F) / 15.0F);
            }

            if (this.dayCounterTimerFade <= 15) {
                alpha = (int) ((timeLeft * 255.0F) / 15.0F);
            }

            alpha = MathHelper.clamp(alpha, 0, 255);

            if (alpha > 8) {
                context.getMatrices().push();
                context.drawCenteredTextWithShadow(
                        this.getTextRenderer(),
                        Text.translatable("hud.mirage-kitchens-sink.day_counter", dayCount),
                        this.scaledWidth / 2,
                        this.scaledHeight / 2 + 20,
                        0x00FFFFFF | (alpha << 24 & 0xFF000000)
                );
                context.getMatrices().pop();
            }
        }
    }

    @Inject(method = "tick()V", at = @At("TAIL"))
    private void tickStuff(CallbackInfo ci) {
        if (this.dayCounterTimerFade > 0) {
            this.dayCounterTimerFade--;
        }

        if (this.client.world != null) {
            if (this.dayCount == -1) {
                this.dayCount = this.getDay();
                this.dayCounterTimerFade = 15 + 100 + 15;
            } else if (this.dayCount != this.getDay()) {
                this.dayCount = this.getDay();
                if (this.dayCount % 5 == 0) {
                    this.dayCounterTimerFade = 15 + 100 + 15;
                }
            }
        }
    }
}
