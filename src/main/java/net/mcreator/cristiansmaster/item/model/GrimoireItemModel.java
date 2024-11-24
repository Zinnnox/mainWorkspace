package net.mcreator.cristiansmaster.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.cristiansmaster.item.GrimoireItem;

public class GrimoireItemModel extends GeoModel<GrimoireItem> {
	@Override
	public ResourceLocation getAnimationResource(GrimoireItem animatable) {
		return ResourceLocation.parse("cristian_s_master:animations/grimoire.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GrimoireItem animatable) {
		return ResourceLocation.parse("cristian_s_master:geo/grimoire.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GrimoireItem animatable) {
		return ResourceLocation.parse("cristian_s_master:textures/item/grimoire.png");
	}
}
