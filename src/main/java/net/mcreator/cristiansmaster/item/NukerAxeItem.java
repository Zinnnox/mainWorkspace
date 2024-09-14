
package net.mcreator.cristiansmaster.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.cristiansmaster.procedures.NukerAxeEntitySwingsItemProcedure;

public class NukerAxeItem extends Item {
	public NukerAxeItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		NukerAxeEntitySwingsItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return retval;
	}
}
