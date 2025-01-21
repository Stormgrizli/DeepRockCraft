package dev.stormgrizli.deeprockcraft.worldgen.dimension;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.block.ModBlocks;
import dev.stormgrizli.deeprockcraft.worldgen.biome.DRGBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.world.level.levelgen.DensityFunctions;

import java.util.List;
import java.util.OptionalLong;

public class DRGDimension {
    public static final ResourceKey<Level> DRG_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, name("drgdimension"));

    public static final ResourceKey<NoiseGeneratorSettings> DRG_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, name("drgdimension"));

    public static final ResourceKey<DimensionType> DRG_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, name("drgdimension"));

    public static final ResourceKey<LevelStem> DRG_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, name("drgdimension"));

    private static ResourceLocation name(String name) {
        return new ResourceLocation(DeepRockCraftMod.MOD_ID, name);
    }


    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(DRG_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                true, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                512, // height
                512, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);
        context.register(DRG_LEVEL_STEM, new LevelStem(dimTypes.getOrThrow(DRG_DIM_TYPE),
                new NoiseBasedChunkGenerator(DRGBiomes.buildBiomeSource(biomeRegistry), noiseGenSettings.getOrThrow(DRG_NOISE_GEN))));
    }

    public static void bootstrapNoise(BootstapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> functions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noises = context.lookup(Registries.NOISE);
        DensityFunction densityfunction = NoiseRouterData.getFunction(functions, NoiseRouterData.SHIFT_X);
        DensityFunction densityfunction1 = NoiseRouterData.getFunction(functions, NoiseRouterData.SHIFT_Z);
        DensityFunction densityFunction2 = NoiseRouterData.getFunction(functions, NoiseRouterData.SPAGHETTI_2D);
        context.register(DRG_NOISE_GEN, new NoiseGeneratorSettings(
                NoiseSettings.create(0, 512, 2, 2),
                Blocks.STONE.defaultBlockState(),
                Blocks.AIR.defaultBlockState(),
                new NoiseRouter(
                        DensityFunctions.zero(), //barrier
                        DensityFunctions.zero(), //fluid level floodedness
                        DensityFunctions.zero(), //fluid level spread
                        DensityFunctions.zero(), //lava
                        DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, noises.getOrThrow(Noises.TEMPERATURE)), //temperature
                        DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25D, noises.getOrThrow(Noises.VEGETATION)), //vegetation
                        NoiseRouterData.getFunction(functions, NoiseRouterData.CONTINENTS), //continents
                        NoiseRouterData.getFunction(functions, NoiseRouterData.EROSION), //erosion
                        DensityFunctions.rangeChoice(
                                NoiseRouterData.getFunction(functions, NoiseRouterData.Y), 0.0D, 32.0D,
                                DensityFunctions.constant(2.0D),
                                DensityFunctions.constant(-2.0D)), //depth
                        NoiseRouterData.getFunction(functions, NoiseRouterData.RIDGES), //ridges
                        DensityFunctions.add(
                                DensityFunctions.mul(
                                        DensityFunctions.constant(1.5), // Общая интенсивность спагетти
                                        DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_3D_THICKNESS), 0.4, 0.6)
                                ),
                                DensityFunctions.mul(
                                        DensityFunctions.constant(0.8), // Дополнительная хаотичность
                                        DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_3D_RARITY), 2, 1)
                                )
                        ),//caves
                        DensityFunctions.mul(
                                DensityFunctions.constant(1.9),
                                        DensityFunctions.interpolated(
                                        DensityFunctions.blendDensity(
                                                DensityFunctions.add(
                                                        DensityFunctions.constant(2.5),
                                                        DensityFunctions.mul(
                                                                DensityFunctions.yClampedGradient(30, -20, 1.0D, 0.0D),
                                                                DensityFunctions.add(
                                                                        DensityFunctions.constant(-2.5D),
                                                                        DensityFunctions.add(
                                                                                DensityFunctions.constant(0.5D),
                                                                                DensityFunctions.mul(
                                                                                        DensityFunctions.yClampedGradient(500, 501, 1.0D, 0.0D),
                                                                                        DensityFunctions.add(
                                                                                                DensityFunctions.constant(-0.6F),
                                                                                                DensityFunctions.max(
                                                                                                        new DensityFunctions.Clamp(
                                                                                                                DensityFunctions.cacheOnce(
                                                                                                                DensityFunctions.mul(
                                                                                                                        DensityFunctions.add(
                                                                                                                                DensityFunctions.constant(-0.1D),
                                                                                                                                DensityFunctions.mul(
                                                                                                                                        DensityFunctions.constant(-0.3D),
                                                                                                                                        DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_ROUGHNESS_MODULATOR),10,10)
                                                                                                                                )
                                                                                                                        ),
                                                                                                                        DensityFunctions.add(
                                                                                                                                DensityFunctions.constant(-0.4D),
                                                                                                                                DensityFunctions.min( //abs
                                                                                                                                        DensityFunctions.constant(-5),
                                                                                                                                        DensityFunctions.add(
                                                                                                                                                DensityFunctions.constant(5),
                                                                                                                                                DensityFunctions.mul(
                                                                                                                                                        DensityFunctions.constant(-5),
                                                                                                                                                        DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_ROUGHNESS),1,1)
                                                                                                                                                )
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                ), 0, 1
                                                                                                        ),DensityFunctions.constant(0)
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        ).squeeze(), //final density
                DensityFunctions.zero(), //vein toggle DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_3D_2), 1, 1)
                DensityFunctions.zero(), //vein ridged DensityFunctions.mul(DensityFunctions.constant(-0.5F), DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_3D_2), 1, 1))
                DensityFunctions.zero() //vein gap
                ),
                SurfaceRules.sequence(
                        //bedrock floor
                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("minecraft:bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())),
                        //bedrock ceiling
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("minecraft:bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())),
                        //filler depthrock
                        SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(5), 0), SurfaceRules.state(Blocks.STONE.defaultBlockState())),
                        //sediment
                        SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(10), 0)), SurfaceRules.state(Blocks.STONE.defaultBlockState()))),
                        //mix coarse deepsoil into blood bog
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(DRGBiomes.SALT_PITS),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
                                        SurfaceRules.sequence(
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.noiseCondition(noises.getOrThrow(Noises.SOUL_SAND_LAYER).key(), 0.0D, 1.8D),
                                                        SurfaceRules.state(ModBlocks.RED_SALT.get().defaultBlockState())
                                                ),
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
                                                        SurfaceRules.state(ModBlocks.RED_SALT.get().defaultBlockState())
                                                )
                                        )
                                )
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(DRGBiomes.CRYSTALLINE_CAVERNS),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.yBlockCheck(VerticalAnchor.absolute(16), 0), // Y >= 16
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(17), 0)), // Y < 17
                                                        SurfaceRules.state(ModBlocks.CRYSTALLINE_STONE_SLAB.get().defaultBlockState()) // Применяем блок
                                                )
                                        ),
                                        SurfaceRules.state(ModBlocks.CRYSTALLINE_STONE.get().defaultBlockState()) // Остальное
                                )
                        ),
