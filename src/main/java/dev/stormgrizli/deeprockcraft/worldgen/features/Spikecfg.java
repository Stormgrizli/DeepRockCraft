package dev.stormgrizli.deeprockcraft.worldgen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public record Spikecfg(IntProvider xzRadius, CaveSurface crystal_direction, float glinted_cluster_chance) implements FeatureConfiguration {

    public static final Codec<Spikecfg> CODEC = RecordCodecBuilder.create(codec -> {
        return codec.group(IntProvider.CODEC.fieldOf("xz_radius").forGetter(config -> {
            return config.xzRadius;
        }), CaveSurface.CODEC.fieldOf("crystal_direction").forGetter(config -> {
            return config.crystal_direction;
        }), Codec.floatRange(0.0f, 1.0f).fieldOf("glinted_cluster_chance").forGetter(config -> {
            return config.glinted_cluster_chance;
        })).apply(codec, Spikecfg::new);
    });

}
