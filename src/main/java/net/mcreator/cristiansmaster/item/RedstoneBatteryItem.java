
package net.mcreator.cristiansmaster.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RedstoneBatteryItem extends Item {
	public RedstoneBatteryItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
