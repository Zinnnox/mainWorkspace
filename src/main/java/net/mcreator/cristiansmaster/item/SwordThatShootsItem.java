
package net.mcreator.cristiansmaster.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.cristiansmaster.procedures.SwordThatShootsEntitySwingsItemProcedure;

public class SwordThatShootsItem extends Item {
	public SwordThatShootsItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		SwordThatShootsEntitySwingsItemProcedure.execute(entity);
		return retval;
	}
}
