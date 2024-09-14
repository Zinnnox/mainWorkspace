
package net.mcreator.cristiansmaster.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.cristiansmaster.entity.MaryannTheSlimeEntity;
import net.mcreator.cristiansmaster.client.model.ModelmaryannF;

public class MaryannTheSlimeRenderer extends MobRenderer<MaryannTheSlimeEntity, ModelmaryannF<MaryannTheSlimeEntity>> {
	public MaryannTheSlimeRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelmaryannF(context.bakeLayer(ModelmaryannF.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MaryannTheSlimeEntity entity) {
		return new ResourceLocation("cristian_s_master:textures/entities/slime.png");
	}
}
