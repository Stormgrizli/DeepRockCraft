package dev.stormgrizli.deeprockcraft.datagen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.worldgen.DRCConfiguredFeatures;
import dev.stormgrizli.deeprockcraft.worldgen.DRCPlacedFeatures;
import dev.stormgrizli.deeprockcraft.worldgen.biome.DRCBiomeModifiers;
import dev.stormgrizli.deeprockcraft.worldgen.biome.DRCBiomes;
import dev.stormgrizli.deeprockcraft.worldgen.dimension.DRCDimension;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DRCWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, DRCDimension::bootstrapType)
            .add(Registries.LEVEL_STEM, DRCDimension::bootstrapStem)
            .add(Registries.NOISE_SETTINGS, DRCDimension::bootstrapNoise)
            .add(Registries.CONFIGURED_FEATURE, DRCConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, DRCPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, DRCBiomeModifiers::bootstrap)
            .add(Registries.BIOME, DRCBiomes::bootstrap);

    public DRCWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DeepRockCraftMod.MOD_ID));
    }
}
