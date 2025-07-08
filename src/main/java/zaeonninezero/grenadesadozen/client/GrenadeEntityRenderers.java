package zaeonninezero.grenadesadozen.client;

import zaeonninezero.grenadesadozen.GrenadesADozen;
import zaeonninezero.grenadesadozen.init.InitEntities;
import com.mrcrayfish.guns.client.render.entity.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = GrenadesADozen.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GrenadeEntityRenderers
{
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(InitEntities.THROWABLE_HE_GRENADE.get(), ThrowableGrenadeRenderer::new);
        event.registerEntityRenderer(InitEntities.THROWABLE_SMOKE_GRENADE.get(), ThrowableGrenadeRenderer::new);
        event.registerEntityRenderer(InitEntities.THROWABLE_INCENDIARY_GRENADE.get(), ThrowableGrenadeRenderer::new);
        event.registerEntityRenderer(InitEntities.THROWABLE_MOLOTOV.get(), ThrowableGrenadeRenderer::new);
        event.registerEntityRenderer(InitEntities.THROWABLE_IMPACT_GRENADE.get(), ThrowableGrenadeRenderer::new);
    }
}
