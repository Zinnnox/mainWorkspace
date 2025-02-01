package net.mcreator.cristiansmaster.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SimpleCargoEastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		BlockState dropBlock = Blocks.AIR.defaultBlockState();
		double dropBlockMaxSlots = 0;
		double cargoCartSlot = 0;
		double testSlot = 0;
		double dumpBlockSlot = 0;
		double cargoCartMaxSlots = 0;
		double emptySlots = 0;
		dropBlock = Blocks.BARREL.defaultBlockState();
		cargoCartMaxSlots = 27;
		dropBlockMaxSlots = 27;
		emptySlots = 0;
		testSlot = 0;
		for (int index0 = 0; index0 < (int) cargoCartMaxSlots; index0++) {
			if (new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).getCount();
					}
					return 0;
				}
			}.getAmount(world, BlockPos.containing(x, y, z), (int) testSlot) == 0) {
				emptySlots = emptySlots + 1;
			}
			testSlot = testSlot + 1;
		}
		if (emptySlots == 0) {
			if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.EAST && world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
				world.setBlock(BlockPos.containing(x + 1, y, z), dropBlock, 3);
				cargoCartSlot = 0;
				dumpBlockSlot = 0;
				for (int index1 = 0; index1 < (int) cargoCartMaxSlots; index1++) {
					for (int index2 = 0; index2 < (int) dropBlockMaxSlots; index2++) {
						if (new Object() {
							public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).getCount();
								}
								return 0;
							}
						}.getAmount(world, BlockPos.containing(x + 1, y, z), (int) dumpBlockSlot) == 0) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x + 1, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = (new Object() {
									public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
										if (world instanceof ILevelExtension _ext) {
											IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
											if (_itemHandler != null)
												return _itemHandler.getStackInSlot(slotid).copy();
										}
										return ItemStack.EMPTY;
									}
								}.getItemStack(world, BlockPos.containing(x, y, z), (int) cargoCartSlot)).copy();
								_setstack.setCount(new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										if (world instanceof ILevelExtension _ext) {
											IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
											if (_itemHandler != null)
												return _itemHandler.getStackInSlot(slotid).getCount();
										}
										return 0;
									}
								}.getAmount(world, BlockPos.containing(x, y, z), (int) cargoCartSlot));
								_itemHandlerModifiable.setStackInSlot((int) dumpBlockSlot, _setstack);
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = (int) cargoCartSlot;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink(new Object() {
									public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
										if (world instanceof ILevelExtension _ext) {
											IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
											if (_itemHandler != null)
												return _itemHandler.getStackInSlot(slotid).getCount();
										}
										return 0;
									}
								}.getAmount(world, BlockPos.containing(x, y, z), (int) cargoCartSlot));
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
						}
						dumpBlockSlot = dumpBlockSlot + 1;
					}
					dumpBlockSlot = 0;
					cargoCartSlot = cargoCartSlot + 1;
				}
			}
		}
	}
}
