package zaeonninezero.grenadesadozen.entity.grenade;

import com.mrcrayfish.framework.api.network.LevelLocation;
import com.mrcrayfish.guns.entity.ThrowableGrenadeEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import zaeonninezero.grenadesadozen.GrenadesConfig;
import zaeonninezero.grenadesadozen.client.audio.IncendiaryGrenadeExplosionSound;
import zaeonninezero.grenadesadozen.init.InitEntities;
import zaeonninezero.grenadesadozen.init.InitItems;
import zaeonninezero.grenadesadozen.init.InitSounds;
import zaeonninezero.grenadesadozen.network.GrenadePacketHandler;
import zaeonninezero.grenadesadozen.network.message.S2CMessageIncendiaryGrenade;
import zaeonninezero.grenadesadozen.util.GrenadeHelper;

/**
 * Author: MrCrayfish
 */
public class ThrowableIncendiaryGrenadeEntity extends ThrowableGrenadeEntity
{
    protected float radius = GrenadesConfig.COMMON.incendiaryGrenadeExplosionRadius.get().floatValue();
    protected int fireDuration = GrenadesConfig.COMMON.incendiaryGrenadeFireDuration.get();
    protected float pitch = 0.9F + level.random.nextFloat() * 0.1F;

    public ThrowableIncendiaryGrenadeEntity(EntityType<? extends ThrowableGrenadeEntity> entityType, Level world)
    {
        super(entityType, world);
    }

    public ThrowableIncendiaryGrenadeEntity(EntityType<? extends ThrowableGrenadeEntity> entityType, Level world, LivingEntity player)
    {
        super(entityType, world, player);
        this.setItem(new ItemStack(InitItems.INCENDIARY_GRENADE.get()));
    }

    public ThrowableIncendiaryGrenadeEntity(Level world, LivingEntity player, int timeLeft)
    {
        super(InitEntities.THROWABLE_INCENDIARY_GRENADE.get(), world, player);
        this.setItem(new ItemStack(InitItems.INCENDIARY_GRENADE.get()));
        this.setMaxLife(timeLeft);
    }

    @Override
    public void tick()
    {
        super.tick();
        this.prevRotation = this.rotation;
        double speed = this.getDeltaMovement().length();
        if (speed > 0.1)
            this.rotation += (speed * 50);
        if (this.level.isClientSide)
            this.level.addParticle(ParticleTypes.FLAME, true, this.getX(), this.getY() + 0.25, this.getZ(), (Math.random()-0.5) * 0.1, 0.1, (Math.random()-0.5) * 0.1);
    }

    @Override
    public void onDeath()
    {
        double y = this.getY() + this.getType().getDimensions().height * 0.5;
        Vec3 center = new Vec3(this.getX(), y, this.getZ());

        //Minecraft.getInstance().getSoundManager().play(new IncendiaryGrenadeExplosionSound(InitSounds.INCENDIARY_GRENADE_EXPLOSION.getId(), SoundSource.BLOCKS, (float)this.getX(),(float)y, (float)this.getZ(), 1, pitch, this.level.getRandom()));
        if(this.level.isClientSide)
        {
            return;
        }
        GrenadePacketHandler.getPlayChannel().sendToNearbyPlayers(() ->
                LevelLocation.create(this.level, this.getX(), y, this.getZ(), 256), new S2CMessageIncendiaryGrenade(this.getX(), y, this.getZ()));
        GrenadeHelper.createFireExplosion(this, radius * 0.6F);
        GrenadeHelper.igniteEntities(level, center, radius * 1.1F, fireDuration);
    }
}
