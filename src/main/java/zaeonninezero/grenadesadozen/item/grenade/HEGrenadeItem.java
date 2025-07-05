package zaeonninezero.grenadesadozen.item.grenade;

import com.mrcrayfish.guns.item.GrenadeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import zaeonninezero.grenadesadozen.entity.grenade.ThrowableHEGrenadeEntity;

public class HEGrenadeItem extends GrenadeItem
{
    public HEGrenadeItem(Properties properties, int maxCookTime)
    {
        super(properties, maxCookTime);
    }

    /*
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag)
    {
        double fireDiameter = (Config.COMMON.incendiaryGrenadeExplosionRadius.get() * 2F);
        int fireDuration = Config.COMMON.incendiaryGrenadeFireDuration.get();
        float cookTime = (float) maxCookTime / 20;
        if(Screen.hasControlDown())
        {
            tooltip.add(Component.translatable("info.cgm.stats").withStyle(ChatFormatting.GOLD));
            tooltip.add(Component.translatable("info.cgm.fire_diameter", ChatFormatting.WHITE + ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(fireDiameter)).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("info.cgm.fire_duration", ChatFormatting.WHITE + ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(fireDuration)).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("info.cgm.fuse", ChatFormatting.WHITE + ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(cookTime)).withStyle(ChatFormatting.GRAY));
        }
        else
        {
            tooltip.add(Component.translatable("info.cgm.stats_help").withStyle(ChatFormatting.GOLD));
        }
    }
    */

    @Override
    public ThrowableHEGrenadeEntity create(Level world, LivingEntity entity, int timeLeft)
    {
        return new ThrowableHEGrenadeEntity(world, entity, timeLeft);
    }
}
