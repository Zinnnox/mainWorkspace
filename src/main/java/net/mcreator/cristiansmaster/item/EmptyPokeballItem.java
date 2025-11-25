
package net.mcreator.cristiansmaster.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EmptyPokeballItem extends Item {
	public EmptyPokeballItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
