
package net.unusual.blockfactorysbiomes.entity;

import net.unusual.blockfactorysbiomes.procedures.SquirrelOnEntityTickUpdateProcedure;
import net.unusual.blockfactorysbiomes.procedures.SquirrelEntityIsHurtProcedure;
import net.unusual.blockfactorysbiomes.procedures.SquirrelDoNotLookProcedure;
import net.unusual.blockfactorysbiomes.init.BfBiomesModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class SquirrelEntity extends Animal {
	public final AnimationState climbAnimationState = new AnimationState();
	public final AnimationState idleAnimationState = new AnimationState();
	public static final EntityDataAccessor<Integer> DATA_climb_cooldown = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_x_target = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_y_target = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_z_target = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_is_climbing = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_can_start_climbing = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> DATA_climb_direction = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.STRING);

	public SquirrelEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(BfBiomesModEntities.SQUIRREL.get(), world);
	}

	public SquirrelEntity(EntityType<SquirrelEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(1.2f);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_climb_cooldown, 0);
		this.entityData.define(DATA_x_target, 0);
		this.entityData.define(DATA_y_target, 0);
		this.entityData.define(DATA_z_target, 0);
		this.entityData.define(DATA_is_climbing, false);
		this.entityData.define(DATA_can_start_climbing, false);
		this.entityData.define(DATA_climb_direction, "");
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new BreedGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = SquirrelEntity.this.getX();
				double y = SquirrelEntity.this.getY();
				double z = SquirrelEntity.this.getZ();
				Entity entity = SquirrelEntity.this;
				Level world = SquirrelEntity.this.level();
				return super.canUse() && SquirrelDoNotLookProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SquirrelEntity.this.getX();
				double y = SquirrelEntity.this.getY();
				double z = SquirrelEntity.this.getZ();
				Entity entity = SquirrelEntity.this;
				Level world = SquirrelEntity.this.level();
				return super.canContinueToUse() && SquirrelDoNotLookProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}

			@Override
			public boolean canUse() {
				double x = SquirrelEntity.this.getX();
				double y = SquirrelEntity.this.getY();
				double z = SquirrelEntity.this.getZ();
				Entity entity = SquirrelEntity.this;
				Level world = SquirrelEntity.this.level();
				return super.canUse() && SquirrelDoNotLookProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SquirrelEntity.this.getX();
				double y = SquirrelEntity.this.getY();
				double z = SquirrelEntity.this.getZ();
				Entity entity = SquirrelEntity.this;
				Level world = SquirrelEntity.this.level();
				return super.canContinueToUse() && SquirrelDoNotLookProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = SquirrelEntity.this.getX();
				double y = SquirrelEntity.this.getY();
				double z = SquirrelEntity.this.getZ();
				Entity entity = SquirrelEntity.this;
				Level world = SquirrelEntity.this.level();
				return super.canUse() && SquirrelDoNotLookProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SquirrelEntity.this.getX();
				double y = SquirrelEntity.this.getY();
				double z = SquirrelEntity.this.getZ();
				Entity entity = SquirrelEntity.this;
				Level world = SquirrelEntity.this.level();
				return super.canContinueToUse() && SquirrelDoNotLookProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = SquirrelEntity.this.getX();
				double y = SquirrelEntity.this.getY();
				double z = SquirrelEntity.this.getZ();
				Entity entity = SquirrelEntity.this;
				Level world = SquirrelEntity.this.level();
				return super.canUse() && SquirrelDoNotLookProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = SquirrelEntity.this.getX();
				double y = SquirrelEntity.this.getY();
				double z = SquirrelEntity.this.getZ();
				Entity entity = SquirrelEntity.this;
				Level world = SquirrelEntity.this.level();
				return super.canContinueToUse() && SquirrelDoNotLookProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float) 0.5));
	}

	@Override
	public void tick() {
		if (level().isClientSide) {
			this.idleAnimationState.animateWhen((true), this.tickCount);
			this.climbAnimationState.animateWhen((this.getEntityData().get(this.DATA_is_climbing)), this.tickCount);
		}
		super.tick();
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bf_biomes:squirrel_ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bf_biomes:squirrel_running")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bf_biomes:squirrel_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bf_biomes:squirrel_hurt"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();
		SquirrelEntityIsHurtProcedure.execute(entity);
		if (damagesource.is(DamageTypes.FALL))
			return super.hurt(damagesource, amount * 0.05f);
		return super.hurt(damagesource, amount);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Dataclimb_cooldown", this.entityData.get(DATA_climb_cooldown));
		compound.putInt("Datax_target", this.entityData.get(DATA_x_target));
		compound.putInt("Datay_target", this.entityData.get(DATA_y_target));
		compound.putInt("Dataz_target", this.entityData.get(DATA_z_target));
		compound.putBoolean("Datais_climbing", this.entityData.get(DATA_is_climbing));
		compound.putBoolean("Datacan_start_climbing", this.entityData.get(DATA_can_start_climbing));
		compound.putString("Dataclimb_direction", this.entityData.get(DATA_climb_direction));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Dataclimb_cooldown"))
			this.entityData.set(DATA_climb_cooldown, compound.getInt("Dataclimb_cooldown"));
		if (compound.contains("Datax_target"))
			this.entityData.set(DATA_x_target, compound.getInt("Datax_target"));
		if (compound.contains("Datay_target"))
			this.entityData.set(DATA_y_target, compound.getInt("Datay_target"));
		if (compound.contains("Dataz_target"))
			this.entityData.set(DATA_z_target, compound.getInt("Dataz_target"));
		if (compound.contains("Datais_climbing"))
			this.entityData.set(DATA_is_climbing, compound.getBoolean("Datais_climbing"));
		if (compound.contains("Datacan_start_climbing"))
			this.entityData.set(DATA_can_start_climbing, compound.getBoolean("Datacan_start_climbing"));
		if (compound.contains("Dataclimb_direction"))
			this.entityData.set(DATA_climb_direction, compound.getString("Dataclimb_direction"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		SquirrelOnEntityTickUpdateProcedure.execute(this.level(), this);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		SquirrelEntity retval = BfBiomesModEntities.SQUIRREL.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(new ItemStack(Items.SPIDER_EYE), new ItemStack(Items.PITCHER_POD)).test(stack);
	}

	public static void init() {
		SpawnPlacements.register(BfBiomesModEntities.SQUIRREL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
