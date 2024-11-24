
package net.mcreator.cristiansmaster.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.cristiansmaster.entity.DragonEntity;
import net.mcreator.cristiansmaster.client.model.ModelCustomModel;

public class DragonRenderer extends MobRenderer<DragonEntity, ModelCustomModel<DragonEntity>> {
	public DragonRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCustomModel(context.bakeLayer(ModelCustomModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DragonEntity entity) {
		return ResourceLocation.parse("cristian_s_master:textures/entities/enderdragonuntextrd.png");
	}
}
