package zaeonninezero.grenadesadozen.client;

import zaeonninezero.grenadesadozen.GrenadesADozen;
import zaeonninezero.grenadesadozen.client.particle.*;
import zaeonninezero.grenadesadozen.init.ModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = GrenadesADozen.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleFactoryRegistry
{
    @SubscribeEvent
    public static void onRegisterParticleFactory(RegisterParticleProvidersEvent event)
    {
        ParticleEngine particleManager = Minecraft.getInstance().particleEngine;
        particleManager.register(ModParticleTypes.EXPLOSION.get(), ExplosionParticle.Factory::new);
        particleManager.register(ModParticleTypes.SMOKE_CLOUD.get(), SmokeCloudParticle.Factory::new);
        particleManager.register(ModParticleTypes.SMOKE_EFFECT.get(), SmokeEffectParticle.Factory::new);
    }
}
