package net.unusual.blockfactorysbiomes.client.model;

import net.unusual.blockfactorysbiomes.entity.CrabEntity;
import net.unusual.blockfactorysbiomes.client.animation.crabAnimation;

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

// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelcrab<T extends CrabEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("blockfactorys_biomes", "modelcrab"), "main");
	public final ModelPart all;
	public final ModelPart root;
	public final ModelPart right_front_leg;
	public final ModelPart left_back_leg;
	public final ModelPart left_front_leg;
	public final ModelPart right_back_leg;
	public final ModelPart head;
	public final ModelPart left_eye;
	public final ModelPart right_eye;
	public final ModelPart left_claw;
	public final ModelPart right_claw;

	public Modelcrab(ModelPart root) {
		this.all = root.getChild("all");
		this.root = this.all.getChild("root");
		this.right_front_leg = this.root.getChild("right_front_leg");
		this.left_back_leg = this.root.getChild("left_back_leg");
		this.left_front_leg = this.root.getChild("left_front_leg");
		this.right_back_leg = this.root.getChild("right_back_leg");
		this.head = this.root.getChild("head");
		this.left_eye = this.head.getChild("left_eye");
		this.right_eye = this.head.getChild("right_eye");
		this.left_claw = this.head.getChild("left_claw");
		this.right_claw = this.head.getChild("right_claw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 1.0F));
		PartDefinition root = all.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition right_front_leg = root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(23, 0).addBox(-5.0F, -0.5F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -0.5F, -1.0F));
		PartDefinition left_back_leg = root.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(0.0F, -0.5F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(4.0F, -0.5F, 3.0F));
		PartDefinition left_front_leg = root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(0.0F, -0.5F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(4.0F, -0.5F, -1.0F));
		PartDefinition right_back_leg = root.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(23, 0).addBox(-5.0F, -0.5F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -0.5F, 3.0F));
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -3.5F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -0.5F));
		PartDefinition left_eye = head.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(2, 0).addBox(0.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -4.0F, -1.5F));
		PartDefinition right_eye = head.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -4.0F, -1.5F));
		PartDefinition left_claw = head.addOrReplaceChild("left_claw", CubeListBuilder.create().texOffs(12, 16).addBox(0.0F, -2.5F, -6.0F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -2.5F, -3.5F));
		PartDefinition right_claw = head.addOrReplaceChild("right_claw", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -2.5F, -6.0F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -2.5F, -3.5F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.idleAnimationState, crabAnimation.IDLE, ageInTicks);
		if (!entity.getEntityData().get(CrabEntity.DATA_attack_side)) {
			this.animate(entity.attackAnimationState, crabAnimation.ATTACK_2, ageInTicks);
		} else {
			this.animate(entity.attackAnimationState, crabAnimation.ATTACK_1, ageInTicks);
		}
		this.animateWalk(crabAnimation.WALK, limbSwing, limbSwingAmount, 2.5F, 4.0F);
	}

	@Override
	public ModelPart root() {
		return this.all;
	}

	private record ModelParts(ModelPart all) {
	}
}
