package net.mcreator.cristiansmaster.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.cristiansmaster.entity.BonnieEntity;

public class BonnieModel extends GeoModel<BonnieEntity> {
	@Override
	public ResourceLocation getAnimationResource(BonnieEntity entity) {
		return new ResourceLocation("cristian_s_master", "animations/bonniecarter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BonnieEntity entity) {
		return new ResourceLocation("cristian_s_master", "geo/bonniecarter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BonnieEntity entity) {
		return new ResourceLocation("cristian_s_master", "textures/entities/" + entity.getTexture() + ".png");
	}

}
