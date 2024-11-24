
package net.mcreator.cristiansmaster.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.cristiansmaster.procedures.KeyPressedSpaceOnKeyReleasedProcedure;
import net.mcreator.cristiansmaster.procedures.KeyPressedSpaceOnKeyPressedProcedure;
import net.mcreator.cristiansmaster.CristianSMasterMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record KeyPressedSpaceMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<KeyPressedSpaceMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CristianSMasterMod.MODID, "key_key_pressed_space"));
	public static final StreamCodec<RegistryFriendlyByteBuf, KeyPressedSpaceMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, KeyPressedSpaceMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new KeyPressedSpaceMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<KeyPressedSpaceMessage> type() {
		return TYPE;
	}

	public static void handleData(final KeyPressedSpaceMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			KeyPressedSpaceOnKeyPressedProcedure.execute(world);
		}
		if (type == 1) {

			KeyPressedSpaceOnKeyReleasedProcedure.execute(world);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CristianSMasterMod.addNetworkMessage(KeyPressedSpaceMessage.TYPE, KeyPressedSpaceMessage.STREAM_CODEC, KeyPressedSpaceMessage::handleData);
	}
}
