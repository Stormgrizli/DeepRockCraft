package dev.stormgrizli.deeprockcraft.worldgen;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(modid = DeepRockCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModWorldGen {
//    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(ForgeRegistries.Keys.CONFIGURED_FEATURES, DeepRockCraftMod.MOD_ID);
//    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(ForgeRegistries.Keys.PLACED_FEATURES, DeepRockCraftMod.MOD_ID);
//
//    public static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_CUSTOM_ORE = CONFIGURED_FEATURES.register(
//            "custom_ore",
//            () -> new ConfiguredFeature<>(
//                    Feature.ORE,
//                    new OreConfiguration(
//                            List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.NITRA_BLOCK.get().defaultBlockState())),
//                            9
//                    )
//            )
//    );
//
//    public static final RegistryObject<PlacedFeature> PLACED_CUSTOM_ORE = PLACED_FEATURES.register(
//            "custom_ore",
//            () -> new PlacedFeature(
//                    Holder.direct(CONFIGURED_CUSTOM_ORE.get()),
//                    List.of(
//                            CountPlacement.of(10),
//                            InSquarePlacement.spread(),
//                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)),
//                            BiomeFilter.biome()
//                    )
//            )
//    );
//
//    public static void register(IEventBus eventBus) {
//        CONFIGURED_FEATURES.register(eventBus);
//        PLACED_FEATURES.register(eventBus);
//    }
}