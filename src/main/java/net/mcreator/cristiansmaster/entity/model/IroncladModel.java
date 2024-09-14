package net.mcreator.cristiansmaster.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.cristiansmaster.entity.IroncladEntity;

public class IroncladModel extends GeoModel<IroncladEntity> {
	@Override
	public ResourceLocation getAnimationResource(IroncladEntity entity) {
		return new ResourceLocation("cristian_s_master", "animations/ironclad.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IroncladEntity entity) {
		return new ResourceLocation("cristian_s_master", "geo/ironclad.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IroncladEntity entity) {
		return new ResourceLocation("cristian_s_master", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(IroncladEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
