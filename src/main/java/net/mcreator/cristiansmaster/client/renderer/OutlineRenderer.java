
package net.mcreator.cristiansmaster.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.cristiansmaster.entity.OutlineEntity;
import net.mcreator.cristiansmaster.client.model.ModelxrayOutline;

public class OutlineRenderer extends MobRenderer<OutlineEntity, ModelxrayOutline<OutlineEntity>> {
	public OutlineRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelxrayOutline<OutlineEntity>(context.bakeLayer(ModelxrayOutline.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(OutlineEntity entity) {
		return ResourceLocation.parse("cristian_s_master:textures/entities/xrayoutlinetexture.png");
	}
}
