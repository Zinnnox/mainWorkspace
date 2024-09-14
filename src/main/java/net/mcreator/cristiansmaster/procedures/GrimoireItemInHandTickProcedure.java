package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import net.mcreator.cristiansmaster.item.GrimoireItem;
import net.mcreator.cristiansmaster.CristianSMasterMod;

public class GrimoireItemInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("J: IceShard" + " K:Fireball " + "M: IronClad")), true);
		if (CristianSMasterModVariables.MapVariables.get(world).hasGrimoireBeenUsed) {
			if (itemstack.getItem() instanceof GrimoireItem)
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString("geckoAnim", "grimoire.use"));
		}
		CristianSMasterMod.queueServerWork(20, () -> {
			CristianSMasterModVariables.MapVariables.get(world).hasGrimoireBeenUsed = false;
			CristianSMasterModVariables.MapVariables.get(world).syncData(world);
			if (itemstack.getItem() instanceof GrimoireItem)
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString("geckoAnim", "grimoire.idle"));
		});
	}
}
