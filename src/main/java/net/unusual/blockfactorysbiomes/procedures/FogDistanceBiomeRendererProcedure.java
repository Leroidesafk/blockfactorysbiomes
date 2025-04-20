package net.unusual.blockfactorysbiomes.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class FogDistanceBiomeRendererProcedure {
	public static ViewportEvent.RenderFog provider = null;

	public static void setDistance(float start, float end) {
		provider.setNearPlaneDistance(start);
		provider.setFarPlaneDistance(end);
		if (!provider.isCanceled()) {
			provider.setCanceled(true);
		}
	}

	public static void setShape(FogShape shape) {
		provider.setFogShape(shape);
		if (!provider.isCanceled()) {
			provider.setCanceled(true);
		}
	}

	@SubscribeEvent
	public static void renderFog(ViewportEvent.RenderFog event) {
		provider = event;
		if (provider.getMode() == FogRenderer.FogMode.FOG_TERRAIN) {
			ClientLevel level = Minecraft.getInstance().level;
			Entity entity = provider.getCamera().getEntity();
			if (level != null && entity != null) {
				Vec3 pos = entity.getPosition((float) provider.getPartialTick());
				execute(provider, level, pos.x(), pos.y(), pos.z(), provider.getFarPlaneDistance());
			}
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, double end) {
		execute(null, world, x, y, z, end);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, double end) {
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("bf_biomes:baobab_forest"))) {
			setDistance(0, (float) end);
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("bf_biomes:maple_forest"))) {
			setDistance(3, (float) end);
		}
	}
}
