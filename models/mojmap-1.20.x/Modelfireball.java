// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelfireball<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "fireball"), "main");
	private final ModelPart fireball;

	public Modelfireball(ModelPart root) {
		this.fireball = root.getChild("fireball");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fireball = partdefinition.addOrReplaceChild("fireball", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = fireball.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(11, 2).mirror()
						.addBox(0.0F, -2.0F, -4.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r2 = fireball.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 7).mirror()
						.addBox(-3.0F, -2.0F, -4.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition cube_r3 = fireball.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(11, 9).mirror()
						.addBox(-3.0F, -2.0F, -4.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r4 = fireball.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(-2, -3).mirror()
						.addBox(-3.0F, -2.0F, -4.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition cube_r5 = fireball.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(11, 2).addBox(-3.0F, -2.0F, -4.0F, 3.0F, 2.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition cube_r6 = fireball.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(-2, -3).addBox(0.0F, -2.0F, -4.0F, 3.0F, 2.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r7 = fireball.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -2.0F, -4.0F, 3.0F, 2.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r8 = fireball.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(11, 9).addBox(0.0F, -2.0F, -4.0F, 3.0F, 2.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		fireball.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}