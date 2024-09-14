package net.mcreator.cristiansmaster.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelwyrm<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("cristian_s_master", "modelwyrm"), "main");
	public final ModelPart bb_main;

	public Modelwyrm(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(192, 104).addBox(-5.0F, -12.8716F, -27.9619F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(48, 0).addBox(-1.0F, -16.8716F, -25.9619F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
						.texOffs(0, 0).addBox(-12.0F, -20.0F, -8.0F, 24.0F, 24.0F, 64.0F, new CubeDeformation(0.0F)).texOffs(220, 53).addBox(-1.0F, -26.0F, -2.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(220, 53)
						.addBox(-1.0F, -26.0F, 18.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(220, 53).addBox(-1.0F, -26.0F, 38.0F, 2.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(192, 104)
						.addBox(-5.0F, -19.0F, 56.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(48, 0).addBox(-1.0F, -23.0F, 58.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition tail_r1 = bb_main.addOrReplaceChild("tail_r1",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 168.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 166.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.1465F, 0.0396F, 0.0524F, 0.0F, 0.0F));
		PartDefinition tail_r2 = bb_main.addOrReplaceChild("tail_r2",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 158.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 156.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 5.4599F, 1.4522F, 0.1047F, 0.0F, 0.0F));
		PartDefinition tail_r3 = bb_main.addOrReplaceChild("tail_r3",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 148.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 146.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.4616F, 3.2449F, 0.1571F, 0.0F, 0.0F));
		PartDefinition tail_r4 = bb_main.addOrReplaceChild("tail_r4",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 138.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 136.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 18.3954F, 4.6111F, 0.192F, 0.0F, 0.0F));
		PartDefinition tail_r5 = bb_main.addOrReplaceChild("tail_r5",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 128.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 126.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 20.6727F, 5.3237F, 0.2094F, 0.0F, 0.0F));
		PartDefinition tail_r6 = bb_main.addOrReplaceChild("tail_r6",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 118.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 116.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 18.5665F, 4.6459F, 0.192F, 0.0F, 0.0F));
		PartDefinition tail_r7 = bb_main.addOrReplaceChild("tail_r7",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 108.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 106.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.6977F, 2.9206F, 0.1396F, 0.0F, 0.0F));
		PartDefinition tail_r8 = bb_main.addOrReplaceChild("tail_r8",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 98.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 96.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 7.2668F, 1.5642F, 0.0873F, 0.0F, 0.0F));
		PartDefinition tail_r9 = bb_main.addOrReplaceChild("tail_r9",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 88.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 86.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.9582F, 0.8429F, 0.0524F, 0.0F, 0.0F));
		PartDefinition tail_r10 = bb_main.addOrReplaceChild("tail_r10",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 78.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 76.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.4693F, 0.5334F, 0.0349F, 0.0F, 0.0F));
		PartDefinition tail_r11 = bb_main.addOrReplaceChild("tail_r11",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -23.0F, 68.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -19.0F, 66.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.1497F, 0.2544F, 0.0175F, 0.0F, 0.0F));
		PartDefinition frontfoot_r1 = bb_main.addOrReplaceChild("frontfoot_r1",
				CubeListBuilder.create().texOffs(144, 104).mirror().addBox(8.0F, 38.0F, -10.0F, 8.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(144, 104).addBox(-16.0F, 38.0F, -10.0F, 8.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 22.0087F, -2.3175F, 1.5708F, 0.0F, 0.0F));
		PartDefinition frontlegtip_r1 = bb_main.addOrReplaceChild("frontlegtip_r1",
				CubeListBuilder.create().texOffs(226, 138).mirror().addBox(9.0F, 15.0F, -1.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(226, 138).addBox(-15.0F, 15.0F, -1.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.4471F, 7.3982F, 0.7854F, 0.0F, 0.0F));
		PartDefinition frontleg1_r1 = bb_main.addOrReplaceChild("frontleg1_r1",
				CubeListBuilder.create().texOffs(112, 104).mirror().addBox(8.0F, -8.0F, -2.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(112, 104).addBox(-16.0F, -8.0F, -2.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.4969F, 4.78F, 1.1345F, 0.0F, 0.0F));
		PartDefinition rearfoot_r1 = bb_main.addOrReplaceChild("rearfoot_r1",
				CubeListBuilder.create().texOffs(112, 0).mirror().addBox(7.0F, 52.0F, 21.0F, 18.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(112, 0).addBox(-25.0F, 52.0F, 21.0F, 18.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 74.7481F, 84.9726F, 2.2689F, 0.0F, 0.0F));
		PartDefinition rearlegtip_r1 = bb_main.addOrReplaceChild("rearlegtip_r1",
				CubeListBuilder.create().texOffs(196, 0).mirror().addBox(10.0F, 20.0F, 36.0F, 12.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(196, 0).addBox(-22.0F, 20.0F, 36.0F, 12.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 46.2272F, 43.0771F, 1.4835F, 0.0F, 0.0F));
		PartDefinition rearleg1_r1 = bb_main.addOrReplaceChild("rearleg1_r1",
				CubeListBuilder.create().texOffs(0, 0).mirror().addBox(8.0F, -12.0F, 34.0F, 16.0F, 32.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-24.0F, -12.0F, 34.0F, 16.0F, 32.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 32.3731F, 27.9282F, 1.0472F, 0.0F, 0.0F));
		PartDefinition wingtip1_r1 = bb_main.addOrReplaceChild("wingtip1_r1", CubeListBuilder.create().texOffs(-56, 144).mirror().addBox(68.0F, -19.0F, 4.0F, 56.0F, 0.0F, 56.0F, new CubeDeformation(0.01F)).mirror(false).texOffs(112, 136).mirror()
				.addBox(68.0F, -21.0F, 0.0F, 56.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5596F, -21.9194F, -2.4697F, -0.0602F, -0.1639F, 0.1795F));
		PartDefinition wing1_r1 = bb_main.addOrReplaceChild("wing1_r1", CubeListBuilder.create().texOffs(-56, 88).mirror().addBox(12.0F, -19.0F, 4.0F, 56.0F, 0.0F, 56.0F, new CubeDeformation(0.01F)).mirror(false).texOffs(112, 88).mirror()
				.addBox(12.0F, -23.0F, -2.0F, 56.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0032F, 1.7032F, -2.0534F, 0.0F, -0.1745F, -0.1745F));
		PartDefinition wingtip_r1 = bb_main.addOrReplaceChild("wingtip_r1",
				CubeListBuilder.create().texOffs(-56, 144).addBox(-124.0F, -19.0F, 4.0F, 56.0F, 0.0F, 56.0F, new CubeDeformation(0.01F)).texOffs(112, 136).addBox(-124.0F, -21.0F, 0.0F, 56.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5596F, -21.9193F, -2.4697F, -0.0602F, 0.1639F, -0.1795F));
		PartDefinition wing_r1 = bb_main.addOrReplaceChild("wing_r1",
				CubeListBuilder.create().texOffs(-56, 88).addBox(-68.0F, -19.0F, 4.0F, 56.0F, 0.0F, 56.0F, new CubeDeformation(0.01F)).texOffs(112, 88).addBox(-68.0F, -23.0F, -2.0F, 56.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0032F, 1.7032F, -2.0534F, 0.0F, 0.1745F, 0.1745F));
		PartDefinition jaw_r1 = bb_main.addOrReplaceChild("jaw_r1", CubeListBuilder.create().texOffs(176, 65).addBox(-6.0F, -3.0F, -88.0F, 12.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -32.7368F, -8.3986F, 0.6109F, 0.0F, 0.0F));
		PartDefinition head_r1 = bb_main.addOrReplaceChild("head_r1",
				CubeListBuilder.create().texOffs(112, 0).addBox(3.0F, -10.0F, -86.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(3.0F, -19.0F, -68.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(112, 0).mirror()
						.addBox(-5.0F, -10.0F, -86.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).mirror().addBox(-5.0F, -19.0F, -68.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(112, 30)
						.addBox(-8.0F, -15.0F, -74.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(176, 44).addBox(-6.0F, -8.0F, -88.0F, 12.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -15.9346F, -0.5349F, 0.3491F, 0.0F, 0.0F));
		PartDefinition neck_r1 = bb_main.addOrReplaceChild("neck_r1",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -16.0F, -56.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -12.0F, -58.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -10.9254F, 0.4042F, 0.2618F, 0.0F, 0.0F));
		PartDefinition neck_r2 = bb_main.addOrReplaceChild("neck_r2",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -16.0F, -46.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -12.0F, -48.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.705F, 0.7143F, 0.1745F, 0.0F, 0.0F));
		PartDefinition neck_r3 = bb_main.addOrReplaceChild("neck_r3",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -16.0F, -36.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -12.0F, -38.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.3386F, 0.5416F, 0.0873F, 0.0F, 0.0F));
		PartDefinition neck_r4 = bb_main.addOrReplaceChild("neck_r4",
				CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -16.0F, -16.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(192, 104).addBox(-5.0F, -12.0F, -18.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.6706F, -0.6405F, -0.0873F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
