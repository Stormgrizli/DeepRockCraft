package dev.stormgrizli.deeprockcraft.worldgen.biome.surface;

import dev.stormgrizli.deeprockcraft.registries.DRCBlocks;
import dev.stormgrizli.deeprockcraft.worldgen.biome.DRCBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class DRCSurfaceRules {
    private static final SurfaceRules.RuleSource RED_SALT = makeStateRule(DRCBlocks.RED_SALT.get());
    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, RED_SALT), RED_SALT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.SALT_PITS),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, RED_SALT)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SALT)),


                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
