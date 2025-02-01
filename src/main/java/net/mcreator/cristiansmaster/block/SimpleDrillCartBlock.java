
package net.mcreator.cristiansmaster.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.procedures.DrillCartOnTickUpdateProcedure;
import net.mcreator.cristiansmaster.procedures.DrillCartBlockAddedProcedure;
import net.mcreator.cristiansmaster.block.entity.SimpleDrillCartBlockEntity;

public class SimpleDrillCartBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public SimpleDrillCartBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(6, 6, 14, 10, 10, 16), box(4, 4, 12, 12, 12, 14), box(2, 2, 10, 14, 14, 12), box(0, 0, 8, 16, 16, 10), box(0, 2, 0, 16, 12, 8), box(1, 0, 2, 3, 2, 6), box(13, 0, 2, 15, 2, 6));
			case NORTH -> Shapes.or(box(6, 6, 0, 10, 10, 2), box(4, 4, 2, 12, 12, 4), box(2, 2, 4, 14, 14, 6), box(0, 0, 6, 16, 16, 8), box(0, 2, 8, 16, 12, 16), box(13, 0, 10, 15, 2, 14), box(1, 0, 10, 3, 2, 14));
			case EAST -> Shapes.or(box(14, 6, 6, 16, 10, 10), box(12, 4, 4, 14, 12, 12), box(10, 2, 2, 12, 14, 14), box(8, 0, 0, 10, 16, 16), box(0, 2, 0, 8, 12, 16), box(2, 0, 13, 6, 2, 15), box(2, 0, 1, 6, 2, 3));
			case WEST -> Shapes.or(box(0, 6, 6, 2, 10, 10), box(2, 4, 4, 4, 12, 12), box(4, 2, 2, 6, 14, 14), box(6, 0, 0, 8, 16, 16), box(8, 2, 0, 16, 12, 16), box(10, 0, 1, 14, 2, 3), box(10, 0, 13, 14, 2, 15));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 20);
		DrillCartBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		DrillCartOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		world.scheduleTick(pos, this, 20);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new SimpleDrillCartBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof SimpleDrillCartBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}
}
