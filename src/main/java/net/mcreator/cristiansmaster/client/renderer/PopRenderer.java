
package net.mcreator.cristiansmaster.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.cristiansmaster.entity.PopEntity;
import net.mcreator.cristiansmaster.client.model.Modelpop;

public class PopRenderer extends MobRenderer<PopEntity, Modelpop<PopEntity>> {
	public PopRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpop(context.bakeLayer(Modelpop.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PopEntity entity) {
		return new ResourceLocation("cristian_s_master:textures/entities/poptexture.png");
	}
}
