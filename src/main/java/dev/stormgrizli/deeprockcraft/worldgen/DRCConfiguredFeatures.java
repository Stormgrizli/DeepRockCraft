package dev.stormgrizli.deeprockcraft.worldgen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.registries.DRCBlocks;
import dev.stormgrizli.deeprockcraft.worldgen.biome.DRCBiomes;
import dev.stormgrizli.deeprockcraft.worldgen.features.Spikecfg;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class DRCConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRC_NITRA_BLOCK_KEY = registerKey("nitra_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYSTAL_SALT_PITS_FLOOR = registerKey("crystal_floor");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
      RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
      RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
      List<OreConfiguration.TargetBlockState> drcNitraOres = List.of(OreConfiguration.target(stoneReplaceable, DRCBlocks.NITRA_BLOCK.get().defaultBlockState()), OreConfiguration.target(deepslateReplaceables, DRCBlocks.NITRA_BLOCK.get().defaultBlockState()));register(context, DRC_NITRA_BLOCK_KEY, Feature.ORE, new OreConfiguration(drcNitraOres, 9));
        FeatureUtils.register(context, CRYSTAL_SALT_PITS_FLOOR, DRCFeature.CRYSTAL_SPIKE.get(), new Spikecfg(UniformInt.of(4, 7), CaveSurface.FLOOR, 0.25F));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DeepRockCraftMod.MOD_ID, name));
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
