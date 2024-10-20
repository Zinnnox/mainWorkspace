
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.cristiansmaster.entity.TwocolorEntity;
import net.mcreator.cristiansmaster.entity.TornadoEntity;
import net.mcreator.cristiansmaster.entity.TheBOMBEntity;
import net.mcreator.cristiansmaster.entity.ShootToSpawnPortalEntity;
import net.mcreator.cristiansmaster.entity.PortalprojectileEntity;
import net.mcreator.cristiansmaster.entity.PopEntity;
import net.mcreator.cristiansmaster.entity.OutlineEntity;
import net.mcreator.cristiansmaster.entity.MaryannTheSlimeEntity;
import net.mcreator.cristiansmaster.entity.MagicalDartEntity;
import net.mcreator.cristiansmaster.entity.LightsaberProjectileEntity;
import net.mcreator.cristiansmaster.entity.IroncladEntity;
import net.mcreator.cristiansmaster.entity.IceshardEntity;
import net.mcreator.cristiansmaster.entity.HelloEntity;
import net.mcreator.cristiansmaster.entity.FireballEntity;
import net.mcreator.cristiansmaster.entity.ExplodingProjectileEntity;
import net.mcreator.cristiansmaster.entity.EntityFromSwordProjectileEntity;
import net.mcreator.cristiansmaster.entity.DragonEntity;
import net.mcreator.cristiansmaster.entity.BigGuyEntity;
import net.mcreator.cristiansmaster.CristianSMasterMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CristianSMasterModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, CristianSMasterMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<DragonEntity>> DRAGON = register("dragon",
			EntityType.Builder.<DragonEntity>of(DragonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EntityFromSwordProjectileEntity>> ENTITY_FROM_SWORD_PROJECTILE = register("entity_from_sword_projectile",
			EntityType.Builder.<EntityFromSwordProjectileEntity>of(EntityFromSwordProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ShootToSpawnPortalEntity>> SHOOT_TO_SPAWN_PORTAL = register("shoot_to_spawn_portal",
			EntityType.Builder.<ShootToSpawnPortalEntity>of(ShootToSpawnPortalEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<LightsaberProjectileEntity>> LIGHTSABER_PROJECTILE = register("lightsaber_projectile",
			EntityType.Builder.<LightsaberProjectileEntity>of(LightsaberProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PortalprojectileEntity>> PORTALPROJECTILE = register("portalprojectile",
			EntityType.Builder.<PortalprojectileEntity>of(PortalprojectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MaryannTheSlimeEntity>> MARYANN_THE_SLIME = register("maryann_the_slime",
			EntityType.Builder.<MaryannTheSlimeEntity>of(MaryannTheSlimeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<HelloEntity>> HELLO = register("hello",
			EntityType.Builder.<HelloEntity>of(HelloEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<IceshardEntity>> ICESHARD = register("iceshard",
			EntityType.Builder.<IceshardEntity>of(IceshardEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FireballEntity>> FIREBALL = register("fireball",
			EntityType.Builder.<FireballEntity>of(FireballEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<IroncladEntity>> IRONCLAD = register("ironclad",
			EntityType.Builder.<IroncladEntity>of(IroncladEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MagicalDartEntity>> MAGICAL_DART = register("magical_dart",
			EntityType.Builder.<MagicalDartEntity>of(MagicalDartEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<TornadoEntity>> TORNADO = register("tornado",
			EntityType.Builder.<TornadoEntity>of(TornadoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ExplodingProjectileEntity>> EXPLODING_PROJECTILE = register("exploding_projectile",
			EntityType.Builder.<ExplodingProjectileEntity>of(ExplodingProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<TheBOMBEntity>> THE_BOMB = register("the_bomb",
			EntityType.Builder.<TheBOMBEntity>of(TheBOMBEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PopEntity>> POP = register("pop", EntityType.Builder.<PopEntity>of(PopEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BigGuyEntity>> BIG_GUY = register("big_guy",
			EntityType.Builder.<BigGuyEntity>of(BigGuyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<OutlineEntity>> OUTLINE = register("outline",
			EntityType.Builder.<OutlineEntity>of(OutlineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<TwocolorEntity>> TWOCOLOR = register("twocolor",
			EntityType.Builder.<TwocolorEntity>of(TwocolorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(SpawnPlacementRegisterEvent event) {
		DragonEntity.init(event);
		MaryannTheSlimeEntity.init(event);
		HelloEntity.init(event);
		IroncladEntity.init(event);
		TornadoEntity.init(event);
		PopEntity.init(event);
		BigGuyEntity.init(event);
		OutlineEntity.init(event);
		TwocolorEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(DRAGON.get(), DragonEntity.createAttributes().build());
		event.put(MARYANN_THE_SLIME.get(), MaryannTheSlimeEntity.createAttributes().build());
		event.put(HELLO.get(), HelloEntity.createAttributes().build());
		event.put(IRONCLAD.get(), IroncladEntity.createAttributes().build());
		event.put(TORNADO.get(), TornadoEntity.createAttributes().build());
		event.put(POP.get(), PopEntity.createAttributes().build());
		event.put(BIG_GUY.get(), BigGuyEntity.createAttributes().build());
		event.put(OUTLINE.get(), OutlineEntity.createAttributes().build());
		event.put(TWOCOLOR.get(), TwocolorEntity.createAttributes().build());
	}
}
