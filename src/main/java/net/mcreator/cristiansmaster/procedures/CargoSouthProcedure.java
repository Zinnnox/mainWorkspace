package net.mcreator.cristiansmaster.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CargoSouthProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
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
	}
}
