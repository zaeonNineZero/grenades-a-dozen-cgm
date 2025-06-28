package zaeonninezero.grenadesadozen.init;

import zaeonninezero.grenadesadozen.GrenadesADozen;
import com.mrcrayfish.guns.effect.IncurableEffect;
import zaeonninezero.grenadesadozen.effect.SmokedEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Author: MrCrayfish
 */
public class ModEffects
{
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GrenadesADozen.MOD_ID);

    public static final RegistryObject<SmokedEffect> SMOKED = EFFECTS.register("smoked", () -> new SmokedEffect(MobEffectCategory.HARMFUL, 0));
}
