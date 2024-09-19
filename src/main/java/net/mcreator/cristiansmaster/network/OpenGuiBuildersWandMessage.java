
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

import net.mcreator.cristiansmaster.procedures.OpenGuiBuildersWandOnKeyPressedProcedure;
import net.mcreator.cristiansmaster.CristianSMasterMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record OpenGuiBuildersWandMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<OpenGuiBuildersWandMessage> TYPE = new Type<>(new ResourceLocation(CristianSMasterMod.MODID, "key_open_gui_builders_wand"));
	public static final StreamCodec<RegistryFriendlyByteBuf, OpenGuiBuildersWandMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, OpenGuiBuildersWandMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new OpenGuiBuildersWandMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<OpenGuiBuildersWandMessage> type() {
		return TYPE;
	}

	public static void handleData(final OpenGuiBuildersWandMessage message, final IPayloadContext context) {
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

			OpenGuiBuildersWandOnKeyPressedProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CristianSMasterMod.addNetworkMessage(OpenGuiBuildersWandMessage.TYPE, OpenGuiBuildersWandMessage.STREAM_CODEC, OpenGuiBuildersWandMessage::handleData);
	}
}
