
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.cristiansmaster.client.model.ModelxrayOutline;
import net.mcreator.cristiansmaster.client.model.Modelwyrm;
import net.mcreator.cristiansmaster.client.model.ModeltornadoWhoosh;
import net.mcreator.cristiansmaster.client.model.Modelsillygoose;
import net.mcreator.cristiansmaster.client.model.Modelpop;
import net.mcreator.cristiansmaster.client.model.ModelmaryannF;
import net.mcreator.cristiansmaster.client.model.Modeliceshard;
import net.mcreator.cristiansmaster.client.model.Modelfireball;
import net.mcreator.cristiansmaster.client.model.Modelbig_guy;
import net.mcreator.cristiansmaster.client.model.Modelbackpack;
import net.mcreator.cristiansmaster.client.model.ModelDart;
import net.mcreator.cristiansmaster.client.model.ModelCustomModel;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CristianSMasterModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeliceshard.LAYER_LOCATION, Modeliceshard::createBodyLayer);
		event.registerLayerDefinition(Modelbig_guy.LAYER_LOCATION, Modelbig_guy::createBodyLayer);
		event.registerLayerDefinition(ModelxrayOutline.LAYER_LOCATION, ModelxrayOutline::createBodyLayer);
		event.registerLayerDefinition(Modelsillygoose.LAYER_LOCATION, Modelsillygoose::createBodyLayer);
		event.registerLayerDefinition(Modelfireball.LAYER_LOCATION, Modelfireball::createBodyLayer);
		event.registerLayerDefinition(Modelwyrm.LAYER_LOCATION, Modelwyrm::createBodyLayer);
		event.registerLayerDefinition(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
		event.registerLayerDefinition(ModelDart.LAYER_LOCATION, ModelDart::createBodyLayer);
		event.registerLayerDefinition(ModeltornadoWhoosh.LAYER_LOCATION, ModeltornadoWhoosh::createBodyLayer);
		event.registerLayerDefinition(ModelmaryannF.LAYER_LOCATION, ModelmaryannF::createBodyLayer);
		event.registerLayerDefinition(Modelpop.LAYER_LOCATION, Modelpop::createBodyLayer);
		event.registerLayerDefinition(Modelbackpack.LAYER_LOCATION, Modelbackpack::createBodyLayer);
	}
}
