package zaeonninezero.grenadesadozen.init;

import zaeonninezero.grenadesadozen.GrenadesADozen;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Author: MrCrayfish
 */
public class ModParticleTypes
{
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, GrenadesADozen.MOD_ID);
    
    //public static final RegistryObject<SimpleParticleType> EXPLOSION = PARTICLES.register("explosion", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SMOKE_CLOUD = PARTICLES.register("smoke_cloud", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SMOKE_EFFECT = PARTICLES.register("smoke_effect", () -> new SimpleParticleType(true));
}
