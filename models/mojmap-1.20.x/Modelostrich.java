// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelostrich<T extends OstrichEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "ostrich"), "main");
	private final ModelPart all;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart right_wing;
	private final ModelPart left_wing;
	private final ModelPart saddle;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public Modelostrich(ModelPart root) {
		this.all = root.getChild("all");
		this.body = this.all.getChild("body");
		this.head = this.body.getChild("head");
		this.tail = this.body.getChild("tail");
		this.right_wing = this.body.getChild("right_wing");
		this.left_wing = this.body.getChild("left_wing");
		this.saddle = this.body.getChild("saddle");
		this.right_leg = this.all.getChild("right_leg");
		this.left_leg = this.all.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = all.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-5.0F, -12.25F, -6.75F, 10.0F, 12.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(50, 0)
						.addBox(-3.0F, -9.25F, -10.75F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -17.75F, 0.75F));

		PartDefinition head = body.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(36, 57)
						.addBox(-1.5F, -10.75F, -3.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(50, 11)
						.addBox(-1.5F, -20.75F, 0.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 59)
						.addBox(-2.5F, -18.75F, -3.0F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -5.5F, -10.75F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(),
				PartPose.offset(0.0F, -12.1893F, 8.1036F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1",
				CubeListBuilder.create().texOffs(0, 48)
						.addBox(-3.0F, -6.5F, -3.0F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(42, 27)
						.addBox(-3.0F, -2.5F, -3.0F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.0F, 3.5F, -2.3562F, 0.0F, 0.0F));

		PartDefinition right_wing = body.addOrReplaceChild("right_wing",
				CubeListBuilder.create().texOffs(42, 41)
						.addBox(-7.0F, -6.0F, -3.0F, 2.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(48, 57)
						.mirror().addBox(-7.0F, -6.0F, 6.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-0.1F, -0.25F, 1.25F));

		PartDefinition left_wing = body.addOrReplaceChild("left_wing",
				CubeListBuilder.create().texOffs(48, 57)
						.addBox(5.0F, -6.0F, 6.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(42, 41)
						.addBox(5.0F, -6.0F, -3.0F, 2.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.1F, -0.25F, 1.25F));

		PartDefinition saddle = body.addOrReplaceChild("saddle", CubeListBuilder.create().texOffs(0, 27).addBox(-5.0F,
				-2.0F, -5.0F, 10.0F, 10.0F, 11.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -10.25F, 0.25F));

		PartDefinition right_leg = all.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(26, 48)
						.addBox(-1.0F, 0.0F, -1.5F, 2.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(16, 59)
						.addBox(-1.0F, 17.0F, -4.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, -18.0F, 1.5F));

		PartDefinition left_leg = all.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(60, 57)
						.addBox(-1.0F, 17.0F, -4.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(26, 48)
						.addBox(-1.0F, 0.0F, -1.5F, 2.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, -18.0F, 1.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);

		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		
		if (entity.getEntityData().get(OstrichEntity.DATA_hide_animtime) == 0)
			this.head.yRot = netHeadYaw / (180F / (float) Math.PI) + 0.5F;
	
		
		this.animate(entity.idleAnimationState, ostrichAnimation.IDLE, ageInTicks);
		this.animate(entity.layAnimationState, ostrichAnimation.LAY_EGG, ageInTicks);

		if (entity.getEntityData().get(OstrichEntity.DATA_hide_animtime) > 14) {
			this.animate(entity.hideAnimationState, ostrichAnimation.HIDE, ageInTicks);
		} else if (entity.getEntityData().get(OstrichEntity.DATA_is_hiding)) {
			this.animate(entity.hideAnimationState, ostrichAnimation.HIDE_END, ageInTicks);
		} else {
			this.animate(entity.hideAnimationState, ostrichAnimation.HIDE_START, ageInTicks);
		}
		
		if (entity.isVehicle()) {
			this.animateWalk(ostrichAnimation.RUN, limbSwing, limbSwingAmount, 1.0F, 2.0F);
		} else {
			this.animateWalk(ostrichAnimation.WALK, limbSwing, limbSwingAmount, 2.5F, 4.0F);
		}
	}

	@Override
	public ModelPart root() {
		return this.all;
	}

	private record ModelParts(ModelPart all) {
	}
}