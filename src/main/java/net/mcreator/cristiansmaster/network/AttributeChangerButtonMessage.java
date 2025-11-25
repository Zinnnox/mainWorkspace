
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
import net.minecraft.core.BlockPos;

import net.mcreator.cristiansmaster.world.inventory.AttributeChangerMenu;
import net.mcreator.cristiansmaster.procedures.ResetAttributesProcedure;
import net.mcreator.cristiansmaster.procedures.IncreaseSpeedProcedure;
import net.mcreator.cristiansmaster.procedures.IncreaseJumpProcedure;
import net.mcreator.cristiansmaster.procedures.DecreaseSpeedProcedure;
import net.mcreator.cristiansmaster.procedures.DecreaseJumpProcedure;
import net.mcreator.cristiansmaster.CristianSMasterMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record AttributeChangerButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<AttributeChangerButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CristianSMasterMod.MODID, "attribute_changer_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AttributeChangerButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AttributeChangerButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AttributeChangerButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<AttributeChangerButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AttributeChangerButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = AttributeChangerMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			IncreaseJumpProcedure.execute(entity);
		}
		if (buttonID == 1) {

			DecreaseJumpProcedure.execute(entity);
		}
		if (buttonID == 2) {

			DecreaseSpeedProcedure.execute(entity);
		}
		if (buttonID == 3) {

			IncreaseSpeedProcedure.execute(entity);
		}
		if (buttonID == 4) {

			ResetAttributesProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CristianSMasterMod.addNetworkMessage(AttributeChangerButtonMessage.TYPE, AttributeChangerButtonMessage.STREAM_CODEC, AttributeChangerButtonMessage::handleData);
	}
}
