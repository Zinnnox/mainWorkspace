package net.mcreator.cristiansmaster.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.cristiansmaster.init.CristianSMasterModBlocks;

public class SimpleDrillSouthProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		boolean move = false;
		String cantBreak = "";
		String dirt = "";
		String fuelCoal = "";
		double fuelCartMaxSlots = 0;
		double outputSlot = 0;
		double drillCartMaxSlots = 0;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		double inputSlot = 0;
		double cargoCartMaxSlots = 0;
		BlockState cargo_cart = Blocks.AIR.defaultBlockState();
		BlockState fuel_cart = Blocks.AIR.defaultBlockState();
		cantBreak = "digging_machine:cant_break";
		fuelCoal = "digging_machine:fuel/coal";
		dirt = "digging_machine:dirt";
		fuel_cart = CristianSMasterModBlocks.FUEL_CART.get().defaultBlockState();
		cargo_cart = CristianSMasterModBlocks.CARGO_CART.get().defaultBlockState();
		drillCartMaxSlots = 9;
		fuelCartMaxSlots = 27;
		cargoCartMaxSlots = 27;
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.SOUTH) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "Fuel") > 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("Fuel", ((new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "Fuel")) - 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if ((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == cargo_cart.getBlock()) {
					outputSlot = 0;
					inputSlot = 0;
					for (int index0 = 0; index0 < (int) cargoCartMaxSlots; index0++) {
						for (int index1 = 0; index1 < (int) drillCartMaxSlots; index1++) {
							if (new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).getCount();
									}
									return 0;
								}
							}.getAmount(world, BlockPos.containing(x, y, z - 2), (int) inputSlot) == 0 || new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).getCount();
									}
									return 0;
								}
							}.getAmount(world, BlockPos.containing(x, y, z), (int) outputSlot) + new Object() {
								public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).getCount();
									}
									return 0;
								}
							}.getAmount(world, BlockPos.containing(x, y, z - 2), (int) inputSlot) <= 64 && (new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).copy();
									}
									return ItemStack.EMPTY;
								}
							}.getItemStack(world, BlockPos.containing(x, y, z), (int) outputSlot)).getItem() == (new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									if (world instanceof ILevelExtension _ext) {
										IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(slotid).copy();
									}
									return ItemStack.EMPTY;
								}
							}.getItemStack(world, BlockPos.containing(x, y, z - 2), (int) inputSlot)).getItem()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z - 2), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = (new Object() {
										public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
											if (world instanceof ILevelExtension _ext) {
												IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
												if (_itemHandler != null)
													return _itemHandler.getStackInSlot(slotid).copy();
											}
											return ItemStack.EMPTY;
										}
									}.getItemStack(world, BlockPos.containing(x, y, z), (int) outputSlot)).copy();
									_setstack.setCount((int) (new Object() {
										public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
											if (world instanceof ILevelExtension _ext) {
												IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
												if (_itemHandler != null)
													return _itemHandler.getStackInSlot(slotid).getCount();
											}
											return 0;
										}
									}.getAmount(world, BlockPos.containing(x, y, z - 2), (int) inputSlot) + new Object() {
										public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
											if (world instanceof ILevelExtension _ext) {
												IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
												if (_itemHandler != null)
													return _itemHandler.getStackInSlot(slotid).getCount();
											}
											return 0;
										}
									}.getAmount(world, BlockPos.containing(x, y, z), (int) outputSlot)));
									_itemHandlerModifiable.setStackInSlot((int) inputSlot, _setstack);
								}
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									int _slotid = (int) outputSlot;
									ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
									_stk.shrink(1);
									_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
								}
							}
							outputSlot = outputSlot + 1;
						}
						outputSlot = 0;
						inputSlot = inputSlot + 1;
					}
				}
				if (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 0) == 0 && new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 1) == 0 && new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 2) == 0 && new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 3) == 0 && new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 4) == 0 && new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 5) == 0 && new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 6) == 0 && new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 7) == 0 && new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 8) == 0) {
					move = true;
					outputSlot = 0;
					posX = x - 1;
					posY = y;
					posZ = z + 1;
					for (int index2 = 0; index2 < 3; index2++) {
						for (int index3 = 0; index3 < 3; index3++) {
							if (!(world.getBlockState(BlockPos.containing(posX, posY, posZ))).is(BlockTags.create(ResourceLocation.parse((cantBreak).toLowerCase(java.util.Locale.ENGLISH))))) {
								if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock() == Blocks.STONE) {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = new ItemStack(Blocks.COBBLESTONE).copy();
										_setstack.setCount(1);
										_itemHandlerModifiable.setStackInSlot((int) outputSlot, _setstack);
									}
								} else if ((world.getBlockState(BlockPos.containing(posX, posY, posZ))).is(BlockTags.create(ResourceLocation.parse((dirt).toLowerCase(java.util.Locale.ENGLISH))))) {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = new ItemStack(Blocks.DIRT).copy();
										_setstack.setCount(1);
										_itemHandlerModifiable.setStackInSlot((int) outputSlot, _setstack);
									}
								} else {
									if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
										ItemStack _setstack = (new ItemStack((world.getBlockState(BlockPos.containing(posX, posY, posZ))).getBlock())).copy();
										_setstack.setCount(1);
										_itemHandlerModifiable.setStackInSlot((int) outputSlot, _setstack);
									}
								}
								world.setBlock(BlockPos.containing(posX, posY, posZ), Blocks.AIR.defaultBlockState(), 3);
							}
							outputSlot = outputSlot + 1;
							posX = posX + 1;
						}
						posX = x - 1;
						posY = posY + 1;
					}
				}
				if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse((cantBreak).toLowerCase(java.util.Locale.ENGLISH))))) {
					{
						BlockPos _bp = BlockPos.containing(x - 1, y - 1, z);
						BlockState _bs = Blocks.COBBLESTONE.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Property<?> _propertyOld : _bso.getProperties()) {
							Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
							if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
								try {
									_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse((cantBreak).toLowerCase(java.util.Locale.ENGLISH))))) {
					{
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						BlockState _bs = Blocks.COBBLESTONE.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Property<?> _propertyOld : _bso.getProperties()) {
							Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
							if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
								try {
									_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse((cantBreak).toLowerCase(java.util.Locale.ENGLISH))))) {
					{
						BlockPos _bp = BlockPos.containing(x + 1, y - 1, z);
						BlockState _bs = Blocks.COBBLESTONE.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Property<?> _propertyOld : _bso.getProperties()) {
							Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
							if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
								try {
									_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
				}
				if (move) {
					if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == fuel_cart.getBlock() && (world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == cargo_cart.getBlock()) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"clone ~ ~ ~ ~ ~ ~-2 ~ ~ ~-1 replace move");
					}
				}
			} else {
				if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == fuel_cart.getBlock()) {
					inputSlot = 0;
					for (int index4 = 0; index4 < (int) fuelCartMaxSlots; index4++) {
						if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z - 1), (int) inputSlot)).getItem() == Items.LAVA_BUCKET) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z - 1), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = (int) inputSlot;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink(1);
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z - 1), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
								_setstack.setCount(1);
								_itemHandlerModifiable.setStackInSlot((int) inputSlot, _setstack);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("Fuel", 100);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						} else if ((new Object() {
							public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
								if (world instanceof ILevelExtension _ext) {
									IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
									if (_itemHandler != null)
										return _itemHandler.getStackInSlot(slotid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(world, BlockPos.containing(x, y, z - 1), (int) inputSlot)).is(ItemTags.create(ResourceLocation.parse((fuelCoal).toLowerCase(java.util.Locale.ENGLISH))))) {
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z - 1), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = (int) inputSlot;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink(1);
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("Fuel", 8);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
						inputSlot = inputSlot + 1;
					}
				}
			}
		}
	}
}
