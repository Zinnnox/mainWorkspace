package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import java.util.function.Supplier;
import java.util.Map;

public class FetchProcedure {
    public static void execute(Player player) {
        if (player == null) return;

        // Fetch the player's variables
        CristianSMasterModVariables.PlayerVariables variables = player.getData(CristianSMasterModVariables.PLAYER_VARIABLES);
        

        // Load items from variables into GUI slots
        if (player.containerMenu instanceof Supplier<?> supplier && supplier.get() instanceof Map<?, ?> slots) {
            for (int i = 0; i < 10; i++) {
                ItemStack stack = switch (i) {
                    case 0 -> variables.slot0;
                    case 1 -> variables.slot1;
                    case 2 -> variables.slot2;
                    case 3 -> variables.slot3;
                    case 4 -> variables.slot4;
                    case 5 -> variables.slot5;
                    case 6 -> variables.slot6;
                    case 7 -> variables.slot7;
                    case 8 -> variables.slot8;
                    case 9 -> variables.slot9;
                    default -> ItemStack.EMPTY;
                };

                // Only set the slot if the saved stack is not empty
                if (!stack.isEmpty()) {
                    ((Slot) slots.get(i)).set(stack);
                }
            }
            // Force a sync to ensure that client/server are updated
            player.containerMenu.broadcastChanges();
        }
    }
}
