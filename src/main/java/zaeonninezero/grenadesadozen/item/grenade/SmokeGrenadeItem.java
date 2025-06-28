package zaeonninezero.grenadesadozen.item.grenade;

import com.mrcrayfish.guns.entity.ThrowableGrenadeEntity;
import zaeonninezero.grenadesadozen.GrenadesConfig;
import zaeonninezero.grenadesadozen.entity.grenade.ThrowableSmokeGrenadeEntity;
import com.mrcrayfish.guns.item.GrenadeItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Author: MrCrayfish
 */
public class SmokeGrenadeItem extends GrenadeItem
{
    public SmokeGrenadeItem(Properties properties, int maxCookTime)
    {
        super(properties, maxCookTime);
    }

    /*@Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag)
    {
        double damage = 0;//Config.COMMON.smokeGrenadeDamage.get();
        double smokeDuration = GrenadesConfig.COMMON.smokeGrenadeCloudDuration.get();
        double smokeDiameter = GrenadesConfig.COMMON.smokeGrenadeCloudDiameter.get();
        float cookTime = (float) maxCookTime / 20;
        /*if(Screen.hasControlDown())
        {
            tooltip.add(Component.translatable("info.cgm.stats").withStyle(ChatFormatting.GOLD));
            tooltip.add(Component.translatable("info.cgm.damage_tick", ChatFormatting.WHITE + ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(damage)).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("info.cgm.smoke_duration", ChatFormatting.WHITE + ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(smokeDuration)).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("info.cgm.smoke_diameter", ChatFormatting.WHITE + ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(smokeDiameter)).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("info.cgm.fuse", ChatFormatting.WHITE + ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(cookTime)).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("info.cgm.extinguish").withStyle(ChatFormatting.GRAY));
        }
        else
        {
            tooltip.add(Component.translatable("info.cgm.stats_help").withStyle(ChatFormatting.GOLD));
        }
    }*/

    @Override
    public ThrowableGrenadeEntity create(Level world, LivingEntity entity, int timeLeft)
    {
        return new ThrowableSmokeGrenadeEntity(world, entity, timeLeft);
    }
}
