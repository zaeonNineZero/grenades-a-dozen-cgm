package zaeonninezero.grenadesadozen.init;

import zaeonninezero.grenadesadozen.GrenadesADozen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds
{
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GrenadesADozen.MOD_ID);

	/* Grenades */
	//public static final RegistryObject<SoundEvent> GRENADE_THROW = register("item.grenade.throw");
	//public static final RegistryObject<SoundEvent> MOLOTOV_LIGHT = register("item.molotov.light");

	/* Explosions */
	public static final RegistryObject<SoundEvent> INCENDIARY_GRENADE_EXPLOSION = register("entity.incendiary_grenade.explode");
	public static final RegistryObject<SoundEvent> MOLOTOV_EXPLOSION = register("entity.molotov.explode");
	public static final RegistryObject<SoundEvent> SMOKE_GRENADE_EXPLOSION = register("entity.smoke_grenade.explode");

	private static RegistryObject<SoundEvent> register(String key)
	{
		return SOUNDS.register(key, () -> new SoundEvent(new ResourceLocation(GrenadesADozen.MOD_ID, key)));
	}
}
