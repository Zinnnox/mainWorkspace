
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.cristiansmaster.client.renderer.TornadoRenderer;
import net.mcreator.cristiansmaster.client.renderer.PopRenderer;
import net.mcreator.cristiansmaster.client.renderer.OutlineRenderer;
import net.mcreator.cristiansmaster.client.renderer.MaryannTheSlimeRenderer;
import net.mcreator.cristiansmaster.client.renderer.MagicalDartRenderer;
import net.mcreator.cristiansmaster.client.renderer.IroncladRenderer;
import net.mcreator.cristiansmaster.client.renderer.IceshardRenderer;
import net.mcreator.cristiansmaster.client.renderer.FireballRenderer;
import net.mcreator.cristiansmaster.client.renderer.DragonRenderer;
import net.mcreator.cristiansmaster.client.renderer.BonnieRenderer;
import net.mcreator.cristiansmaster.client.renderer.BigGuyRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CristianSMasterModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CristianSMasterModEntities.DRAGON.get(), DragonRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.MARYANN_THE_SLIME.get(), MaryannTheSlimeRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.ICESHARD.get(), IceshardRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.FIREBALL.get(), FireballRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.IRONCLAD.get(), IroncladRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.MAGICAL_DART.get(), MagicalDartRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.TORNADO.get(), TornadoRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.EXPLODING_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.THE_BOMB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.POP.get(), PopRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.BIG_GUY.get(), BigGuyRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.OUTLINE.get(), OutlineRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.PORTAL_SHOOT_TO_PLACE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.BONNIE.get(), BonnieRenderer::new);
		event.registerEntityRenderer(CristianSMasterModEntities.FIREWORK_PROJECTILE.get(), ThrownItemRenderer::new);
	}
}
