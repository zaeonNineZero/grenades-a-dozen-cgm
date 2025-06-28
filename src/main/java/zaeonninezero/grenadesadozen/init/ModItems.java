package zaeonninezero.grenadesadozen.init;

import zaeonninezero.grenadesadozen.GrenadesADozen;
//import zaeonninezero.grenadesadozen.item.*;
import zaeonninezero.grenadesadozen.item.grenade.*;
import com.mrcrayfish.guns.item.AmmoItem;
import com.mrcrayfish.guns.item.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GrenadesADozen.MOD_ID);

   /* Grenades */
    //public static final RegistryObject<Item> GRENADE = ITEMS.register("grenade", () -> new GrenadeItem(new Item.Properties(), 20 * 3));
    public static final RegistryObject<Item> SMOKE_GRENADE = ITEMS.register("smoke_grenade", () -> new SmokeGrenadeItem(new Item.Properties(), 20 * 5));
    //public static final RegistryObject<Item> INCENDIARY_GRENADE = ITEMS.register("incendiary_grenade", () -> new IncendiaryGrenadeItem(new Item.Properties(), 20 * 3));
    //public static final RegistryObject<Item> MOLOTOV = ITEMS.register("molotov", () -> new MolotovItem(new Item.Properties(), 20 * 10));

    //public static final RegistryObject<Item> SMOKE_GRENADE_NO_PIN = ITEMS.register("smoke_grenade_no_pin", () -> new UnobtainableItem(new Item.Properties()));
    //public static final RegistryObject<Item> INCENDIARY_GRENADE_NO_PIN = ITEMS.register("incendiary_grenade_no_pin", () -> new UnobtainableItem(new Item.Properties()));
}