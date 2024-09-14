// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModeltornadoWhoosh<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "tornadowhoosh"), "main");
	private final ModelPart bb_main;

	public ModeltornadoWhoosh(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(1, 83)
						.addBox(-2.5F, -7.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(49, 71)
						.addBox(-2.5F, -13.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(78, 32)
						.addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(74, 28)
						.addBox(-6.0F, -13.0F, -6.0F, 12.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.0F, -21.0F, -9.0F, 18.0F, 8.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
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