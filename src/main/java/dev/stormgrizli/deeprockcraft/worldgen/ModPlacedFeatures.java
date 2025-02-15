package dev.stormgrizli.deeprockcraft.worldgen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
   public static final ResourceKey<PlacedFeature> NITRA_BLOCK_PLACED_KEY = registerKey("nitra_block");


   public static void bootstrap(BootstapContext<PlacedFeature> context) {
       HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

       register(context, NITRA_BLOCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_NITRA_BLOCK_KEY),
               ModOrePlacement.commonOrePlacement(18,
                       HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(320))));

   }
   private static ResourceKey<PlacedFeature> registerKey(String name) {
       return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DeepRockCraftMod.MOD_ID, name));
   }


   private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                List<PlacementModifier> modifiers) {
       context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
   }
}
