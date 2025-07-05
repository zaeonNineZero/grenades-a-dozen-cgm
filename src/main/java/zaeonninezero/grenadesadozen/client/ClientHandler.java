package zaeonninezero.grenadesadozen.client;

import zaeonninezero.grenadesadozen.GrenadesADozen;
import zaeonninezero.grenadesadozen.init.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.glfw.GLFW;

import java.lang.reflect.Field;

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
    	// TODO: Make certain item properties only be registered when CGM Expanded is installed

    	ItemProperties.register(ModItems.HE_GRENADE.get(), 
    		new ResourceLocation("throwing"), (stack, level, living, id) -> {
    			return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
    		}
    	);
    	ItemProperties.register(ModItems.SMOKE_GRENADE.get(), 
    		new ResourceLocation("throwing"), (stack, level, living, id) -> {
    			return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
    		}
    	);
    	ItemProperties.register(ModItems.INCENDIARY_GRENADE.get(), 
        	new ResourceLocation("throwing"), (stack, level, living, id) -> {
        		return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
        	}
        );
    	ItemProperties.register(ModItems.MOLOTOV.get(), 
        	new ResourceLocation("throwing"), (stack, level, living, id) -> {
        		return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
        	}
        );
    	ItemProperties.register(ModItems.IMPACT_GRENADE.get(), 
        	new ResourceLocation("throwing"), (stack, level, living, id) -> {
        		return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
        	}
        );
    }
}
