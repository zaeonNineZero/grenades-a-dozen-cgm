package zaeonninezero.grenadesadozen.item.grenade;

import com.mrcrayfish.guns.entity.ThrowableGrenadeEntity;
import com.mrcrayfish.guns.init.ModSounds;
import com.mrcrayfish.guns.item.GrenadeItem;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import zaeonninezero.grenadesadozen.entity.grenade.ThrowableImpactGrenadeEntity;
import zaeonninezero.grenadesadozen.init.InitSounds;
import zaeonninezero.grenadesadozen.util.CGMExpandedHelper;

public class ImpactGrenadeItem extends GrenadeItem
{
    public ImpactGrenadeItem(Properties properties, int maxCookTime)
    {
        super(properties, maxCookTime);
    }

    @Override
    public boolean canCook()
    {
        return false;
    }

    /*
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag)
    {
        double damage = Config.COMMON.impactGrenadeExplosionDamage.get();
        if(Screen.hasControlDown())
        {
            tooltip.add(Component.translatable("info.cgm.stats").withStyle(ChatFormatting.GOLD));
            tooltip.add(Component.translatable("info.cgm.damage", ChatFormatting.WHITE + ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(damage)).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("info.cgm.explodes_on_impact").withStyle(ChatFormatting.GRAY));
        }
        else
        {
            tooltip.add(Component.translatable("info.cgm.stats_help").withStyle(ChatFormatting.GOLD));
        }
    }
    */

    @Override
    public ThrowableGrenadeEntity create(Level world, LivingEntity entity, int timeLeft)
    {
        return new ThrowableImpactGrenadeEntity(world, entity, timeLeft);
    }

    @Override
    protected void onThrown(Level world, ThrowableGrenadeEntity entity)
    {
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.ITEM_GRENADE_PIN.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
    	/*if (CGMExpandedHelper.isExpandedInstalled())
    		world.playSound(null, entity.getX(), entity.getY()+1, entity.getZ(), InitSounds.GRENADE_THROW.get(), SoundSource.PLAYERS, 1.0F, 1.0F);*/
    }
}
