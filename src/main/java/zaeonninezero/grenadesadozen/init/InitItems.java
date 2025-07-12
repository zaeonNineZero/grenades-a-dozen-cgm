package zaeonninezero.grenadesadozen.init;

import zaeonninezero.grenadesadozen.GrenadesADozen;
import zaeonninezero.grenadesadozen.item.grenade.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GrenadesADozen.MOD_ID);

   /* Grenades */
    public static final RegistryObject<Item> HE_GRENADE = ITEMS.register("he_grenade", () -> new HEGrenadeItem(new Item.Properties().tab(GrenadesADozen.GROUP), 20 * 4));
    public static final RegistryObject<Item> SMOKE_GRENADE = ITEMS.register("smoke_grenade", () -> new SmokeGrenadeItem(new Item.Properties().tab(GrenadesADozen.GROUP), 20 * 5));
    public static final RegistryObject<Item> INCENDIARY_GRENADE = ITEMS.register("incendiary_grenade", () -> new IncendiaryGrenadeItem(new Item.Properties().tab(GrenadesADozen.GROUP), 20 * 3));
    public static final RegistryObject<Item> MOLOTOV = ITEMS.register("molotov", () -> new MolotovItem(new Item.Properties().tab(GrenadesADozen.GROUP), 20 * 10));
    public static final RegistryObject<Item> IMPACT_GRENADE = ITEMS.register("impact_grenade", () -> new ImpactGrenadeItem(new Item.Properties().tab(GrenadesADozen.GROUP), 20 * 10));

    //public static final RegistryObject<Item> SMOKE_GRENADE_NO_PIN = ITEMS.register("smoke_grenade_no_pin", () -> new UnobtainableItem(new Item.Properties()));
    //public static final RegistryObject<Item> INCENDIARY_GRENADE_NO_PIN = ITEMS.register("incendiary_grenade_no_pin", () -> new UnobtainableItem(new Item.Properties()));
}