///fill ~15 ~15 ~15 ~-15 ~-15 ~-15 air replace deeprockcraft:crystalline_stone

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRGBiomes.SALT_PITS), SurfaceRules.state(ModBlocks.RED_SALT.get().defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRGBiomes.CRYSTALLINE_CAVERNS), SurfaceRules.state(ModBlocks.CRYSTALLINE_STONE.get().defaultBlockState()))
                ),
                List.of(), //spawn targets
                32,
                false,
                false,
                false,
                false
        ));
    }
}
/*
minecraft:overworld/caves/entrances
DensityFunctions.cacheOnce(
                                                                                                        DensityFunctions.min(
                                                                                                                DensityFunctions.add(
                                                                                                                        DensityFunctions.add(
                                                                                                                                DensityFunctions.constant(0.37),
                                                                                                                                DensityFunctions.noise(noises.getOrThrow(Noises.CAVE_ENTRANCE), 0.75, 0.5)
                                                                                                                        ),
                                                                                                                        DensityFunctions.yClampedGradient(-10, 30, 0.3, 0.0)
                                                                                                                ),
                                                                                                                DensityFunctions.add(
                                                                                                                        NoiseRouterData.getFunction(functions, NoiseRouterData.SPAGHETTI_ROUGHNESS_FUNCTION),
                                                                                                                        new DensityFunctions.Clamp(
                                                                                                                                DensityFunctions.add(
                                                                                                                                        DensityFunctions.max(
                                                                                                                                                DensityFunctions.weirdScaledSampler(
                                                                                                                                                        DensityFunctions.cacheOnce(
                                                                                                                                                                DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_3D_RARITY), 2, 1)
                                                                                                                                                        ),
                                                                                                                                                        noises.getOrThrow(Noises.SPAGHETTI_3D_1),
                                                                                                                                                        DensityFunctions.WeirdScaledSampler.RarityValueMapper.TYPE1
                                                                                                                                                ),
                                                                                                                                                DensityFunctions.weirdScaledSampler(
                                                                                                                                                        DensityFunctions.cacheOnce(
                                                                                                                                                                DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_3D_RARITY), 2, 1)
                                                                                                                                                        ),
                                                                                                                                                        noises.getOrThrow(Noises.SPAGHETTI_3D_2),
                                                                                                                                                        DensityFunctions.WeirdScaledSampler.RarityValueMapper.TYPE1
                                                                                                                                                )
                                                                                                                                        ),
                                                                                                                                        DensityFunctions.add(
                                                                                                                                                DensityFunctions.constant(-0.0765),
                                                                                                                                                DensityFunctions.mul(
                                                                                                                                                        DensityFunctions.constant(-0.011499999999999996),
                                                                                                                                                        DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_3D_THICKNESS), 1, 1)
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                ),-1.0, 1.0
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )*/
/*
minecraft:overworld/caves/spaghetti_roughness_function
                                                                                                DensityFunctions.cacheOnce(
                                                                                                        DensityFunctions.mul(
                                                                                                                DensityFunctions.add(
                                                                                                                        DensityFunctions.constant(-0.05D),
                                                                                                                        DensityFunctions.mul(
                                                                                                                                DensityFunctions.constant(-0.07D),
                                                                                                                                DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_ROUGHNESS_MODULATOR),5,5)
                                                                                                                        )
                                                                                                                ),
                                                                                                                DensityFunctions.add(
                                                                                                                        DensityFunctions.constant(-0.4D),
                                                                                                                        DensityFunctions.min( //abs
                                                                                                                                DensityFunctions.constant(0),
                                                                                                                                DensityFunctions.add(
                                                                                                                                        DensityFunctions.constant(0),
                                                                                                                                        DensityFunctions.mul(
                                                                                                                                                DensityFunctions.constant(-1),
                                                                                                                                                DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_ROUGHNESS),1,1)
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )
                                                                                                )

Noodle Function                                                                                                 DensityFunctions.interpolated(
                                                                                                                        DensityFunctions.noise(noises.getOrThrow(Noises.NOODLE), 1, 1)),
                                                                                                                -1000000,
                                                                                                                0,
                                                                                                                DensityFunctions.constant(64),
                                                                                                                DensityFunctions.add(
                                                                                                                        DensityFunctions.interpolated(
                                                                                                                                DensityFunctions.add(
                                                                                                                                        DensityFunctions.constant(-0.075),
                                                                                                                                        DensityFunctions.mul(
                                                                                                                                                DensityFunctions.constant(-0.025),
                                                                                                                                                DensityFunctions.noise(noises.getOrThrow(Noises.NOODLE_THICKNESS), 1, 1))
                                                                                                                                )
                                                                                                                        ),
                                                                                                                        DensityFunctions.mul(
                                                                                                                                DensityFunctions.constant(1.5),
                                                                                                                                DensityFunctions.max(
                                                                                                                                        DensityFunctions.min( //abs
                                                                                                                                                DensityFunctions.constant(0),
                                                                                                                                                DensityFunctions.add(
                                                                                                                                                        DensityFunctions.constant(0),
                                                                                                                                                        DensityFunctions.mul(
                                                                                                                                                                DensityFunctions.constant(-1),
                                                                                                                                                                DensityFunctions.interpolated(
                                                                                                                                                                        DensityFunctions.noise(noises.getOrThrow(Noises.NOODLE_RIDGE_A), 2.6666667, 2.6666667)
                                                                                                                                                                )
                                                                                                                                                        )
                                                                                                                                                )
                                                                                                                                        ),
                                                                                                                                        DensityFunctions.min( //abs
                                                                                                                                                DensityFunctions.constant(0),
                                                                                                                                                DensityFunctions.add(
                                                                                                                                                        DensityFunctions.constant(0),
                                                                                                                                                        DensityFunctions.mul(
                                                                                                                                                                DensityFunctions.constant(-1),
                                                                                                                                                                DensityFunctions.interpolated(
                                                                                                                                                                        DensityFunctions.noise(noises.getOrThrow(Noises.NOODLE_RIDGE_B), 2.6666667, 2.6666667)
                                                                                                                                                                )
                                                                                                                                                        )
                                                                                                                                                )
                                                                                                                                        )
                                                                                                                                )
                                                                                                                        )
                                                                                                                )
                                                                                                        )





 */
