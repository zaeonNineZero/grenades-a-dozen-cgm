package zaeonninezero.grenadesadozen.network.message;

import com.mrcrayfish.framework.api.network.MessageContext;
import com.mrcrayfish.framework.api.network.message.PlayMessage;
import net.minecraft.network.FriendlyByteBuf;
import zaeonninezero.grenadesadozen.client.network.ClientPlayHandler;

public class S2CMessageMolotov extends PlayMessage<S2CMessageMolotov>
{
    private double x, y, z;

    public S2CMessageMolotov() {}

    public S2CMessageMolotov(double x, double y, double z)
    {
        this.z = z;
        this.y = y;
        this.x = x;
    }

    @Override
    public void encode(S2CMessageMolotov message, FriendlyByteBuf buffer)
    {
        buffer.writeDouble(message.x);
        buffer.writeDouble(message.y);
        buffer.writeDouble(message.z);
    }

    @Override
    public S2CMessageMolotov decode(FriendlyByteBuf buffer)
    {
        double x = buffer.readDouble();
        double y = buffer.readDouble();
        double z = buffer.readDouble();
        return new S2CMessageMolotov(x, y, z);
    }

    @Override
    public void handle(S2CMessageMolotov message, MessageContext context)
    {
        context.execute(() -> ClientPlayHandler.handleExplosionMolotov(message));
        context.setHandled(true);
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }
}