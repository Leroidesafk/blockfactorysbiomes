package net.unusual.blockfactorysbiomes.client.model;

import net.unusual.blockfactorysbiomes.entity.SquirrelEntity;
import net.unusual.blockfactorysbiomes.client.animation.squirrelAnimation;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.HierarchicalModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelsquirrel<T extends SquirrelEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("bf_biomes", "modelsquirrel"), "main");
	public final ModelPart all;
	public final ModelPart body;
	public final ModelPart right_leg;
	public final ModelPart left_leg;
	public final ModelPart torso;
	public final ModelPart left_arm;
	public final ModelPart right_arm;
	public final ModelPart tail;
	public final ModelPart head_orbit;
	public final ModelPart head;

	public Modelsquirrel(ModelPart root) {
		this.all = root.getChild("all");
		this.body = this.all.getChild("body");
		this.right_leg = this.body.getChild("right_leg");
		this.left_leg = this.body.getChild("left_leg");
		this.torso = this.body.getChild("torso");
		this.left_arm = this.torso.getChild("left_arm");
		this.right_arm = this.torso.getChild("right_arm");
		this.tail = this.torso.getChild("tail");
		this.head_orbit = this.torso.getChild("head_orbit");
		this.head = this.head_orbit.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition body = all.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(15, 14).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -4.0F, 2.5F));
		PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(22, 18).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -4.0F, 2.5F));
		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -5.0F, -8.0F, 6.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 2.0F));
		PartDefinition left_arm = torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(22, 25).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -6.0F));
		PartDefinition right_arm = torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -6.0F));
		PartDefinition tail = torso.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -11.0F, 0.0F, 4.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -2.0F));
		PartDefinition head_orbit = torso.addOrReplaceChild("head_orbit", CubeListBuilder.create(), PartPose.offset(0.0F, -4.1F, -6.25F));
		PartDefinition head = head_orbit.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, 2.0F, -4.9F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition head_r1 = head.addOrReplaceChild("head_r1",
				CubeListBuilder.create().texOffs(0, 5).addBox(-3.0F, -3.75F, -0.75F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(4, 5).addBox(1.0F, -3.75F, -0.75F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.15F, -1.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition head_r2 = head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(21, 0).addBox(-2.0F, -2.0F, -2.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.3249F, -3.1213F, 0.7854F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);

		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.animate(entity.idleAnimationState, squirrelAnimation.IDLE, ageInTicks);
		this.animate(entity.climbAnimationState, squirrelAnimation.CLIMB, ageInTicks);
		if (!entity.getEntityData().get(entity.DATA_is_climbing)) {
			if (entity.isBaby())
				this.animateWalk(squirrelAnimation.RUN, limbSwing, limbSwingAmount, 1.25F, 2.0F);
			if (!entity.isBaby())
				this.animateWalk(squirrelAnimation.RUN, limbSwing, limbSwingAmount, 2.5F, 4.0F);
		}
	}

	@Override
	public ModelPart root() {
		return this.all;
	}

	private record ModelParts(ModelPart all) {
	}
}
