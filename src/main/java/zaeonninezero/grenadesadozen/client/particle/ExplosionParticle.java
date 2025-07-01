package zaeonninezero.grenadesadozen.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/**
 * Author: MrCrayfish
 */
@OnlyIn(Dist.CLIENT)
public class ExplosionParticle extends TextureSheetParticle

{
    private final SpriteSet sprites;
    public ExplosionParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites)
    {
        super(level, x, y, z);
        this.gravity = 0.0F;
        this.scale(12.0F);
        this.quadSize = 1.0F;
        this.lifetime = 10;
        this.sprites = sprites;
        this.setSpriteFromAge(sprites);
    }

    @Override
    public @NotNull ParticleRenderType getRenderType()
    {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    public int getLightColor(float pPartialTick)
    {
        return 255;
    }

    public void tick()
    {
        super.tick();
        this.setSpriteFromAge(this.sprites);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet sprites;

        public Factory(SpriteSet sprites)
        {
            this.sprites = sprites;
        }

        public Particle createParticle(@NotNull SimpleParticleType typeIn, @NotNull ClientLevel levelIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed)
        {
            return new ExplosionParticle(levelIn, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites);
        }
    }
}
