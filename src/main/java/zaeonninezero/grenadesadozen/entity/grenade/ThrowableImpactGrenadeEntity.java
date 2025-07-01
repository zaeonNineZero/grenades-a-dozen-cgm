package zaeonninezero.grenadesadozen.entity.grenade;

import com.mrcrayfish.guns.entity.ThrowableGrenadeEntity;
import com.mrcrayfish.guns.entity.ThrowableItemEntity;
import com.mrcrayfish.guns.entity.GrenadeEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import zaeonninezero.grenadesadozen.GrenadesConfig;
import zaeonninezero.grenadesadozen.init.ModEntities;
import zaeonninezero.grenadesadozen.init.ModItems;

public class ThrowableImpactGrenadeEntity extends ThrowableGrenadeEntity
{
    protected float radius = GrenadesConfig.COMMON.impactGrenadeExplosionRadius.get().floatValue();
    protected boolean griefing = !GrenadesConfig.COMMON.impactGrenadeGriefing.get();

    public ThrowableImpactGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn)
    {
        super(entityType, worldIn);
    }

    public ThrowableImpactGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level world, LivingEntity entity)
    {
        super(entityType, world, entity);
        this.setItem(new ItemStack(ModItems.IMPACT_GRENADE.get()));
        this.setShouldBounce(false);
    }

    public ThrowableImpactGrenadeEntity(Level world, LivingEntity entity, int timeLeft)
    {
        super(ModEntities.THROWABLE_IMPACT_GRENADE.get(), world, entity);
        this.setItem(new ItemStack(ModItems.IMPACT_GRENADE.get()));
        this.setMaxLife(200);
        this.setShouldBounce(false);
    }

    @Override
    public void onDeath()
    {
        GrenadeEntity.createExplosion(this, radius, griefing);
    }
}
