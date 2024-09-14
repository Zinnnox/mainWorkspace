
package net.mcreator.cristiansmaster.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.cristiansmaster.entity.HelloEntity;
import net.mcreator.cristiansmaster.client.model.ModelmaryannF;

public class HelloRenderer extends MobRenderer<HelloEntity, ModelmaryannF<HelloEntity>> {
	public HelloRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelmaryannF(context.bakeLayer(ModelmaryannF.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HelloEntity entity) {
		return new ResourceLocation("cristian_s_master:textures/entities/slime.png");
	}
}
