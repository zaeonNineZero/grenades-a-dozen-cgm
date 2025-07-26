package zaeonninezero.grenadesadozen.client.network;

import net.minecraft.core.particles.ParticleOptions;
import zaeonninezero.grenadesadozen.GrenadesConfig;
import zaeonninezero.grenadesadozen.client.audio.*;
import zaeonninezero.grenadesadozen.network.message.*;
import zaeonninezero.grenadesadozen.init.InitParticleTypes;
import zaeonninezero.grenadesadozen.init.InitSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;

import java.util.*;

/**
 * Original Author: MrCrayfish
 */
public class ClientPlayHandler
{
    public static void handleExplosionIncendiaryGrenade(S2CMessageIncendiaryGrenade message)
    {
        Minecraft mc = Minecraft.getInstance();
        ParticleEngine particleManager = mc.particleEngine;
        Level world = Objects.requireNonNull(mc.level);
        float size = GrenadesConfig.COMMON.incendiaryGrenadeExplosionRadius.get().floatValue() * 2.0F;
        double x = message.getX();
        double y = message.getY();
        double z = message.getZ();
        
        //Play explosion sound
        Minecraft.getInstance().getSoundManager().play(new IncendiaryGrenadeExplosionSound(InitSounds.INCENDIARY_GRENADE_EXPLOSION.getId(), SoundSource.BLOCKS, (float) x,(float) y, (float) z, 1, 1, world.getRandom()));
        
        //Spawn explosion particle
        Particle explosion = spawnParticle(particleManager, InitParticleTypes.EXPLOSION.get(), x, y, z, world.random, 0.0);
        explosion.scale(size);

        //Spawn fast moving flame particles
        for(int i = 0; i < 90; i++)
        {
            Particle flame = spawnParticle(particleManager, ParticleTypes.FLAME, x, y, z, world.random, 1.5);
            flame.setLifetime((int) ((8 / (Math.random() * 0.1 + 0.6)) * 0.5));
            flame.scale(3f);
        }
    }

    public static void handleExplosionMolotov(S2CMessageMolotov message)
    {
        Minecraft mc = Minecraft.getInstance();
        ParticleEngine particleManager = mc.particleEngine;
        Level world = Objects.requireNonNull(mc.level);
        float size = GrenadesConfig.COMMON.molotovExplosionRadius.get().floatValue() * 2.0F;
        double x = message.getX();
        double y = message.getY();
        double z = message.getZ();
        
        //Play molotov break sound
        Minecraft.getInstance().getSoundManager().play(new MolotovExplosionSound(InitSounds.MOLOTOV_BREAK.getId(), SoundSource.BLOCKS, (float) x,(float) y, (float) z, 1, 1, world.getRandom()));
        
        //Play explosion sound
        Minecraft.getInstance().getSoundManager().play(new MolotovExplosionSound(InitSounds.MOLOTOV_EXPLOSION.getId(), SoundSource.BLOCKS, (float) x,(float) y, (float) z, 1, 1, world.getRandom()));
        
        //Spawn explosion particle
        Particle explosion = spawnParticle(particleManager, InitParticleTypes.EXPLOSION.get(), x, y, z, world.random, 0.0);
        explosion.scale(size);

        //Spawn fast moving flame particles
        for(int i = 0; i < 90; i++)
        {
            Particle flame = spawnParticle(particleManager, ParticleTypes.FLAME, x, y, z, world.random, 1.5);
            flame.setLifetime((int) ((8 / (Math.random() * 0.1 + 0.6)) * 0.5));
            flame.scale(3f);
        }
    }

    public static void handleExplosionSmokeGrenade(S2CMessageSmokeGrenade message)
    {
        Minecraft mc = Minecraft.getInstance();
        Level world = Objects.requireNonNull(mc.level);
        double x = message.getX();
        double y = message.getY();
        double z = message.getZ();
        double diameter = GrenadesConfig.COMMON.smokeGrenadeCloudDiameter.get();
        double vel = 0.004;
        int amount = (int) (diameter * 15);
        
        //Play explosion sound
        Minecraft.getInstance().getSoundManager().play(new SmokeGrenadeExplosionSound(InitSounds.SMOKE_GRENADE_EXPLOSION.getId(), SoundSource.BLOCKS, (float) x,(float) y, (float) z, 1, 1, world.getRandom()));
        
        /* Spawn smoke cloud */
        for(int i = 0; i < amount; i++)
        {
            world.addAlwaysVisibleParticle(InitParticleTypes.SMOKE_CLOUD.get(),
                    true,
                    x+((Math.random()-0.5) * diameter),
                    y+0.1+(Math.random() * (diameter * 0.65)),
                    z+((Math.random()-0.5) * diameter),
                    (Math.random()-0.5) * vel,
                    Math.random() * (vel * 0.5),
                    (Math.random()-0.5) * vel);
        }
    }

    public static Particle spawnParticle(ParticleEngine manager, ParticleOptions data, double x, double y, double z, RandomSource rand, double velocityMultiplier)
    {
        return manager.createParticle(data, x, y, z, (rand.nextDouble() - 0.5) * velocityMultiplier, (rand.nextDouble() - 0.5) * velocityMultiplier, (rand.nextDouble() - 0.5) * velocityMultiplier);
    }

    private static double getRandomDir(RandomSource random)
    {
        return -0.25 + random.nextDouble() * 0.5;
    }
}
