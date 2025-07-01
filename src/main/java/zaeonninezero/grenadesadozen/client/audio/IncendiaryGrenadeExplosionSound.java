package zaeonninezero.grenadesadozen.client.audio;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import zaeonninezero.grenadesadozen.GrenadesConfig;

/**
 * Author: MrCrayfish
 */
public class IncendiaryGrenadeExplosionSound extends AbstractSoundInstance
{
    public IncendiaryGrenadeExplosionSound(ResourceLocation soundIn, SoundSource categoryIn, float x, float y, float z, float volume, float pitch, RandomSource source)
    {
        super(soundIn, categoryIn, source);
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.attenuation = Attenuation.NONE;

        LocalPlayer player = Minecraft.getInstance().player;
        if(player != null)
        {
            float distance = GrenadesConfig.SERVER.incendiaryGrenadeExplosionSoundDistance.get().floatValue();
            this.volume = volume * (1.0F - Math.min(1.0F, (float) Math.sqrt(player.distanceToSqr(x, y, z)) / distance));
            this.volume *= this.volume; //Ease the volume instead of linear
        }
    }
}
