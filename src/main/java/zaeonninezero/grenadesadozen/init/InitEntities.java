package zaeonninezero.grenadesadozen.init;

import zaeonninezero.grenadesadozen.GrenadesADozen;
import zaeonninezero.grenadesadozen.entity.grenade.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;

/**
 * Author: MrCrayfish
 */
public class InitEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GrenadesADozen.MOD_ID);

    public static final RegistryObject<EntityType<ThrowableSmokeGrenadeEntity>> THROWABLE_SMOKE_GRENADE = registerBasic("throwable_smoke_grenade", ThrowableSmokeGrenadeEntity::new);
    public static final RegistryObject<EntityType<ThrowableIncendiaryGrenadeEntity>> THROWABLE_INCENDIARY_GRENADE = registerBasic("throwable_incendiary_grenade", ThrowableIncendiaryGrenadeEntity::new);
    public static final RegistryObject<EntityType<ThrowableMolotovEntity>> THROWABLE_MOLOTOV = registerBasic("throwable_molotov", ThrowableMolotovEntity::new);
    public static final RegistryObject<EntityType<ThrowableImpactGrenadeEntity>> THROWABLE_IMPACT_GRENADE = registerBasic("throwable_impact_grenade", ThrowableImpactGrenadeEntity::new);
    public static final RegistryObject<EntityType<ThrowableHEGrenadeEntity>> THROWABLE_HE_GRENADE = registerBasic("throwable_he_grenade", ThrowableHEGrenadeEntity::new);

    private static <T extends Entity> RegistryObject<EntityType<T>> registerBasic(String id, BiFunction<EntityType<T>, Level, T> function)
    {
        return ENTITIES.register(id, () -> EntityType.Builder.of(function::apply, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .setTrackingRange(256)
                .setUpdateInterval(1)
                .noSummon()
                .fireImmune()
                .setShouldReceiveVelocityUpdates(true).build(id));
    }
}
