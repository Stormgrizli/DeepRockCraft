package dev.stormgrizli.deeprockcraft.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CrystalBlockEntity extends BlockEntity {
    private BlockState cachedBlockState;

    public CrystalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CRYSTAL_BE.get(), pos, state);
    }

    public BlockState getCachedBlockState() {
        if (cachedBlockState == null && level != null) {
            cachedBlockState = level.getBlockState(worldPosition.below());
        }
        return cachedBlockState;
    }

    public void updateCachedBlockState() {
        cachedBlockState = level.getBlockState(worldPosition.below());
    }
}