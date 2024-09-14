
package net.mcreator.cristiansmaster.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.cristiansmaster.procedures.FairyDustCheckProcedure;

public class FairyDustItem extends Item {
	public FairyDustItem() {
		super(new Item.Properties().durability(1).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(5f).alwaysEdible().build()));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		FairyDustCheckProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}
}
