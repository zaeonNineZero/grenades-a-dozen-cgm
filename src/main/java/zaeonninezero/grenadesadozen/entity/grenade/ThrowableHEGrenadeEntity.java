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
import zaeonninezero.grenadesadozen.init.ModEntities;
import zaeonninezero.grenadesadozen.init.ModItems;
import zaeonninezero.grenadesadozen.util.CGMExpandedHelper;

public class ThrowableHEGrenadeEntity extends ThrowableGrenadeEntity
{
    protected float radius = GrenadesConfig.COMMON.heGrenadeExplosionRadius.get().floatValue();
    protected float damage = GrenadesConfig.COMMON.heGrenadeDamage.get().floatValue();
    protected boolean griefing = GrenadesConfig.COMMON.heGrenadeGriefing.get();
    protected boolean globalGriefing = Config.COMMON.gameplay.griefing.enableBlockRemovalOnExplosions.get();

    public ThrowableHEGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn)
    {
        super(entityType, worldIn);
    }

    public ThrowableHEGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level world, LivingEntity entity)
    {
        super(entityType, world, entity);
        this.setItem(new ItemStack(ModItems.HE_GRENADE.get()));
        this.setShouldBounce(true);
        this.setMaxLife(20 * 4);
    }

    public ThrowableHEGrenadeEntity(Level world, LivingEntity entity, int timeLeft)
    {
        super(ModEntities.THROWABLE_HE_GRENADE.get(), world, entity);
        this.setItem(new ItemStack(ModItems.HE_GRENADE.get()));
        this.setMaxLife(timeLeft);
        this.setShouldBounce(true);
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
