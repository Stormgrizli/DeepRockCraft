package dev.stormgrizli.deeprockcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class NitraBlock extends Block {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;

    public NitraBlock(Properties copy) {
        super(copy);
        this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false).setValue(SOUTH, false).setValue(EAST, false).setValue(WEST, false).setValue(UP, false).setValue(DOWN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, SOUTH, EAST, WEST, UP, DOWN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();

        return this.defaultBlockState()
                .setValue(NORTH, isAir(world, pos.relative(Direction.NORTH)))
                .setValue(SOUTH, isAir(world, pos.relative(Direction.SOUTH)))
                .setValue(EAST, isAir(world, pos.relative(Direction.EAST)))
                .setValue(WEST, isAir(world, pos.relative(Direction.WEST)))
                .setValue(UP, isAir(world, pos.relative(Direction.UP)))
                .setValue(DOWN, isAir(world, pos.relative(Direction.DOWN)));
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        pLevel.setBlock(pPos, pState
                .setValue(NORTH, isAir(pLevel, pPos.relative(Direction.NORTH)))
                .setValue(SOUTH, isAir(pLevel, pPos.relative(Direction.SOUTH)))
                .setValue(EAST, isAir(pLevel, pPos.relative(Direction.EAST)))
                .setValue(WEST, isAir(pLevel, pPos.relative(Direction.WEST)))
                .setValue(UP, isAir(pLevel, pPos.relative(Direction.UP)))
                .setValue(DOWN, isAir(pLevel, pPos.relative(Direction.DOWN))), 2);
    }

    private boolean isAir(BlockGetter world, BlockPos pos) {
        return world.getBlockState(pos).isAir();
    }
}
