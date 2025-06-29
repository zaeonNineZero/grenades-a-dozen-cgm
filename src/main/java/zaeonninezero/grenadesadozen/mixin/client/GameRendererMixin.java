package zaeonninezero.grenadesadozen.mixin.client;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.guns.Config;
import zaeonninezero.grenadesadozen.init.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin
{
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V", ordinal = 0, shift = At.Shift.AFTER))
    public void updateCameraAndRender(float partialTicks, long nanoTime, boolean renderWorldIn, CallbackInfo ci)
    {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null)
        {
            return;
        }

        MobEffectInstance smokeEffect = player.getEffect(ModEffects.SMOKED.get());

        if (smokeEffect != null)
        {
            Window window = Minecraft.getInstance().getWindow();
            float percent = Math.min((smokeEffect.getDuration() / (float) Config.SERVER.alphaFadeThreshold.get()), 1);
            GuiComponent.fill(new PoseStack(), 0, 0, window.getScreenWidth(), window.getScreenHeight(), ((int) (percent * 248 + 0.5) << 24) | 8156784);
        }
    }
}
