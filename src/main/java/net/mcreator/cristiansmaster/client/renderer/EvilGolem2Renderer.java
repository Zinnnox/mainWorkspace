
package net.mcreator.cristiansmaster.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.cristiansmaster.entity.EvilGolem2Entity;
import net.mcreator.cristiansmaster.client.model.ModelIronGolemModel;

import com.mojang.blaze3d.vertex.PoseStack;

public class EvilGolem2Renderer extends MobRenderer<EvilGolem2Entity, ModelIronGolemModel<EvilGolem2Entity>> {
	public EvilGolem2Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelIronGolemModel<EvilGolem2Entity>(context.bakeLayer(ModelIronGolemModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(EvilGolem2Entity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(EvilGolem2Entity entity) {
		return ResourceLocation.parse("cristian_s_master:textures/entities/evilgolem2.png");
	}
}
