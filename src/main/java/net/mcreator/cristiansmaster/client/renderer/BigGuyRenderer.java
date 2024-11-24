
package net.mcreator.cristiansmaster.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.cristiansmaster.entity.BigGuyEntity;
import net.mcreator.cristiansmaster.client.model.Modelbig_guy;

public class BigGuyRenderer extends MobRenderer<BigGuyEntity, Modelbig_guy<BigGuyEntity>> {
	public BigGuyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbig_guy(context.bakeLayer(Modelbig_guy.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BigGuyEntity entity) {
		return ResourceLocation.parse("cristian_s_master:textures/entities/bigguytexture.png");
	}
}
