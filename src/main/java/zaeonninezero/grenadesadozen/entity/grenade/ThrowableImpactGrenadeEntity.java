package zaeonninezero.grenadesadozen.entity.grenade;

import com.mrcrayfish.guns.entity.ThrowableGrenadeEntity;
import com.mrcrayfish.guns.entity.ThrowableItemEntity;
import com.mrcrayfish.guns.Config;
import com.mrcrayfish.guns.entity.GrenadeEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import zaeonninezero.grenadesadozen.GrenadesConfig;
import zaeonninezero.grenadesadozen.init.InitEntities;
import zaeonninezero.grenadesadozen.init.InitItems;
import zaeonninezero.grenadesadozen.util.CGMExpandedHelper;

public class ThrowableImpactGrenadeEntity extends ThrowableGrenadeEntity
{
    protected float radius = GrenadesConfig.COMMON.impactGrenadeExplosionRadius.get().floatValue();
    protected float damage = GrenadesConfig.COMMON.impactGrenadeDamage.get().floatValue();
    protected boolean griefing = GrenadesConfig.COMMON.impactGrenadeGriefing.get();
    protected boolean globalGriefing = Config.COMMON.gameplay.griefing.enableBlockRemovalOnExplosions.get();

    public ThrowableImpactGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn)
    {
        super(entityType, worldIn);
    }

    public ThrowableImpactGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level world, LivingEntity entity)
    {
        super(entityType, world, entity);
        this.setItem(new ItemStack(InitItems.IMPACT_GRENADE.get()));
        this.setShouldBounce(false);
    }

    public ThrowableImpactGrenadeEntity(Level world, LivingEntity entity, int timeLeft)
    {
        super(InitEntities.THROWABLE_IMPACT_GRENADE.get(), world, entity);
        this.setItem(new ItemStack(InitItems.IMPACT_GRENADE.get()));
        this.setMaxLife(200);
        this.setShouldBounce(false);
    }

    @Override
    public void onDeath()
    {
    	if (CGMExpandedHelper.isExpandedInstalled())
			GrenadeEntity.createExplosion(this, radius, damage, griefing && globalGriefing);
    	else
    		GrenadeEntity.createExplosion(this, radius, !griefing);
    }
}
