
package net.unusual.blockfactorysbiomes.entity;

import net.unusual.blockfactorysbiomes.procedures.FireflyOnEntityTickUpdateProcedure;
import net.unusual.blockfactorysbiomes.procedures.FireflyNaturalEntitySpawningConditionProcedure;
import net.unusual.blockfactorysbiomes.init.BfBiomesModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

public class FireflyEntity extends Animal {
	public final AnimationState idleAnimationState = new AnimationState();

	public FireflyEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(BfBiomesModEntities.FIREFLY.get(), world);
	}

	public FireflyEntity(EntityType<FireflyEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 0;
		setNoAi(false);
		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new BreathAirGoal(this));
		this.goalSelector.addGoal(2, new FollowParentGoal(this, 0.8));
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = FireflyEntity.this.getRandom();
				double dir_x = FireflyEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = FireflyEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = FireflyEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float) 0.5));
	}

	@Override
	public void tick() {
		if (level().isClientSide) {
			this.idleAnimationState.animateWhen((true), this.tickCount);
		}
		super.tick();
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bf_biomes:firefly_flying"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bee.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bee.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.FALL))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		FireflyOnEntityTickUpdateProcedure.execute(this);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		FireflyEntity retval = BfBiomesModEntities.FIREFLY.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(new ItemStack(Blocks.DANDELION)).test(stack);
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
	}

	public static void init() {
		SpawnPlacements.register(BfBiomesModEntities.FIREFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return FireflyNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		});
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 2);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.FLYING_SPEED, 0.3);
		return builder;
	}
}
