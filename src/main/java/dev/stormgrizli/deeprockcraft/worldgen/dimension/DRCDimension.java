package dev.stormgrizli.deeprockcraft.worldgen.dimension;

import dev.stormgrizli.deeprockcraft.DeepRockCraftMod;
import dev.stormgrizli.deeprockcraft.registries.DRCBlocks;
import dev.stormgrizli.deeprockcraft.worldgen.biome.DRCBiomes;
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

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

public class DRCDimension {
    public static final ResourceKey<Level> DRG_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, name("drgdimension"));

    public static final ResourceKey<NoiseGeneratorSettings> DRG_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, name("drgdimension"));

    public static final ResourceKey<DimensionType> DRG_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, name("drgdimension"));

    public static final ResourceKey<LevelStem> DRG_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, name("drgdimension"));

    private static ResourceLocation name(String name) {
        return new ResourceLocation(DeepRockCraftMod.MOD_ID, name);
    }


    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(DRG_DIM_TYPE, new DimensionType(
                OptionalLong.of(0), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                true, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                false, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                320, // height
                320, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.NETHER_EFFECTS, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);
        context.register(DRG_LEVEL_STEM, new LevelStem(dimTypes.getOrThrow(DRG_DIM_TYPE),
                new NoiseBasedChunkGenerator(DRCBiomes.buildBiomeSource(biomeRegistry), noiseGenSettings.getOrThrow(DRG_NOISE_GEN))));
    }


    public static final SurfaceRules.RuleSource customNoiseLayer = SurfaceRules.sequence(
            SurfaceRules.ifTrue(
                    SurfaceRules.isBiome(DRCBiomes.CRYSTALLINE_CAVERNS),
                    SurfaceRules.state(DRCBlocks.WHITE_CRYSTALLINE_STONE.get().defaultBlockState())
            ),
            SurfaceRules.ifTrue(
                    SurfaceRules.isBiome(DRCBiomes.SALT_PITS),
                    SurfaceRules.state(DRCBlocks.WINE_SALT.get().defaultBlockState())
            ),
            SurfaceRules.ifTrue(
                    SurfaceRules.isBiome(DRCBiomes.SANDBLASED_CORRIDORS),
                    SurfaceRules.state(DRCBlocks.YL_SAND_BLASED_STONE.get().defaultBlockState())
            )
    );

    public static final SurfaceRules.RuleSource additionCustomNoiseLayer = SurfaceRules.sequence(
            SurfaceRules.ifTrue(
                    SurfaceRules.isBiome(DRCBiomes.CRYSTALLINE_CAVERNS),
                    SurfaceRules.state(DRCBlocks.CRYSTALLINE_STONE.get().defaultBlockState())
            ),
            SurfaceRules.ifTrue(
                    SurfaceRules.isBiome(DRCBiomes.SALT_PITS),
                    SurfaceRules.state(DRCBlocks.ROSE_SALT.get().defaultBlockState())
            )
    );

    public static List<Integer> generateHeights(){
        return generateHeights(100);
    }

    public static List<Integer> generateHeights(int count){
        List<Integer> heights = new ArrayList<>();
        heights.add(5);
        int botBound = 315/count-2;
        int topBound = 315/count+2;
        while (heights.get(heights.size()-1)<315){
            int lastMember = heights.get(heights.size()-1);
            heights.add(lastMember + botBound + (int)(Math.random()*topBound));
        }
        return heights;
    }

    public static SurfaceRules.RuleSource layers(BootstapContext<NoiseGeneratorSettings> context, List<Integer> heights){
        HolderGetter<NormalNoise.NoiseParameters> noises = context.lookup(Registries.NOISE);
        List<SurfaceRules.RuleSource> l = new ArrayList<>();
        for (int i : heights){
            l.add(
                    SurfaceRules.sequence(
                            SurfaceRules.ifTrue(
                                    SurfaceRules.yBlockCheck(VerticalAnchor.absolute(i), 0),
                                    SurfaceRules.ifTrue(
                                            SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(i+1), 0)),
                                            SurfaceRules.ifTrue(
                                                    SurfaceRules.noiseCondition(noises.getOrThrow(Noises.BADLANDS_SURFACE).key(), -0.3D, 0.1D),
                                                    customNoiseLayer
                                            )
                                    )
                            ),
                            SurfaceRules.ifTrue(
                                    SurfaceRules.yBlockCheck(VerticalAnchor.absolute(i+1), 0),
                                    SurfaceRules.ifTrue(
                                            SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(i+2), 0)),
                                            SurfaceRules.ifTrue(
                                                    SurfaceRules.noiseCondition(noises.getOrThrow(Noises.CALCITE).key(), -0.3D, 0.6D),
                                                    customNoiseLayer
                                            )
                                    )
                            )
                    )
            );
            if (heights.get(heights.size()-1) != i && heights.get(heights.indexOf(i)+1)-i > 6 && Math.random() > 0.5F) {
                int diff = heights.get(heights.indexOf(i)+1)-i;
                l.add(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.yBlockCheck(VerticalAnchor.absolute(i - 3 + Math.round((float)(diff/2))), 0),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(i + 5 + Math.round((float)(diff/2))), 0)),
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.noiseCondition(noises.getOrThrow(Noises.CALCITE).key(), -0.3D, 0.1D),
                                                        additionCustomNoiseLayer
                                                )
                                        )
                                )
                );
            }
        }
        if (heights.isEmpty()) {
            throw new IllegalArgumentException("Need at least 1 heights layers");
        } else {
            return new SurfaceRules.SequenceRuleSource(l);
        }
    }


    public static void bootstrapNoise(BootstapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> functions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noises = context.lookup(Registries.NOISE);
        DensityFunction densityfunction = NoiseRouterData.getFunction(functions, NoiseRouterData.SHIFT_X);
        DensityFunction densityfunction1 = NoiseRouterData.getFunction(functions, NoiseRouterData.SHIFT_Z);
        context.register(DRG_NOISE_GEN, new NoiseGeneratorSettings(
                NoiseSettings.create(0, 320, 1, 1),
                Blocks.STONE.defaultBlockState(),
                Blocks.AIR.defaultBlockState(),
                new NoiseRouter(
                        DensityFunctions.zero(), //barrier
                        DensityFunctions.zero(), //fluid level floodedness
                        DensityFunctions.zero(), //fluid level spread
                        DensityFunctions.yClampedGradient(6, 0, 1.0D, 0.0D), //lava
                        DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 1.0D, noises.getOrThrow(Noises.TEMPERATURE)), //temperature
                        DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 1.0D, noises.getOrThrow(Noises.VEGETATION)), //vegetation
                        NoiseRouterData.getFunction(functions, NoiseRouterData.CONTINENTS), //continents
                        NoiseRouterData.getFunction(functions, NoiseRouterData.EROSION), //erosion
                        DensityFunctions.rangeChoice(
                                NoiseRouterData.getFunction(functions, NoiseRouterData.Y), 0.0D, 96.0D,
                                DensityFunctions.constant(2.0D),
                                DensityFunctions.constant(-2.0D)), //depth
                        NoiseRouterData.getFunction(functions, NoiseRouterData.RIDGES), //ridges
                        DensityFunctions.add(
                                DensityFunctions.mul(
                                        DensityFunctions.constant(1.5),
                                        DensityFunctions.noise(noises.getOrThrow(Noises.SPAGHETTI_3D_THICKNESS), 0.4, 0.6)
                                ),
                                DensityFunctions.mul(
                                        DensityFunctions.constant(0.8),
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
                                                                DensityFunctions.yClampedGradient(6, -20, 1.0D, 0.0D),
                                                                DensityFunctions.add(
                                                                        DensityFunctions.constant(-2.5D),
                                                                        DensityFunctions.add(
                                                                                DensityFunctions.constant(0.5D),
                                                                                DensityFunctions.mul(
                                                                                        DensityFunctions.yClampedGradient(315, 320, 1.0D, 0.0D),
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
                        //bedrock
                        SurfaceRules.ifTrue(SurfaceRules.verticalGradient("minecraft:bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("minecraft:bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())),

                        layers(context,generateHeights(50)),
                        SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(DRCBiomes.MAGMA_CORE),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.noiseCondition(noises.getOrThrow(Noises.NETHERRACK).key(), 0.4D, 1D),
                                                        SurfaceRules.state(Blocks.MAGMA_BLOCK.defaultBlockState())
                                                )
                                )
                        ),

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.SALT_PITS), SurfaceRules.state(DRCBlocks.RED_SALT.get().defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.CRYSTALLINE_CAVERNS), SurfaceRules.state(DRCBlocks.CRYSTALLINE_STONE.get().defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.GLACIAL_STRATA), SurfaceRules.state(DRCBlocks.GLACIAL_STONE.get().defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.AZURE_WEALD), SurfaceRules.state(DRCBlocks.AZURE_STONE.get().defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.DENSE_BIOZONE), SurfaceRules.state(DRCBlocks.BIOZONE_STONE.get().defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.FUNGUS_BOGS), SurfaceRules.state(DRCBlocks.FUNGUS_STONE.get().defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.SANDBLASED_CORRIDORS), SurfaceRules.state(DRCBlocks.SAND_BLASED_STONE.get().defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.HOLLOW_BOUGH), SurfaceRules.state(DRCBlocks.HOLLOW_BOUGH_STONE.get().defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.MAGMA_CORE), SurfaceRules.state(DRCBlocks.DARK_MAGMA_CORE_BLOCK.get().defaultBlockState())),
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(DRCBiomes.RADIOACTIVE_EXCLUSION_ZONE), SurfaceRules.state(DRCBlocks.RADIATED_STONE.get().defaultBlockState()))

                ),
                List.of(), //spawn targets
                -64,
                false,
                false,
                false,
                false
        ));
    }
}
//fill ~15 ~15 ~15 ~-15 ~-15 ~-15 air replace deeprockcraft:crystalline_stone
//fill ~15 ~15 ~15 ~-15 ~-15 ~-15 air replace deeprockcraft:red_salt

