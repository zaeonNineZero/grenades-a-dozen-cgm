package zaeonninezero.grenadesadozen.client;

import zaeonninezero.grenadesadozen.GrenadesADozen;
import zaeonninezero.grenadesadozen.init.InitItems;
import zaeonninezero.grenadesadozen.util.CGMExpandedHelper;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = GrenadesADozen.MOD_ID, value = Dist.CLIENT)
public class ClientHandler
{

    public static void setup()
    {
        registerItemProperties();
    }
    
    private static void registerItemProperties()
    {
    	if(CGMExpandedHelper.isExpandedInstalled())
    	{
	    	ItemProperties.register(InitItems.HE_GRENADE.get(), 
	    		new ResourceLocation("throwing"), (stack, level, living, id) -> {
	    			return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
	    		}
	    	);
	    	ItemProperties.register(InitItems.SMOKE_GRENADE.get(), 
	    		new ResourceLocation("throwing"), (stack, level, living, id) -> {
	    			return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
	    		}
	    	);
	    	ItemProperties.register(InitItems.INCENDIARY_GRENADE.get(), 
	        	new ResourceLocation("throwing"), (stack, level, living, id) -> {
	        		return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
	        	}
	        );
	    	ItemProperties.register(InitItems.MOLOTOV.get(), 
	        	new ResourceLocation("throwing"), (stack, level, living, id) -> {
	        		return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
	        	}
	        );
	    	ItemProperties.register(InitItems.IMPACT_GRENADE.get(), 
	        	new ResourceLocation("throwing"), (stack, level, living, id) -> {
	        		return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
	        	}
	        );
    	}
    }
}
