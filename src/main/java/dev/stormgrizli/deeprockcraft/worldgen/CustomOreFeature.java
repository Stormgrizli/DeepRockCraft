package dev.stormgrizli.deeprockcraft.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class CustomOreFeature /*extends Feature<OreConfiguration> */{

//    public CustomOreFeature(Codec<OreConfiguration> codec) {
//        super(codec);
//    }
//
//    @Override
//    public boolean place(FeaturePlaceContext<OreConfiguration> context) {
//        RandomSource random = context.random();
//        BlockPos pos = context.origin();
//        LevelAccessor world = context.level();
//        ChunkGenerator generator = context.chunkGenerator();
//        OreConfiguration config = context.config();
//
//        int veinSize = config.size;
//        int successfulBlocks = 0;
//
//        for (int i = 0; i < veinSize; i++) {
//            BlockPos newPos = pos.offset(random.nextInt(16) - random.nextInt(16), random.nextInt(8) - random.nextInt(8), random.nextInt(16) - random.nextInt(16));
//
//            if (world.getBlockState(newPos).getBlock() == Blocks.STONE && isValidPlacement(world, newPos)) {
//                for (OreConfiguration.TargetBlockState target : config.targetStates) {
//                    if (target.target.test(world.getBlockState(newPos), random)) {
//                        world.setBlock(newPos, target.state, 2);
//                        successfulBlocks++;
//                        break;
//                    }
//                }
//            }
//        }
//
//        return successfulBlocks > 0;
//    }
//
//    private boolean isValidPlacement(LevelAccessor world, BlockPos pos) {
//        for (Direction direction : Direction.values()) {
//            if (world.getBlockState(pos.relative(direction)).isAir()) {
//                return true;
//            }
//        }
//        return false;
//    }
}
