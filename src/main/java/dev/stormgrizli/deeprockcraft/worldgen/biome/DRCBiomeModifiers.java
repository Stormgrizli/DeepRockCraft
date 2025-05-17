package dev.stormgrizli.deeprockcraft.worldgen.biome;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.worldgen.DRCFeature;
import dev.stormgrizli.deeprockcraft.worldgen.DRCPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class DRCBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_NITRA_BLOCK_ORE = register("add_nitra_block_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> bootstapContext) {
        var placedFeatures = bootstapContext.lookup(Registries.PLACED_FEATURE);
        var biomes = bootstapContext.lookup(Registries.BIOME);

        bootstapContext.register(ADD_NITRA_BLOCK_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(DRCPlacedFeatures.NITRA_BLOCK_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

    }

    @NotNull
    private static HolderSet.Direct<Biome> getBiome(BootstapContext<BiomeModifier> bootstapContext, ResourceKey<Biome> biome) {
        return HolderSet.direct(bootstapContext.lookup(Registries.BIOME).getOrThrow(biome));
    }

    @NotNull
    private static HolderSet.Direct<PlacedFeature> getPlacedFeature(BootstapContext<BiomeModifier> context, ResourceKey<PlacedFeature> placedFeature) {
        return HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(placedFeature));
    }

    @NotNull
    private static ResourceKey<BiomeModifier> register(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, DeepRockCraftMod.id(name));
    }
}
