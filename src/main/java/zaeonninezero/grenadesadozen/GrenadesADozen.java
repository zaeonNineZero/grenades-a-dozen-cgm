package zaeonninezero.grenadesadozen;

import zaeonninezero.grenadesadozen.client.ClientHandler;
import zaeonninezero.grenadesadozen.init.*;
import zaeonninezero.grenadesadozen.network.GrenadePacketHandler;

import com.mrcrayfish.framework.api.FrameworkAPI;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("grenadesadozen")
public class GrenadesADozen {
	public static final String MOD_ID = "grenadesadozen";
    public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID)
    {
        @Override
        public ItemStack makeIcon()
        {
            ItemStack stack = new ItemStack(ModItems.SMOKE_GRENADE.get());
            return stack;
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items)
        {
            super.fillItemList(items);
        }
    };
	
	public GrenadesADozen() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GrenadesConfig.commonSpec);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, GrenadesConfig.serverSpec);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		//Registers all of the Deferred Registers from the init classes.
		ModEffects.EFFECTS.register(bus);
		ModEntities.ENTITIES.register(bus);
		ModItems.ITEMS.register(bus);
		ModParticleTypes.PARTICLES.register(bus);
		ModSounds.SOUNDS.register(bus);

		bus.addListener(this::setup);
		bus.addListener(this::onClientSetup);
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	//Common setup
	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() ->
        {
            GrenadePacketHandler.init();
        });
		//System.out.println("Grenades a Dozen pre-initialized.");
	}
	
	//Client setup
	private void onClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(ClientHandler::setup);
	}

	//Needed to support loading embedded resource packs
	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}