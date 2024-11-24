package net.mcreator.cristiansmaster.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.HolderLookup;

import net.mcreator.cristiansmaster.CristianSMasterMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CristianSMasterModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, CristianSMasterMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());
	public static double CloakingCooldown = 0.0;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		CristianSMasterMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		CristianSMasterMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.savingBackpackContent = original.savingBackpackContent;
			if (!event.isWasDeath()) {
				clone.slot0 = original.slot0;
				clone.slot1 = original.slot1;
				clone.slot2 = original.slot2;
				clone.slot3 = original.slot3;
				clone.slot4 = original.slot4;
				clone.slot5 = original.slot5;
				clone.slot6 = original.slot6;
				clone.slot7 = original.slot7;
				clone.slot8 = original.slot8;
				clone.slot9 = original.slot9;
				clone.bwPosX = original.bwPosX;
				clone.bwPosY = original.bwPosY;
				clone.bwPosZ = original.bwPosZ;
				clone.bw2PosX = original.bw2PosX;
				clone.bw2PosY = original.bw2PosY;
				clone.bw2PosZ = original.bw2PosZ;
				clone.bwFirstPos = original.bwFirstPos;
				clone.bwSecondPos = original.bwSecondPos;
				clone.selectedBlock = original.selectedBlock;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "cristian_s_master_worldvars";

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "cristian_s_master_mapvars";
		public double i = 0;
		public double usageCounter = 0;
		public double Mana = 100.0;
		public boolean hasGrimoireBeenUsed = false;
		public double hasPhoenixFeatherBeenUsed = 0;
		public double tpPosX = 0;
		public double tpPosY = 0;
		public double tpPosZ = 0;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			i = nbt.getDouble("i");
			usageCounter = nbt.getDouble("usageCounter");
			Mana = nbt.getDouble("Mana");
			hasGrimoireBeenUsed = nbt.getBoolean("hasGrimoireBeenUsed");
			hasPhoenixFeatherBeenUsed = nbt.getDouble("hasPhoenixFeatherBeenUsed");
			tpPosX = nbt.getDouble("tpPosX");
			tpPosY = nbt.getDouble("tpPosY");
			tpPosZ = nbt.getDouble("tpPosZ");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("i", i);
			nbt.putDouble("usageCounter", usageCounter);
			nbt.putDouble("Mana", Mana);
			nbt.putBoolean("hasGrimoireBeenUsed", hasGrimoireBeenUsed);
			nbt.putDouble("hasPhoenixFeatherBeenUsed", hasPhoenixFeatherBeenUsed);
			nbt.putDouble("tpPosX", tpPosX);
			nbt.putDouble("tpPosY", tpPosY);
			nbt.putDouble("tpPosZ", tpPosZ);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CristianSMasterMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public boolean savingBackpackContent = true;
		public ItemStack slot0 = ItemStack.EMPTY;
		public ItemStack slot1 = ItemStack.EMPTY;
		public ItemStack slot2 = ItemStack.EMPTY;
		public ItemStack slot3 = ItemStack.EMPTY;
		public ItemStack slot4 = ItemStack.EMPTY;
		public ItemStack slot5 = ItemStack.EMPTY;
		public ItemStack slot6 = ItemStack.EMPTY;
		public ItemStack slot7 = ItemStack.EMPTY;
		public ItemStack slot8 = ItemStack.EMPTY;
		public ItemStack slot9 = ItemStack.EMPTY;
		public double bwPosX = 0;
		public double bwPosY = 0;
		public double bwPosZ = 0;
		public double bw2PosX = 0;
		public double bw2PosY = 0;
		public double bw2PosZ = 0;
		public boolean bwFirstPos = false;
		public boolean bwSecondPos = false;
		public BlockState selectedBlock = Blocks.AIR.defaultBlockState();

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("savingBackpackContent", savingBackpackContent);
			nbt.put("slot0", slot0.saveOptional(lookupProvider));
			nbt.put("slot1", slot1.saveOptional(lookupProvider));
			nbt.put("slot2", slot2.saveOptional(lookupProvider));
			nbt.put("slot3", slot3.saveOptional(lookupProvider));
			nbt.put("slot4", slot4.saveOptional(lookupProvider));
			nbt.put("slot5", slot5.saveOptional(lookupProvider));
			nbt.put("slot6", slot6.saveOptional(lookupProvider));
			nbt.put("slot7", slot7.saveOptional(lookupProvider));
			nbt.put("slot8", slot8.saveOptional(lookupProvider));
			nbt.put("slot9", slot9.saveOptional(lookupProvider));
			nbt.putDouble("bwPosX", bwPosX);
			nbt.putDouble("bwPosY", bwPosY);
			nbt.putDouble("bwPosZ", bwPosZ);
			nbt.putDouble("bw2PosX", bw2PosX);
			nbt.putDouble("bw2PosY", bw2PosY);
			nbt.putDouble("bw2PosZ", bw2PosZ);
			nbt.putBoolean("bwFirstPos", bwFirstPos);
			nbt.putBoolean("bwSecondPos", bwSecondPos);
			nbt.put("selectedBlock", NbtUtils.writeBlockState(selectedBlock));
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			savingBackpackContent = nbt.getBoolean("savingBackpackContent");
			slot0 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("slot0"));
			slot1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("slot1"));
			slot2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("slot2"));
			slot3 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("slot3"));
			slot4 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("slot4"));
			slot5 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("slot5"));
			slot6 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("slot6"));
			slot7 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("slot7"));
			slot8 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("slot8"));
			slot9 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("slot9"));
			bwPosX = nbt.getDouble("bwPosX");
			bwPosY = nbt.getDouble("bwPosY");
			bwPosZ = nbt.getDouble("bwPosZ");
			bw2PosX = nbt.getDouble("bw2PosX");
			bw2PosY = nbt.getDouble("bw2PosY");
			bw2PosZ = nbt.getDouble("bw2PosZ");
			bwFirstPos = nbt.getBoolean("bwFirstPos");
			bwSecondPos = nbt.getBoolean("bwSecondPos");
			selectedBlock = NbtUtils.readBlockState(lookupProvider.lookupOrThrow(BuiltInRegistries.BLOCK.key()), nbt.getCompound("selectedBlock"));
		}

		public void syncPlayerVariables(Entity entity) {
			if (!entity.level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(entity.level().players())) {
					if (entityiterator instanceof ServerPlayer serverPlayer)
						PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this, entity.getId()));
				}
			}
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data, int target) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CristianSMasterMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess()));
			buffer.writeInt(message.target()); // Write the entity ID to the buffer
		}, (RegistryFriendlyByteBuf buffer) -> {
			var nbt = buffer.readNbt();
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables(), buffer.readInt());
			message.data.deserializeNBT(buffer.registryAccess(), nbt);
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().level().getEntity(message.target()).getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess())))
						.exceptionally(e -> {
							context.connection().disconnect(Component.literal(e.getMessage()));
							return null;
						});
			}
		}
	}
}
