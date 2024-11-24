package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mcreator.cristiansmaster.client.renderer.BackpackRenderer;
import net.mcreator.cristiansmaster.client.model.Modelbackpack;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CristianSMasterModCuriosRenderers {
	@SubscribeEvent
	public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions evt) {
		evt.registerLayerDefinition(CristianSMasterModLayerDefinitions.BACKPACK, Modelbackpack::createBodyLayer);
	}

	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent evt) {
		CuriosRendererRegistry.register(CristianSMasterModItems.BACKPACK.get(), BackpackRenderer::new);
	}
}
