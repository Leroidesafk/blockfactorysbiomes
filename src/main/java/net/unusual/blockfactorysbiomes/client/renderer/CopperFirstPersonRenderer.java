package net.unusual.blockfactorysbiomes.client.renderer;

import net.unusual.blockfactorysbiomes.init.BfBiomesModItems;
import net.unusual.blockfactorysbiomes.client.model.Modelcopper_armor;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderArmEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.Minecraft;

@EventBusSubscriber(value = Dist.CLIENT)
public class CopperFirstPersonRenderer {
	private static final ResourceLocation ARMOR_LOCATION = new ResourceLocation("bf_biomes:textures/entities/copper_armor.png");
	private static boolean rendererActive = false;

	public static void clientTick() {
		Minecraft mc = Minecraft.getInstance();
		rendererActive = mc.player != null && (BfBiomesModItems.COPPER_CHESTPLATE.get() == mc.player.getItemBySlot(EquipmentSlot.CHEST).getItem());
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onRenderPlayerHand(RenderArmEvent event) {
		if (!rendererActive)
			return;
		Minecraft mc = Minecraft.getInstance();
		LocalPlayer player = mc.player;
		MultiBufferSource buffer = event.getMultiBufferSource();
		if (!(mc.getEntityRenderDispatcher().getRenderer(player) instanceof PlayerRenderer pr))
			return;
		Modelcopper_armor model = new Modelcopper_armor(Minecraft.getInstance().getEntityModels().bakeLayer(Modelcopper_armor.LAYER_LOCATION));
		pr.getModel().copyPropertiesTo(model);
		model.setupAnim(player, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		ModelPart armPart = event.getArm() == HumanoidArm.LEFT ? model.arm_left : model.arm_right;
		armPart.xRot = 0.0F;
		armPart.render(event.getPoseStack(), buffer.getBuffer(RenderType.entityCutoutNoCull(ARMOR_LOCATION)), event.getPackedLight(), OverlayTexture.NO_OVERLAY);
		event.setCanceled(true);
	}
}
