package zaeonninezero.grenadesadozen.util;

import com.mrcrayfish.guns.interfaces.IExplosionDamageable;
import com.mrcrayfish.guns.world.ProjectileExplosion;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class GrenadeHelper
{
    public static void igniteEntities(Level level, Vec3 center, float radius, int fireDuration)
    {
        int minX = Mth.floor(center.x - radius);
        int maxX = Mth.floor(center.x + radius);
        int minY = Mth.floor(center.y - radius);
        int maxY = Mth.floor(center.y + radius);
        int minZ = Mth.floor(center.z - radius);
        int maxZ = Mth.floor(center.z + radius);

        double radiusSq = radius * radius;

        for(LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, new AABB(minX, minY, minZ, maxX, maxY, maxZ)))
        {
            if(entity.ignoreExplosion()) continue;

            Vec3 entityPos = entity.getBoundingBox().getCenter();
            double distanceSq = center.distanceToSqr(entityPos);

            if(distanceSq > radiusSq) continue;

            ClipContext context = new ClipContext(
                center,
                entityPos,
                ClipContext.Block.COLLIDER,
                ClipContext.Fluid.NONE,
                null
            );

            if(level.clip(context).getType() == HitResult.Type.MISS)
                entity.setSecondsOnFire(fireDuration);
        }
    }

    /**
     * Creates an explosion with customizable parameters. Don't use outside this class.
     *
     * @param entity The entity to explode
     * @param radius The size of the explosion
     */
    public static void createFireExplosion(Entity entity, float radius)
    {
        Level world = entity.level;
        if (world.isClientSide()) return;

        // Common parameters
        DamageSource source = null;

        Explosion explosion = new ProjectileExplosion(world, entity, source, null,
                entity.getX(), entity.getY(), entity.getZ(), radius, true, Explosion.BlockInteraction.NONE);

        if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(world, explosion)) return;

        explosion.explode();
        explosion.finalizeExplosion(true);

        // Handle block explosion effects
        explosion.getToBlow().forEach(pos -> {
            if (world.getBlockState(pos).getBlock() instanceof IExplosionDamageable) {
                ((IExplosionDamageable) world.getBlockState(pos).getBlock())
                        .onProjectileExploded(world, world.getBlockState(pos), pos, entity);
            }
        });

        explosion.clearToBlow();
    }
}