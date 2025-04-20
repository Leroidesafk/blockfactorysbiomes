// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcopper_armor<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "copper_armor"), "main");
	private final ModelPart helmet;
	private final ModelPart chest;
	private final ModelPart arm_left;
	private final ModelPart arm_right;
	private final ModelPart leg_left_boots;
	private final ModelPart leg_right_boots;
	private final ModelPart leg_left_leggings;
	private final ModelPart leg_right_leggings;

	public Modelcopper_armor(ModelPart root) {
		this.helmet = root.getChild("helmet");
		this.chest = root.getChild("chest");
		this.arm_left = root.getChild("arm_left");
		this.arm_right = root.getChild("arm_right");
		this.leg_left_boots = root.getChild("leg_left_boots");
		this.leg_right_boots = root.getChild("leg_right_boots");
		this.leg_left_leggings = root.getChild("leg_left_leggings");
		this.leg_right_leggings = root.getChild("leg_right_leggings");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition helmet = partdefinition.addOrReplaceChild("helmet",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.7F)).texOffs(0, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.26F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest = partdefinition.addOrReplaceChild("chest",
				CubeListBuilder.create().texOffs(34, 69)
						.addBox(-4.5F, 2.0F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.25F)).texOffs(0, 64)
						.addBox(-2.0F, 11.0F, -3.0F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(33, 0)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm_left = partdefinition.addOrReplaceChild("arm_left",
				CubeListBuilder.create().texOffs(37, 58)
						.addBox(0.0F, -3.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(24, 67)
						.addBox(0.0F, -5.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 35)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(0, 52)
						.addBox(0.5F, 5.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition arm_right = partdefinition.addOrReplaceChild("arm_right", CubeListBuilder.create()
				.texOffs(37, 58).mirror().addBox(-5.0F, -3.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(24, 67).mirror()
				.addBox(-2.0F, -5.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 35)
				.mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false)
				.texOffs(0, 52).mirror().addBox(-3.5F, 5.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition leg_left_boots = partdefinition.addOrReplaceChild("leg_left_boots",
				CubeListBuilder.create().texOffs(17, 41)
						.addBox(-2.5F, 7.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.26F)).texOffs(24, 33)
						.addBox(-2.0F, 5.0F, -3.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition leg_right_boots = partdefinition.addOrReplaceChild("leg_right_boots",
				CubeListBuilder.create().texOffs(17, 41).mirror()
						.addBox(-2.5F, 7.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.26F)).mirror(false)
						.texOffs(13, 33).addBox(-2.0F, 5.0F, -3.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition leg_left_leggings = partdefinition.addOrReplaceChild("leg_left_leggings",
				CubeListBuilder.create().texOffs(60, 57)
						.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)).texOffs(58, 0)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition leg_right_leggings = partdefinition.addOrReplaceChild("leg_right_leggings",
				CubeListBuilder.create().texOffs(60, 57).mirror()
						.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)).mirror(false)
						.texOffs(58, 0).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 80);
	}
	
	public void translateToHand(HumanoidArm arm, PoseStack pose) {
		if (arm == HumanoidArm.RIGHT) {
			this.arm_right.translateAndRotate(pose);
		} else {
			this.arm_left.translateAndRotate(pose);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		helmet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left_boots.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right_boots.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left_leggings.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right_leggings.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}