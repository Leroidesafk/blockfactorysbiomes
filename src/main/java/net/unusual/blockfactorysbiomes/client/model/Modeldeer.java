package net.unusual.blockfactorysbiomes.client.model;

import net.unusual.blockfactorysbiomes.entity.DeerEntity;
import net.unusual.blockfactorysbiomes.client.animation.deerAnimation;

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
public class Modeldeer<T extends DeerEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("bf_biomes", "modeldeer"), "main");
	public final ModelPart all;
	public final ModelPart cog;
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart back_right_leg;
	public final ModelPart back_left_leg;
	public final ModelPart front_right_leg;
	public final ModelPart front_left_leg;

	public Modeldeer(ModelPart root) {
		this.all = root.getChild("all");
		this.cog = this.all.getChild("cog");
		this.body = this.cog.getChild("body");
		this.head = this.body.getChild("head");
		this.back_right_leg = this.cog.getChild("back_right_leg");
		this.back_left_leg = this.cog.getChild("back_left_leg");
		this.front_right_leg = this.cog.getChild("front_right_leg");
		this.front_left_leg = this.cog.getChild("front_left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(-3.0F, 23.0F, -7.0F));
		PartDefinition cog = all.addOrReplaceChild("cog", CubeListBuilder.create(), PartPose.offset(0.0F, -14.0F, 7.0F));
		PartDefinition body = cog.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -8.5F, 10.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -2.0F, -0.5F));
		PartDefinition head = body.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(34, 27).addBox(-2.0F, -9.0F, -7.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(28, 42).addBox(3.0F, -11.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 42)
						.addBox(-6.0F, -11.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 27).addBox(-3.0F, -12.0F, -3.0F, 6.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 34)
						.addBox(-8.0F, -14.0F, -2.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 42).addBox(7.0F, -18.0F, -2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 42)
						.addBox(-8.0F, -18.0F, -2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 37).addBox(2.0F, -14.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(42, 37)
						.addBox(2.0F, -16.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 34).addBox(4.0F, -14.0F, -2.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 37)
						.addBox(-4.0F, -14.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(42, 37).addBox(-3.0F, -16.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, -8.5F));
		PartDefinition back_right_leg = cog.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(22, 27).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 3.0F, 7.5F));
		PartDefinition back_left_leg = cog.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(22, 27).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, 3.0F, 7.5F));
		PartDefinition front_right_leg = cog.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(22, 27).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 3.0F, -7.5F));
		PartDefinition front_left_leg = cog.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(22, 27).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, 3.0F, -7.5F));
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
		this.animate(entity.idleAnimationState, deerAnimation.IDLE, ageInTicks);
		this.animateWalk(deerAnimation.WALK, limbSwing, limbSwingAmount, 2.5F, 4.0F);
	}

	@Override
	public ModelPart root() {
		return this.all;
	}

	private record ModelParts(ModelPart all) {
	}
}
