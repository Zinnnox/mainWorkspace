
package net.mcreator.cristiansmaster.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.animation.definitions.WardenAnimation;
import net.minecraft.client.Minecraft;

import net.mcreator.cristiansmaster.procedures.BloodyGolemDisplayConditionProcedure;
import net.mcreator.cristiansmaster.procedures.BloodyGolemDisplayCondition2Procedure;
import net.mcreator.cristiansmaster.entity.BloodyGolemEntity;
import net.mcreator.cristiansmaster.client.model.ModelnewIronClad;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BloodyGolemRenderer extends MobRenderer<BloodyGolemEntity, ModelnewIronClad<BloodyGolemEntity>> {
	public BloodyGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelnewIronClad.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<BloodyGolemEntity, ModelnewIronClad<BloodyGolemEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("cristian_s_master:textures/entities/golemphase1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, BloodyGolemEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (BloodyGolemDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new ModelnewIronClad(Minecraft.getInstance().getEntityModels().bakeLayer(ModelnewIronClad.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<BloodyGolemEntity, ModelnewIronClad<BloodyGolemEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("cristian_s_master:textures/entities/phase2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, BloodyGolemEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (BloodyGolemDisplayCondition2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new ModelnewIronClad(Minecraft.getInstance().getEntityModels().bakeLayer(ModelnewIronClad.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(BloodyGolemEntity entity) {
		return ResourceLocation.parse("cristian_s_master:textures/entities/golemphase1.png");
	}

	private static final class AnimatedModel extends ModelnewIronClad<BloodyGolemEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<BloodyGolemEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(BloodyGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, WardenAnimation.WARDEN_ATTACK, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(BloodyGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
