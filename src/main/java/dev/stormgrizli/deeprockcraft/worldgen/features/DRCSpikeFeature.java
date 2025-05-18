package dev.stormgrizli.deeprockcraft.worldgen.features;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import dev.stormgrizli.deeprockcraft.registries.DRCBlocks;
import dev.stormgrizli.deeprockcraft.worldgen.biome.DRCBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.DripstoneUtils;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Map;
import java.util.function.Supplier;

public class DRCSpikeFeature extends Feature<Spikecfg> {
    public DRCSpikeFeature(Codec<Spikecfg> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<Spikecfg> context) {
        WorldGenLevel world = context.level();
        BlockPos blockPos = context.origin();
        RandomSource random = context.random();
        Spikecfg config = context.config();
        HashSet<BlockPos> trigList = Sets.newHashSet();
        boolean flag = false;
        int radiusCheck = config.xzRadius().sample(random) + 1;
        final int randomChance = random.nextInt(4);
        final int stepHeight = radiusCheck + 14 + Mth.nextInt(random, 10, 14);
        if (world.isStateAtPosition(blockPos.relative(config.crystal_direction().getDirection().getOpposite()), DripstoneUtils::isEmptyOrWaterOrLava) && world.getBlockState(blockPos).is(BlockTags.BASE_STONE_OVERWORLD)) {
            if (this.placeSpike(world, blockPos, radiusCheck, stepHeight, randomChance, trigList, config.crystal_direction().getDirection(), random)) {
                flag = placeCrystals(world, config, trigList, flag);
            }
        }
        return flag;
    }


    public static final Map<ResourceKey<Biome>,BlockState> blockStateMap = Map.of(
            DRCBiomes.SALT_PITS, DRCBlocks.RED_SALT.get().defaultBlockState(),
            DRCBiomes.CRYSTALLINE_CAVERNS, DRCBlocks.CRYSTALLINE_STONE.get().defaultBlockState(),
            DRCBiomes.GLACIAL_STRATA, DRCBlocks.GLACIAL_STONE.get().defaultBlockState(),
            DRCBiomes.AZURE_WEALD, DRCBlocks.AZURE_STONE.get().defaultBlockState(),
            DRCBiomes.DENSE_BIOZONE, DRCBlocks.BIOZONE_STONE.get().defaultBlockState(),
            DRCBiomes.FUNGUS_BOGS, DRCBlocks.FUNGUS_STONE.get().defaultBlockState(),
            DRCBiomes.SANDBLASED_CORRIDORS, DRCBlocks.SAND_BLASED_STONE.get().defaultBlockState(),
            DRCBiomes.HOLLOW_BOUGH, DRCBlocks.HOLLOW_BOUGH_STONE.get().defaultBlockState(),
            DRCBiomes.MAGMA_CORE, DRCBlocks.DARK_MAGMA_CORE_BLOCK.get().defaultBlockState(),
            DRCBiomes.RADIOACTIVE_EXCLUSION_ZONE, DRCBlocks.RADIATED_STONE.get().defaultBlockState()
    );

    private boolean placeCrystals(WorldGenLevel world, Spikecfg config, HashSet<BlockPos> trigList, boolean flag) {
        for (BlockPos pos : trigList) {
            if (world.isStateAtPosition(pos, DripstoneUtils::isEmptyOrWaterOrLava)) {
                // Получаем ключ биома из текущей позиции
                ResourceKey<Biome> biomeKey = world.getBiome(pos).unwrapKey().orElse(null);

                // Ищем соответствующий блок в мапе
                BlockState state = biomeKey != null
                        ? blockStateMap.getOrDefault(biomeKey, Blocks.STONE.defaultBlockState())
                        : Blocks.STONE.defaultBlockState();

                this.setBlock(world, pos, state);
                flag = true;
            }
        }
        return flag;
    }

    public boolean placeSpike(LevelAccessor world, BlockPos blockPos, int startRadius, int height, int randomChance, HashSet<BlockPos> crystalPos, Direction direction, RandomSource random) {
        boolean flag = false;
        if (startRadius < 1) {
            return false;
        }
        for (int y = 0; y < height; y++) {
            int radius = startRadius - y / 2;
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos pos = new BlockPos(blockPos.getX() + x, blockPos.getY(), blockPos.getZ() + z);
                    if (x * x + z * z <= radius * radius) {
                        if (direction == Direction.DOWN) {
                            if (world.isStateAtPosition(pos.below(), DripstoneUtils::isEmptyOrWaterOrLava)) {
                                return placeSpike(world, blockPos.below(), startRadius / 2, height, randomChance, crystalPos, direction, random);
                            }
                        }
                        else if (direction == Direction.UP) {
                            BlockPos.MutableBlockPos mut = pos.mutable();
                            for (int i = 0; i < 10; i++) {
                                if (!world.isStateAtPosition(mut.above(), DripstoneUtils::isEmptyOrWaterOrLava)) break;
                                mut.move(Direction.UP);
                            }
                            pos = mut.immutable();

                            if (world.isStateAtPosition(pos.above(), DripstoneUtils::isEmptyOrWaterOrLava)) {
                                return false;
                            }
                        }
                        this.calciteBloom(world, pos.relative(direction), random, radius);
                        float delta = switch (randomChance) {
                            case 1 -> 11 * Mth.PI / 6;
                            case 2 -> Mth.PI / 6;
                            case 3 -> 7 * Mth.PI / 6;
                            case 0 -> 5 * Mth.PI / 6;
                            default -> throw new IllegalStateException("Unexpected value: " + randomChance);
                        };
                        float q = Mth.cos(delta) * y;
                        float k = Mth.sin(Mth.PI / 2) * y;
                        float l = Mth.sin(delta) * y;
                        float xx = direction == Direction.UP ? -q : q;
                        float yy = direction == Direction.UP ? -k : k;
                        float zz = direction == Direction.UP ? -l : l;
                        BlockPos trigPos = BlockPos.containing(pos.getX() + xx, pos.getY() + yy, pos.getZ() + zz);
                        if (world.isStateAtPosition(trigPos, DripstoneUtils::isEmptyOrWaterOrLava)) {
                            crystalPos.add(trigPos);
                            flag = true;
                        } else {
                            crystalPos.remove(trigPos);
                        }
                    }
                }
            }
        }
        return flag;
    }

    private boolean calciteBloom(LevelAccessor world, BlockPos blockPos, RandomSource random, int crystalRadius) {
        int radius = crystalRadius / 4;
        int height = ConstantInt.of(2).sample(random);
        boolean flag = false;
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                for (int y = -height; y <= height; y++) {
                    BlockPos pos = new BlockPos(blockPos.getX() + x, blockPos.getY() + y, blockPos.getZ() + z);
                    for (Direction direction : Direction.values()) {
                        if (world.getBlockState(pos).is(BlockTags.BASE_STONE_OVERWORLD) && world.isStateAtPosition(pos.relative(direction), DripstoneUtils::isEmptyOrWaterOrLava)) {
                            world.setBlock(pos, Blocks.CALCITE.defaultBlockState(), 2);
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

}
