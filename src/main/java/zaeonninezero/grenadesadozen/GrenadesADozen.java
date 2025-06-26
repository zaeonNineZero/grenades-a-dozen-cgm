package zaeonninezero.grenadesadozen;

import zaeonninezero.grenadesadozen.init.*;
import zaeonninezero.grenadesadozen.client.ClientHandler;

import com.mrcrayfish.guns.client.CustomGunManager;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("grenadesadozen")
public class GrenadesADozen {
	public static final String MOD_ID = "grenadesadozen";
    /*public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID)
    {
        @Override
        public ItemStack makeIcon()
        {
            ItemStack stack = new ItemStack(initItems.COMBAT_PISTOL.get());
            stack.getOrCreateTag().putInt("IgnoreAmmo", 1);
            return stack;
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items)
        {
            super.fillItemList(items);
            CustomGunManager.fill(items);
        }
    };*/
	
	public GrenadesADozen() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		//Registers all of the Deferred Registers from the init classes.
		initItems.ITEMS.register(bus);
		initSounds.SOUNDS.register(bus);
		
		bus.addListener(this::onClientSetup);
	}
	
	//Common setup
	private void setup(final FMLCommonSetupEvent event) {
		System.out.println("Grenades a Dozen pre-initialized.");
	}
	
	//Client setup
	private void onClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(ClientHandler::setup);
	}
}