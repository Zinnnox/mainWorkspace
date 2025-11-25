
package net.mcreator.cristiansmaster.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FilledPokeballItem extends Item {
	public FilledPokeballItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
