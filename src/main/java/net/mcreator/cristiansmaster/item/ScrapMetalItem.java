
package net.mcreator.cristiansmaster.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ScrapMetalItem extends Item {
	public ScrapMetalItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
