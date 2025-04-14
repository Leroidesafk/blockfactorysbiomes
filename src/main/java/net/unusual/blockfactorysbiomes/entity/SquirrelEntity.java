
package net.unusual.blockfactorysbiomes.entity;

import net.unusual.blockfactorysbiomes.procedures.SquirrelOnEntityTickUpdateProcedure;
import net.unusual.blockfactorysbiomes.init.BfBiomesModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class SquirrelEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_climb_cooldown = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_x_target = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_y_target = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_z_target = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_is_climbing = SynchedEntityData.defineId(SquirrelEntity.class, EntityDataSerializers.BOOLEAN);

	public SquirrelEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(BfBiomesModEntities.SQUIRREL.get(), world);
	}

	public SquirrelEntity(EntityType<SquirrelEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
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
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new FloatGoal(this));
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
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
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Dataclimb_cooldown", this.entityData.get(DATA_climb_cooldown));
		compound.putInt("Datax_target", this.entityData.get(DATA_x_target));
		compound.putInt("Datay_target", this.entityData.get(DATA_y_target));
		compound.putInt("Dataz_target", this.entityData.get(DATA_z_target));
		compound.putBoolean("Datais_climbing", this.entityData.get(DATA_is_climbing));
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
	}

	@Override
	public void baseTick() {
		super.baseTick();
		SquirrelOnEntityTickUpdateProcedure.execute(this.level(), this);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
