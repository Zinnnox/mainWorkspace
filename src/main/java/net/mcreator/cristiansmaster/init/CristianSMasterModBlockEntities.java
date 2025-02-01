
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cristiansmaster.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.cristiansmaster.block.entity.SimpleFuelCartBlockEntity;
import net.mcreator.cristiansmaster.block.entity.SimpleDrillCartBlockEntity;
import net.mcreator.cristiansmaster.block.entity.SimpleCargoCartBlockEntity;
import net.mcreator.cristiansmaster.block.entity.FuelCartBlockEntity;
import net.mcreator.cristiansmaster.block.entity.DrillCartBlockEntity;
import net.mcreator.cristiansmaster.block.entity.CargoCartBlockEntity;
import net.mcreator.cristiansmaster.CristianSMasterMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CristianSMasterModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CristianSMasterMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DRILL_CART = register("drill_cart", CristianSMasterModBlocks.DRILL_CART, DrillCartBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CARGO_CART = register("cargo_cart", CristianSMasterModBlocks.CARGO_CART, CargoCartBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FUEL_CART = register("fuel_cart", CristianSMasterModBlocks.FUEL_CART, FuelCartBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SIMPLE_DRILL_CART = register("simple_drill_cart", CristianSMasterModBlocks.SIMPLE_DRILL_CART, SimpleDrillCartBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SIMPLE_CARGO_CART = register("simple_cargo_cart", CristianSMasterModBlocks.SIMPLE_CARGO_CART, SimpleCargoCartBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SIMPLE_FUEL_CART = register("simple_fuel_cart", CristianSMasterModBlocks.SIMPLE_FUEL_CART, SimpleFuelCartBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DRILL_CART.get(), (blockEntity, side) -> ((DrillCartBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CARGO_CART.get(), (blockEntity, side) -> ((CargoCartBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FUEL_CART.get(), (blockEntity, side) -> ((FuelCartBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SIMPLE_DRILL_CART.get(), (blockEntity, side) -> ((SimpleDrillCartBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SIMPLE_CARGO_CART.get(), (blockEntity, side) -> ((SimpleCargoCartBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SIMPLE_FUEL_CART.get(), (blockEntity, side) -> ((SimpleFuelCartBlockEntity) blockEntity).getItemHandler());
	}
}
