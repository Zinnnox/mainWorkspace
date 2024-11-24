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
public class Modelsillygoose<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("cristian_s_master", "modelsillygoose"), "main");
	public final ModelPart head;
	public final ModelPart eye;
	public final ModelPart tailpart0;
	public final ModelPart tailpart1;
	public final ModelPart tailpart2;
	public final ModelPart spikepart0;
	public final ModelPart spikepart1;
	public final ModelPart spikepart2;
	public final ModelPart spikepart3;
	public final ModelPart spikepart4;
	public final ModelPart spikepart5;
	public final ModelPart spikepart6;
	public final ModelPart spikepart7;
	public final ModelPart spikepart8;
	public final ModelPart spikepart9;
	public final ModelPart spikepart10;
	public final ModelPart spikepart11;

	public Modelsillygoose(ModelPart root) {
		this.head = root.getChild("head");
		this.eye = root.getChild("eye");
		this.tailpart0 = root.getChild("tailpart0");
		this.tailpart1 = root.getChild("tailpart1");
		this.tailpart2 = root.getChild("tailpart2");
		this.spikepart0 = root.getChild("spikepart0");
		this.spikepart1 = root.getChild("spikepart1");
		this.spikepart2 = root.getChild("spikepart2");
		this.spikepart3 = root.getChild("spikepart3");
		this.spikepart4 = root.getChild("spikepart4");
		this.spikepart5 = root.getChild("spikepart5");
		this.spikepart6 = root.getChild("spikepart6");
		this.spikepart7 = root.getChild("spikepart7");
		this.spikepart8 = root.getChild("spikepart8");
		this.spikepart9 = root.getChild("spikepart9");
		this.spikepart10 = root.getChild("spikepart10");
		this.spikepart11 = root.getChild("spikepart11");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -14.0F, -8.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(28, 45).addBox(-8.0F, -14.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 43)
						.addBox(6.0F, -14.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 28).addBox(-6.0F, -17.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(36, 31)
						.addBox(-6.0F, -2.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 15.0F, -8.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));
		PartDefinition tailpart0 = head.addOrReplaceChild("tailpart0", CubeListBuilder.create().texOffs(16, 43).addBox(-2.0F, 14.0F, 8.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));
		PartDefinition tailpart1 = tailpart0.addOrReplaceChild("tailpart1", CubeListBuilder.create().texOffs(44, 45).addBox(-1.5F, 14.0F, 16.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition tailpart2 = tailpart1.addOrReplaceChild("tailpart2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 14.0F, 23.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(56, 0).addBox(0.0F, 10.5F, 26.0F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition spikepart0 = head.addOrReplaceChild("spikepart0", CubeListBuilder.create().texOffs(0, 67).addBox(10.25F, -4.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition spikepart1 = head.addOrReplaceChild("spikepart1", CubeListBuilder.create().texOffs(56, 66).addBox(-12.25F, -4.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition spikepart2 = head.addOrReplaceChild("spikepart2", CubeListBuilder.create().texOffs(64, 56).addBox(-1.0F, -4.5F, -12.25F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition spikepart3 = head.addOrReplaceChild("spikepart3", CubeListBuilder.create().texOffs(64, 45).addBox(-1.0F, -4.5F, 10.5F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition spikepart4 = head.addOrReplaceChild("spikepart4", CubeListBuilder.create().texOffs(64, 18).addBox(10.25F, -27.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0F, 0.0F, 2.3562F));
		PartDefinition spikepart5 = head.addOrReplaceChild("spikepart5", CubeListBuilder.create().texOffs(56, 55).addBox(-12.25F, -27.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.0F, 0.0F, -2.3562F));
		PartDefinition spikepart6 = head.addOrReplaceChild("spikepart6", CubeListBuilder.create().texOffs(56, 18).addBox(-1.0F, -28.5F, -12.25F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 2.3562F, 0.0F, 0.0F));
		PartDefinition spikepart7 = head.addOrReplaceChild("spikepart7", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -27.5F, 10.25F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -2.3562F, 0.0F, 0.0F));
		PartDefinition spikepart8 = head.addOrReplaceChild("spikepart8", CubeListBuilder.create().texOffs(0, 43).addBox(-1.0F, -17.5F, -17.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 1.5708F, -0.7854F, 0.0F));
		PartDefinition spikepart9 = head.addOrReplaceChild("spikepart9", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -17.5F, -17.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 1.5708F, 0.7854F, 0.0F));
		PartDefinition spikepart10 = head.addOrReplaceChild("spikepart10", CubeListBuilder.create().texOffs(36, 28).addBox(-1.0F, -17.5F, -17.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 1.5708F, -2.3562F, 0.0F));
		PartDefinition spikepart11 = head.addOrReplaceChild("spikepart11", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, -17.5F, -17.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 1.5708F, 2.3562F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}
