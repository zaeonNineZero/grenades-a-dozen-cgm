package zaeonninezero.grenadesadozen.network;

import com.mrcrayfish.framework.api.FrameworkAPI;
import com.mrcrayfish.framework.api.network.FrameworkNetwork;
import com.mrcrayfish.framework.api.network.MessageDirection;
import zaeonninezero.grenadesadozen.GrenadesADozen;
import zaeonninezero.grenadesadozen.network.message.*;
import net.minecraft.resources.ResourceLocation;

public class GrenadePacketHandler
{
    private static FrameworkNetwork playChannel;

    public static void init()
    {
        playChannel = FrameworkAPI.createNetworkBuilder(new ResourceLocation(GrenadesADozen.MOD_ID, "play"), 1)
                .registerPlayMessage(S2CMessageIncendiaryGrenade.class, MessageDirection.PLAY_CLIENT_BOUND)
                .registerPlayMessage(S2CMessageMolotov.class, MessageDirection.PLAY_CLIENT_BOUND)
                .registerPlayMessage(S2CMessageSmokeGrenade.class, MessageDirection.PLAY_CLIENT_BOUND)
                .build();
    }

    /**
     * Gets the play network channel for Grenades a Dozen
     */
    public static FrameworkNetwork getPlayChannel()
    {
        return playChannel;
    }
}