
package net.mcreator.cristiansmaster.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.cristiansmaster.entity.TornadoEntity;
import net.mcreator.cristiansmaster.client.model.ModeltornadoWhoosh;

public class TornadoRenderer extends MobRenderer<TornadoEntity, ModeltornadoWhoosh<TornadoEntity>> {
	public TornadoRenderer(EntityRendererProvider.Context context) {
		super(context, new ModeltornadoWhoosh<TornadoEntity>(context.bakeLayer(ModeltornadoWhoosh.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TornadoEntity entity) {
		return ResourceLocation.parse("cristian_s_master:textures/entities/tornadowhoosh.png");
	}
}
