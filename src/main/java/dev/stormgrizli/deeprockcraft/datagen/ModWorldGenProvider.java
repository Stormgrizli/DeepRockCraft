package dev.stormgrizli.deeprockcraft.datagen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.worldgen.ModBiomeModifiers;
import dev.stormgrizli.deeprockcraft.worldgen.ModConfiguredFeatures;
import dev.stormgrizli.deeprockcraft.worldgen.ModPlacedFeatures;
import dev.stormgrizli.deeprockcraft.worldgen.biome.DRGBiomes;
import dev.stormgrizli.deeprockcraft.worldgen.dimension.DRGDimension;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, DRGDimension::bootstrapType)
            .add(Registries.LEVEL_STEM, DRGDimension::bootstrapStem)
            .add(Registries.NOISE_SETTINGS, DRGDimension::bootstrapNoise)
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.BIOME, DRGBiomes::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DeepRockCraftMod.MOD_ID));
    }
}
