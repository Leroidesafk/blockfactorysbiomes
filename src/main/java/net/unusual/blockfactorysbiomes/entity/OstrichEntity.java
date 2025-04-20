
package net.unusual.blockfactorysbiomes.entity;

import net.unusual.blockfactorysbiomes.procedures.OstrichRightClickedOnEntityProcedure;
import net.unusual.blockfactorysbiomes.procedures.OstrichOnEntityTickUpdateProcedure;
import net.unusual.blockfactorysbiomes.procedures.OstrichMoveConditionProcedure;
import net.unusual.blockfactorysbiomes.init.BfBiomesModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
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
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
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

public class OstrichEntity extends Animal {
	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState hideAnimationState = new AnimationState();
	public final AnimationState layAnimationState = new AnimationState();
	public static final EntityDataAccessor<Boolean> DATA_has_saddle = SynchedEntityData.defineId(OstrichEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_hide_cooldown = SynchedEntityData.defineId(OstrichEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_hide_animtime = SynchedEntityData.defineId(OstrichEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_lay_egg_cooldown = SynchedEntityData.defineId(OstrichEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_lay_egg_animtime = SynchedEntityData.defineId(OstrichEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_is_hiding = SynchedEntityData.defineId(OstrichEntity.class, EntityDataSerializers.BOOLEAN);

	public OstrichEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(BfBiomesModEntities.OSTRICH.get(), world);
	}

	public OstrichEntity(EntityType<OstrichEntity> type, Level world) {
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
		this.entityData.define(DATA_has_saddle, false);
		this.entityData.define(DATA_hide_cooldown, 0);
		this.entityData.define(DATA_hide_animtime, 0);
		this.entityData.define(DATA_lay_egg_cooldown, 0);
		this.entityData.define(DATA_lay_egg_animtime, 0);
		this.entityData.define(DATA_is_hiding, false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new BreedGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canUse() && OstrichMoveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canContinueToUse() && OstrichMoveConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new TemptGoal(this, 1, Ingredient.of(Items.WHEAT_SEEDS), false) {
			@Override
			public boolean canUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canUse() && OstrichMoveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canContinueToUse() && OstrichMoveConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new TemptGoal(this, 1, Ingredient.of(Items.PUMPKIN_SEEDS), false) {
			@Override
			public boolean canUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canUse() && OstrichMoveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canContinueToUse() && OstrichMoveConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(4, new TemptGoal(this, 1, Ingredient.of(Items.MELON_SEEDS), false) {
			@Override
			public boolean canUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canUse() && OstrichMoveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canContinueToUse() && OstrichMoveConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new TemptGoal(this, 1, Ingredient.of(Items.BEETROOT_SEEDS), false) {
			@Override
			public boolean canUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canUse() && OstrichMoveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canContinueToUse() && OstrichMoveConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canUse() && OstrichMoveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canContinueToUse() && OstrichMoveConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canUse() && OstrichMoveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canContinueToUse() && OstrichMoveConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(8, new FloatGoal(this) {
			@Override
			public boolean canUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canUse() && OstrichMoveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OstrichEntity.this.getX();
				double y = OstrichEntity.this.getY();
				double z = OstrichEntity.this.getZ();
				Entity entity = OstrichEntity.this;
				Level world = OstrichEntity.this.level();
				return super.canContinueToUse() && OstrichMoveConditionProcedure.execute(entity);
			}
		});
	}

	@Override
	public void tick() {
		if (level().isClientSide) {
			this.idleAnimationState.animateWhen((true), this.tickCount);
			this.layAnimationState.animateWhen((this.getEntityData().get(this.DATA_lay_egg_animtime) > 0), this.tickCount);
			this.hideAnimationState.animateWhen((this.getEntityData().get(this.DATA_hide_animtime) > 0), this.tickCount);
		}
		super.tick();
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public double getPassengersRidingOffset() {
		if (super.walkAnimation.isMoving())
			return super.getPassengersRidingOffset() - 0.1;
		return super.getPassengersRidingOffset() + 0.2;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bf_biomes:ostrich_squeak"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bf_biomes:ostrich_walk")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.chicken.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.FALL))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("Datahas_saddle", this.entityData.get(DATA_has_saddle));
		compound.putInt("Datahide_cooldown", this.entityData.get(DATA_hide_cooldown));
		compound.putInt("Datahide_animtime", this.entityData.get(DATA_hide_animtime));
		compound.putInt("Datalay_egg_cooldown", this.entityData.get(DATA_lay_egg_cooldown));
		compound.putInt("Datalay_egg_animtime", this.entityData.get(DATA_lay_egg_animtime));
		compound.putBoolean("Datais_hiding", this.entityData.get(DATA_is_hiding));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datahas_saddle"))
			this.entityData.set(DATA_has_saddle, compound.getBoolean("Datahas_saddle"));
		if (compound.contains("Datahide_cooldown"))
			this.entityData.set(DATA_hide_cooldown, compound.getInt("Datahide_cooldown"));
		if (compound.contains("Datahide_animtime"))
			this.entityData.set(DATA_hide_animtime, compound.getInt("Datahide_animtime"));
		if (compound.contains("Datalay_egg_cooldown"))
			this.entityData.set(DATA_lay_egg_cooldown, compound.getInt("Datalay_egg_cooldown"));
		if (compound.contains("Datalay_egg_animtime"))
			this.entityData.set(DATA_lay_egg_animtime, compound.getInt("Datalay_egg_animtime"));
		if (compound.contains("Datais_hiding"))
			this.entityData.set(DATA_is_hiding, compound.getBoolean("Datais_hiding"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();
		if (OstrichRightClickedOnEntityProcedure.execute(entity, sourceentity))
			return retval;
		return InteractionResult.PASS;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		OstrichOnEntityTickUpdateProcedure.execute(this.level(), this);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		OstrichEntity retval = BfBiomesModEntities.OSTRICH.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(new ItemStack(Items.WHEAT_SEEDS), new ItemStack(Items.PUMPKIN_SEEDS), new ItemStack(Items.MELON_SEEDS), new ItemStack(Items.BEETROOT_SEEDS)).test(stack);
	}

	@Override
	public void travel(Vec3 dir) {
		Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
		if (this.isVehicle()) {
			this.setYRot(entity.getYRot());
			this.yRotO = this.getYRot();
			this.setXRot(entity.getXRot() * 0.5F);
			this.setRot(this.getYRot(), this.getXRot());
			this.yBodyRot = entity.getYRot();
			this.yHeadRot = entity.getYRot();
			if (entity instanceof LivingEntity passenger) {
				this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
				float forward = passenger.zza;
				float strafe = passenger.xxa;
				super.travel(new Vec3(strafe, 0, forward));
			}
			double d1 = this.getX() - this.xo;
			double d0 = this.getZ() - this.zo;
			float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4;
			if (f1 > 1.0F)
				f1 = 1.0F;
			this.walkAnimation.setSpeed(this.walkAnimation.speed() + (f1 - this.walkAnimation.speed()) * 0.4F);
			this.walkAnimation.position(this.walkAnimation.position() + this.walkAnimation.speed());
			this.calculateEntityAnimation(true);
			return;
		}
		super.travel(dir);
	}

	public static void init() {
		SpawnPlacements.register(BfBiomesModEntities.OSTRICH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 26);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
