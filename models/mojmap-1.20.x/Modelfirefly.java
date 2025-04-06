// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelfirefly<T extends FireflyEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "firefly"), "main");
	private final ModelPart all;
	private final ModelPart body_ext;
	private final ModelPart orbit;
	private final ModelPart wing_left;
	private final ModelPart wing_right;
	private final ModelPart body;
	private final ModelPart particle_source;

	public Modelfirefly(ModelPart root) {
		this.all = root.getChild("all");
		this.body_ext = this.all.getChild("body_ext");
		this.orbit = this.body_ext.getChild("orbit");
		this.wing_left = this.orbit.getChild("wing_left");
		this.wing_right = this.orbit.getChild("wing_right");
		this.body = this.orbit.getChild("body");
		this.particle_source = this.orbit.getChild("particle_source");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(),
				PartPose.offset(1.0F, 22.0F, -1.0F));

		PartDefinition body_ext = all.addOrReplaceChild("body_ext", CubeListBuilder.create(),
				PartPose.offset(-1.0F, 2.0F, 2.0F));

		PartDefinition orbit = body_ext.addOrReplaceChild("orbit", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition wing_left = orbit.addOrReplaceChild("wing_left", CubeListBuilder.create(),
				PartPose.offset(-1.0F, -2.0F, -2.0F));

		PartDefinition wing_left_r1 = wing_left.addOrReplaceChild("wing_left_r1",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition wing_right = orbit.addOrReplaceChild("wing_right", CubeListBuilder.create(),
				PartPose.offset(1.0F, -2.0F, -2.0F));

		PartDefinition wing_right_r1 = wing_right
				.addOrReplaceChild("wing_right_r1",
						CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 0.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition body = orbit.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F,
				-2.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(0, 0).addBox(1.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -2.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition particle_source = orbit.addOrReplaceChild("particle_source", CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);
		
		this.body_ext.yRot = netHeadYaw / (180F / (float) Math.PI);

		this.animate(entity.idleAnimationState, fireflyAnimation.FLY, ageInTicks);
	}

	@Override
	public ModelPart root() {
		return this.all;
	}

	private record ModelParts(ModelPart all) {
	}
}