package zaeonninezero.grenadesadozen;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class GrenadesConfig
{
    /**
     * Client config options
     */
    public static class Client {
        /* nothing yet */
    }

    /**
     * Common config options
     */
    public static class Common {
        /* Common - Grenades/Explosives */
        public final ForgeConfigSpec.DoubleValue heGrenadeDamage;
        public final ForgeConfigSpec.DoubleValue heGrenadeExplosionRadius;
        public final ForgeConfigSpec.BooleanValue heGrenadeGriefing;
        public final ForgeConfigSpec.DoubleValue impactGrenadeDamage;
        public final ForgeConfigSpec.DoubleValue impactGrenadeExplosionRadius;
        public final ForgeConfigSpec.BooleanValue impactGrenadeGriefing;
        public final ForgeConfigSpec.DoubleValue smokeGrenadeCloudDiameter;
        //public final ForgeConfigSpec.DoubleValue smokeGrenadeDamage;
        public final ForgeConfigSpec.DoubleValue smokeGrenadeCloudDuration;
        public final ForgeConfigSpec.BooleanValue incendiaryGrenadesSetsFire;
        public final ForgeConfigSpec.DoubleValue incendiaryGrenadeExplosionRadius;
        public final ForgeConfigSpec.IntValue incendiaryGrenadeFireDuration;
        public final ForgeConfigSpec.DoubleValue molotovExplosionRadius;
        public final ForgeConfigSpec.IntValue molotovFireDuration;

        public Common(ForgeConfigSpec.Builder builder)
        {
        	builder.push("he_grenade");{
        		this.heGrenadeDamage = builder.comment("The maximum damage dealt by thrown high explosive grenades. This only works when CGM Expanded is installed -- otherwise damage is scaled to explosion radius!").defineInRange("heGrenadeDamage", 24.0, 0.0, Double.MAX_VALUE);
        		this.heGrenadeExplosionRadius = builder.comment("The explosion radius of high explosive grenades. This determines the power of the explosion on blocks, and the maximum range at which damage can be dealt.").defineInRange("heGrenadeExplosionRadius", 5.0, 0.0, Double.MAX_VALUE);
                this.heGrenadeGriefing = builder.comment("If enabled, high explosive grenades can destroy blocks. This respects CGM's block removal setting.").define("heGrenadeGriefing", true);
            }builder.pop();
            builder.push("impact_grenade");{
                this.impactGrenadeDamage = builder.comment("The maximum damage dealt by thrown impact grenades. This only works when CGM Expanded is installed -- otherwise damage is scaled to explosion radius!").defineInRange("impactGrenadeDamage", 19.0, 0.0, Double.MAX_VALUE);
                this.impactGrenadeExplosionRadius = builder.comment("The explosion radius of impact grenades. This determines the power of the explosion on blocks, and the maximum range at which damage can be dealt.").defineInRange("impactGrenadeExplosionRadius", 4.5, 0.0, Double.MAX_VALUE);
                this.impactGrenadeGriefing = builder.comment("If enabled, impact grenades can destroy blocks. This respects CGM's block removal setting.").define("impactGrenadeGriefing", false);
            }builder.pop();
            builder.push("smoke_grenade");{
                this.smokeGrenadeCloudDiameter = builder.comment("The diameter of Smoke Grenade's smoke cloud. Caution: high diameter values will spawn more particles and cause lag.").defineInRange("smokeGrenadeCloudDiameter", 5.0, 0.0, Double.MAX_VALUE);
                //this.smokeGrenadeDamage = builder.comment("The damage dealt per second to players and mobs that are inside a Smoke Grenade cloud.").defineInRange("smokeGrenadeDamage", 1.0, 0.0, Double.MAX_VALUE);
                this.smokeGrenadeCloudDuration = builder.comment("How long the smoke cloud of a Smoke Grenade lasts for, in seconds.").defineInRange("smokeGrenadeCloudDuration", 20.0, 0.0, Double.MAX_VALUE);
            }builder.pop();
            builder.push("incendiary_grenade");{
                this.incendiaryGrenadeExplosionRadius = builder.comment("The blast radius of Incendiary Grenades. This determines the maximum range in which players, mobs, and blocks may be set on fire.").defineInRange("incendiaryGrenadeExplosionRadius", 3.5, 0.0, Double.MAX_VALUE);
                this.incendiaryGrenadeFireDuration = builder.comment("Duration of fire set on entities by Incendiary Grenade blasts.").defineInRange("incendiaryGrenadeFireDuration", 15, 0, Integer.MAX_VALUE);
            }builder.pop();
            builder.push("molotov_cocktail");{
                this.molotovExplosionRadius = builder.comment("The blast radius of Incendiary Grenades. This determines the maximum range in which players, mobs, and blocks may be set on fire..").defineInRange("molotovExplosionRadius", 2.5, 0.0, Double.MAX_VALUE);
                this.molotovFireDuration = builder.comment("Duration of fire set on entities by Molotov Cocktail blasts.").defineInRange("molotovFireDuration", 10, 0, Integer.MAX_VALUE);
            }builder.pop();
            this.incendiaryGrenadesSetsFire = builder.comment("If enabled, all incendiary grenades and the Molotov Cocktail will set blocks on fire. Disabling this may reduce the effectiveness of incendiaries in combat!").define("incendiaryGrenadesSetsFire", true);
        }
    }

    /**
     * Server related config options
     */
    public static class Server {
        public final ForgeConfigSpec.DoubleValue heGrenadeExplosionSoundDistance;
        public final ForgeConfigSpec.DoubleValue smokeGrenadeExplosionSoundDistance;
        public final ForgeConfigSpec.DoubleValue incendiaryGrenadeExplosionSoundDistance;
        public final ForgeConfigSpec.DoubleValue molotovExplosionSoundDistance;

        public Server(ForgeConfigSpec.Builder builder)
        {
            builder.push("sounds");{
            	this.heGrenadeExplosionSoundDistance = builder.comment("The maximum distance high explosive grenade explosions can be heard by players.").defineInRange("smokeGrenadeExplosionMaxDistance", 48, 0, Double.MAX_VALUE);
                this.smokeGrenadeExplosionSoundDistance = builder.comment("The maximum distance smoke grenade explosions can be heard by players.").defineInRange("smokeGrenadeExplosionMaxDistance", 48, 0, Double.MAX_VALUE);
                this.incendiaryGrenadeExplosionSoundDistance = builder.comment("The maximum distance incendiary grenade explosions can be heard by players.").defineInRange("incendiaryGrenadeExplosionMaxDistance", 48, 0, Double.MAX_VALUE);
                this.molotovExplosionSoundDistance = builder.comment("The maximum distance molotov explosions can be heard by players.").defineInRange("molotovExplosionMaxDistance", 48, 0, Double.MAX_VALUE);
            }builder.pop();
        }
    }

    /*static final ForgeConfigSpec clientSpec;
    public static final GrenadesConfig.Client CLIENT;*/

    static final ForgeConfigSpec commonSpec;
    public static final GrenadesConfig.Common COMMON;

    static final ForgeConfigSpec serverSpec;
    public static final GrenadesConfig.Server SERVER;

    static {
        /*final Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(GrenadesConfig.Client::new);
        clientSpec = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();*/

        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();

        final Pair<Server, ForgeConfigSpec> serverSpecPair = new ForgeConfigSpec.Builder().configure(Server::new);
        serverSpec = serverSpecPair.getRight();
        SERVER = serverSpecPair.getLeft();
    }

    public static void saveClientConfig()
    {
        //clientSpec.save();
    }
}
