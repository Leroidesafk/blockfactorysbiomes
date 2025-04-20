package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class FogBiomeRendererProcedure {
	public static ViewportEvent.ComputeFogColor provider = null;

	public static void setColor(float level, int color) {
		if (level <= 0.0F)
			return;
		if (level >= 1.0F) {
			provider.setRed((color >> 16 & 255) / 255.0F);
			provider.setGreen((color >> 8 & 255) / 255.0F);
			provider.setBlue((color & 255) / 255.0F);
		} else {
			level = Mth.clamp(level, 0.0F, 1.0F);
			provider.setRed(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getRed(), 0.0F, 1.0F), (color >> 16 & 255) / 255.0F), 0.0F, 1.0F));
			provider.setGreen(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getGreen(), 0.0F, 1.0F), (color >> 8 & 255) / 255.0F), 0.0F, 1.0F));
			provider.setBlue(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getBlue(), 0.0F, 1.0F), (color & 255) / 255.0F), 0.0F, 1.0F));
		}
	}

	@SubscribeEvent
	public static void computeFogColor(ViewportEvent.ComputeFogColor event) {
		provider = event;
		ClientLevel level = Minecraft.getInstance().level;
		Entity entity = provider.getCamera().getEntity();
		if (level != null && entity != null) {
			Vec3 entPos = entity.getPosition((float) provider.getPartialTick());
			execute(provider, level, entPos.x(), entPos.y(), entPos.z());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("bf_biomes:baobab_forest"))) {
			setColor((float) 0.5, 255 << 24 | 201 << 16 | 129 << 8 | 44);
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("bf_biomes:maple_forest"))) {
			setColor((float) 0.5, 255 << 24 | 255 << 16 | 197 << 8 | 181);
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("beach"))) {
			setColor((float) 0.5, 255 << 24 | 183 << 16 | 85 << 8 | 10);
		}
	}
}
