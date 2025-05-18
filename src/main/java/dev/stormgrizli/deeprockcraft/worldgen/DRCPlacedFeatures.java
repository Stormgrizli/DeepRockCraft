package dev.stormgrizli.deeprockcraft.worldgen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class DRCPlacedFeatures {

    public static void init() { }

   public static final ResourceKey<PlacedFeature> NITRA_BLOCK_PLACED_KEY = registerPlacedFeature("nitra_block");
   public static final ResourceKey<PlacedFeature> SPIKE_CRYSTAL = registerPlacedFeature("spike_crystal");


   public static void bootstrap(BootstapContext<PlacedFeature> context) {
       HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

       register(context,
               NITRA_BLOCK_PLACED_KEY,
               configuredFeatures.getOrThrow(DRCConfiguredFeatures.DRC_NITRA_BLOCK_KEY),
               DRCOrePlacement.commonOrePlacement(18, HeightRangePlacement.uniform(VerticalAnchor.absolute(0),
                       VerticalAnchor.absolute(320))));
       register(context,
               SPIKE_CRYSTAL,
               configuredFeatures.getOrThrow(DRCConfiguredFeatures.CRYSTAL_SPIKE_FLOOR),
               List.of(CountPlacement.of(UniformInt.of(32, 256)),
               InSquarePlacement.spread(),
               PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
               BiomeFilter.biome()));
   }

   public static ResourceKey<PlacedFeature> registerPlacedFeature(String id) {
        return ResourceKey.create(Registries.PLACED_FEATURE, DeepRockCraftMod.id(id));
    }

   private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                List<PlacementModifier> modifiers) {
       context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
   }
}
