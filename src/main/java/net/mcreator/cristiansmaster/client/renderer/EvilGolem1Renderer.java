
package net.mcreator.cristiansmaster.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.cristiansmaster.entity.EvilGolem1Entity;
import net.mcreator.cristiansmaster.client.model.ModelIronGolemModel;

public class EvilGolem1Renderer extends MobRenderer<EvilGolem1Entity, ModelIronGolemModel<EvilGolem1Entity>> {
	public EvilGolem1Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelIronGolemModel<EvilGolem1Entity>(context.bakeLayer(ModelIronGolemModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EvilGolem1Entity entity) {
		return ResourceLocation.parse("cristian_s_master:textures/entities/evilgolem1.png");
	}
}
