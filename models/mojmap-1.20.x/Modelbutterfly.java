// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class Modelbutterfly<T extends ButterflyEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "butterfly"), "main");
	private final ModelPart all;
	private final ModelPart body;
	private final ModelPart orbit;
	private final ModelPart left_wing;
	private final ModelPart right_wing;

	public Modelbutterfly(ModelPart root) {
		this.all = root.getChild("all");
		this.body = this.all.getChild("body");
		this.orbit = this.body.getChild("orbit");
		this.left_wing = this.orbit.getChild("left_wing");
		this.right_wing = this.orbit.getChild("right_wing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = all.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition orbit = body.addOrReplaceChild("orbit", CubeListBuilder.create().texOffs(0, 4).addBox(-0.5F,
				-1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_wing = orbit.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(0, 0).addBox(
				0.0F, 0.0F, -5.0F, 7.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -1.0F, 0.0F));

		PartDefinition right_wing = orbit.addOrReplaceChild("right_wing",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-7.0F, 0.0F, -5.0F, 7.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-0.5F, -1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);
		
		this.body.yRot = netHeadYaw / (180F / (float) Math.PI);

		this.animate(entity.idleAnimationState, butterflyAnimation.FLY, ageInTicks);
	}

	@Override
	public ModelPart root() {
		return this.all;
	}

	private record ModelParts(ModelPart all) {
	}
}