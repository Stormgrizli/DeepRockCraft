package dev.stormgrizli.deeprockcraft.worldgen.biome;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.worldgen.DRCPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class DRCBiomes {
    public static final ResourceKey<Biome> SALT_PITS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DeepRockCraftMod.MOD_ID, "salt_pits"));
    public static final ResourceKey<Biome> CRYSTALLINE_CAVERNS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DeepRockCraftMod.MOD_ID, "crystalline_caverns"));
    public static final ResourceKey<Biome> AZURE_WEALD = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DeepRockCraftMod.MOD_ID, "azure_weald"));
    public static final ResourceKey<Biome> MAGMA_CORE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DeepRockCraftMod.MOD_ID, "magma_core"));
    public static final ResourceKey<Biome> SANDBLASED_CORRIDORS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DeepRockCraftMod.MOD_ID, "sandblased_corridors"));
    public static final ResourceKey<Biome> RADIOACTIVE_EXCLUSION_ZONE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DeepRockCraftMod.MOD_ID, "radioactive_exclusion_zone"));
    public static final ResourceKey<Biome> FUNGUS_BOGS = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DeepRockCraftMod.MOD_ID, "fungus_bogs"));
    public static final ResourceKey<Biome> HOLLOW_BOUGH = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DeepRockCraftMod.MOD_ID, "hollow_bough"));
    public static final ResourceKey<Biome> DENSE_BIOZONE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DeepRockCraftMod.MOD_ID, "dense_biozone"));
    public static final ResourceKey<Biome> GLACIAL_STRATA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(DeepRockCraftMod.MOD_ID, "glacial_strata"));

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> featureGetter = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carverGetter = context.lookup(Registries.CONFIGURED_CARVER);
        context.register(SALT_PITS, new Biome.BiomeBuilder()
                .generationSettings(addOresAndCaves((new BiomeGenerationSettings.Builder(featureGetter, carverGetter)))
                        .build())
                .mobSpawnSettings(addRotspawn(addCaveMobs(new MobSpawnSettings.Builder()))
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.8F)
                    .specialEffects(generateColors(new BiomeSpecialEffects.Builder(), 12083553, 10108730)
                    .build())
                .build());

        context.register(CRYSTALLINE_CAVERNS, new Biome.BiomeBuilder()
                .generationSettings(addOresAndCaves((new BiomeGenerationSettings.Builder(featureGetter, carverGetter)))
                        .build())
                .mobSpawnSettings(addRotspawn(addCaveMobs(new MobSpawnSettings.Builder()))
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.8F)
                    .specialEffects(generateColors(new BiomeSpecialEffects.Builder(), 5680072, 5728658)
                    .build())
                .build());
        context.register(AZURE_WEALD, new Biome.BiomeBuilder()
                .generationSettings(addOresAndCaves((new BiomeGenerationSettings.Builder(featureGetter, carverGetter)))
                        .build())
                .mobSpawnSettings(addRotspawn(addCaveMobs(new MobSpawnSettings.Builder()))
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.8F)
                    .specialEffects(generateColors(new BiomeSpecialEffects.Builder(), 43248, 43248)
                    .build())
                .build());
        context.register(FUNGUS_BOGS, new Biome.BiomeBuilder()
                .generationSettings(addOresAndCaves((new BiomeGenerationSettings.Builder(featureGetter, carverGetter)))
                        .build())
                .mobSpawnSettings(addRotspawn(addCaveMobs(new MobSpawnSettings.Builder()))
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.8F)
                    .specialEffects(generateColors(new BiomeSpecialEffects.Builder(), 2027809, 2027809)
                    .build())
                .build());
        context.register(MAGMA_CORE, new Biome.BiomeBuilder()
                .generationSettings(addOresAndCaves((new BiomeGenerationSettings.Builder(featureGetter, carverGetter)))
                        .build())
                .mobSpawnSettings(addRotspawn(addCaveMobs(new MobSpawnSettings.Builder()))
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.8F)
                    .specialEffects(generateColors(new BiomeSpecialEffects.Builder(), 9242375, 5852754)
                    .build())
                .build());
        context.register(RADIOACTIVE_EXCLUSION_ZONE, new Biome.BiomeBuilder()
                .generationSettings(addOresAndCaves((new BiomeGenerationSettings.Builder(featureGetter, carverGetter)))
                        .build())
                .mobSpawnSettings(addRotspawn(addCaveMobs(new MobSpawnSettings.Builder()))
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.8F)
                    .specialEffects(generateColors(new BiomeSpecialEffects.Builder(), 43011, 6909032)
                    .build())
                .build());
        context.register(SANDBLASED_CORRIDORS, new Biome.BiomeBuilder()
                .generationSettings(addOresAndCaves((new BiomeGenerationSettings.Builder(featureGetter, carverGetter)))
                        .build())
                .mobSpawnSettings(addRotspawn(addCaveMobs(new MobSpawnSettings.Builder()))
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.8F)
                    .specialEffects(generateColors(new BiomeSpecialEffects.Builder(), 16114544, 16114544)
                    .build())
                .build());
        context.register(GLACIAL_STRATA, new Biome.BiomeBuilder()
                .generationSettings(addOresAndCaves((new BiomeGenerationSettings.Builder(featureGetter, carverGetter)))
                        .build())
                .mobSpawnSettings(addRotspawn(addCaveMobs(new MobSpawnSettings.Builder()))
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.8F)
                    .specialEffects(generateColors(new BiomeSpecialEffects.Builder(), 42941, 42941)
                    .build())
                .build());
        context.register(DENSE_BIOZONE, new Biome.BiomeBuilder()
                .generationSettings(addOresAndCaves((new BiomeGenerationSettings.Builder(featureGetter, carverGetter)))
                        .build())
                .mobSpawnSettings(addRotspawn(addCaveMobs(new MobSpawnSettings.Builder()))
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.8F)
                    .specialEffects(generateColors(new BiomeSpecialEffects.Builder(), 7368816, 7684671)
                    .build())
                .build());
        context.register(HOLLOW_BOUGH, new Biome.BiomeBuilder()
                .generationSettings(addOresAndCaves((new BiomeGenerationSettings.Builder(featureGetter, carverGetter)))
                        .build())
                .mobSpawnSettings(addRotspawn(addCaveMobs(new MobSpawnSettings.Builder()))
                        .build())
                .hasPrecipitation(false)
                .downfall(0.0F)
                .temperature(0.8F)
                    .specialEffects(generateColors(new BiomeSpecialEffects.Builder(), 4494999, 5916211)
                    .build())
                .build());
    }
    private static BiomeSpecialEffects.Builder generateColors(BiomeSpecialEffects.Builder builder, int skyFog, int grass) {
        return builder
                .skyColor(1186057)
                .fogColor(skyFog)
                .waterColor(342306)
                .waterFogColor(332810)
                .grassColorOverride(grass)
                .foliageColorOverride(grass);
    }
    private static MobSpawnSettings.Builder addCaveMobs(MobSpawnSettings.Builder builder) {
        return builder;
    }


    private static MobSpawnSettings.Builder addRotspawn(MobSpawnSettings.Builder builder) {
        return builder;
    }
    private static BiomeGenerationSettings.Builder addOresAndCaves(BiomeGenerationSettings.Builder builder) {
        return builder
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DRCPlacedFeatures.NITRA_BLOCK_PLACED_KEY)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DRCPlacedFeatures.SPIKE_CRYSTAL);
    }
//    private static BiomeSpecialEffects.Builder addMusicAndAmbience(BiomeSpecialEffects.Builder builder) {
//        return addMusicAndAmbience(builder);
//    }

    public static BiomeSource buildBiomeSource(HolderGetter<Biome> biomes) {
        return MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(ImmutableList.of(
                Pair.of(Climate.parameters(0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(SALT_PITS)),
                Pair.of(Climate.parameters(0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(CRYSTALLINE_CAVERNS)),
                Pair.of(Climate.parameters(0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(GLACIAL_STRATA)),
                Pair.of(Climate.parameters(0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(AZURE_WEALD)),
                Pair.of(Climate.parameters(-0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(DENSE_BIOZONE)),
                Pair.of(Climate.parameters(-0.35F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(FUNGUS_BOGS)),
                Pair.of(Climate.parameters(-0.49F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(SANDBLASED_CORRIDORS)),
                Pair.of(Climate.parameters(-0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(HOLLOW_BOUGH)),
                Pair.of(Climate.parameters(0.5F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F), biomes.getOrThrow(MAGMA_CORE)),
                Pair.of(Climate.parameters(-0.5F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F), biomes.getOrThrow(RADIOACTIVE_EXCLUSION_ZONE))
        )));
    }
}
