
package net.mcreator.cristiansmaster.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.cristiansmaster.CristianSMasterMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record OpenBackpackMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<OpenBackpackMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CristianSMasterMod.MODID, "key_open_backpack"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenBackpackMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenBackpackMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenBackpackMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenBackpackMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenBackpackMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CristianSMasterMod.addNetworkMessage(OpenBackpackMessage.TYPE, OpenBackpackMessage.STREAM_CODEC, OpenBackpackMessage::handleData);
	}
}
