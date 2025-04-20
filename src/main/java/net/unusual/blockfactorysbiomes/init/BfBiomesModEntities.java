
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.unusual.blockfactorysbiomes.init;

import net.unusual.blockfactorysbiomes.entity.SquirrelEntity;
import net.unusual.blockfactorysbiomes.entity.OstrichEntity;
import net.unusual.blockfactorysbiomes.entity.OstrichEggProjectileEntity;
import net.unusual.blockfactorysbiomes.entity.NullPrEntity;
import net.unusual.blockfactorysbiomes.entity.FireflyEntity;
import net.unusual.blockfactorysbiomes.entity.DeerEntity;
import net.unusual.blockfactorysbiomes.entity.CrabEntity;
import net.unusual.blockfactorysbiomes.entity.CoconutProjectileEntity;
import net.unusual.blockfactorysbiomes.entity.ButterflyEntity;
import net.unusual.blockfactorysbiomes.BfBiomesMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BfBiomesModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BfBiomesMod.MODID);
	public static final RegistryObject<EntityType<NullPrEntity>> NULL_PR = register("null_pr",
			EntityType.Builder.<NullPrEntity>of(NullPrEntity::new, MobCategory.MISC).setCustomClientFactory(NullPrEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CrabEntity>> CRAB = register("crab",
			EntityType.Builder.<CrabEntity>of(CrabEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CrabEntity::new)

					.sized(0.7f, 0.4f));
	public static final RegistryObject<EntityType<CoconutProjectileEntity>> COCONUT_PROJECTILE = register("coconut_projectile", EntityType.Builder.<CoconutProjectileEntity>of(CoconutProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(CoconutProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FireflyEntity>> FIREFLY = register("firefly",
			EntityType.Builder.<FireflyEntity>of(FireflyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FireflyEntity::new)

					.sized(0.4f, 0.25f));
	public static final RegistryObject<EntityType<SquirrelEntity>> SQUIRREL = register("squirrel",
			EntityType.Builder.<SquirrelEntity>of(SquirrelEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SquirrelEntity::new)

					.sized(0.5f, 0.65f));
	public static final RegistryObject<EntityType<DeerEntity>> DEER = register("deer",
			EntityType.Builder.<DeerEntity>of(DeerEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DeerEntity::new)

					.sized(0.8f, 1.5f));
	public static final RegistryObject<EntityType<ButterflyEntity>> BUTTERFLY = register("butterfly",
			EntityType.Builder.<ButterflyEntity>of(ButterflyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ButterflyEntity::new)

					.sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<OstrichEggProjectileEntity>> OSTRICH_EGG_PROJECTILE = register("ostrich_egg_projectile", EntityType.Builder.<OstrichEggProjectileEntity>of(OstrichEggProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(OstrichEggProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<OstrichEntity>> OSTRICH = register("ostrich",
			EntityType.Builder.<OstrichEntity>of(OstrichEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OstrichEntity::new)

					.sized(0.9f, 1.9f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			CrabEntity.init();
			FireflyEntity.init();
			SquirrelEntity.init();
			DeerEntity.init();
			ButterflyEntity.init();
			OstrichEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(CRAB.get(), CrabEntity.createAttributes().build());
		event.put(FIREFLY.get(), FireflyEntity.createAttributes().build());
		event.put(SQUIRREL.get(), SquirrelEntity.createAttributes().build());
		event.put(DEER.get(), DeerEntity.createAttributes().build());
		event.put(BUTTERFLY.get(), ButterflyEntity.createAttributes().build());
		event.put(OSTRICH.get(), OstrichEntity.createAttributes().build());
	}
}
