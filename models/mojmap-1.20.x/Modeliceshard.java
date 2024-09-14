// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeliceshard<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "iceshard"), "main");
	private final ModelPart bb_main;

	public Modeliceshard(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.8074F, -6.7502F, 8.0F, 2.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.6913F, 0.0F, 0.3927F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -3.8074F, -3.2498F, 8.0F, 2.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.6913F, 0.0F, 2.7489F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, 1.6913F, -5.0F, 8.0F, 2.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.6913F, 0.0F, 1.5708F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}