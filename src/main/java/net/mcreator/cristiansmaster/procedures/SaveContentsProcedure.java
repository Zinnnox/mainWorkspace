package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.mcreator.cristiansmaster.network.CristianSMasterModVariables;
import java.util.function.Supplier;
import java.util.Map;

public class SaveContentsProcedure {
    public static void execute(Player player) {
        if (player == null) return;

        // Fetch player variables
        CristianSMasterModVariables.PlayerVariables variables = player.getData(CristianSMasterModVariables.PLAYER_VARIABLES);

        // Save items from GUI slots into player variables
        if (player.containerMenu instanceof Supplier<?> supplier && supplier.get() instanceof Map<?, ?> slots) {
            for (int i = 0; i < 10; i++) {
                ItemStack currentStack = ((Slot) slots.get(i)).getItem();
                switch (i) {
                    case 0 -> variables.slot0 = currentStack;
                    case 1 -> variables.slot1 = currentStack;
                    case 2 -> variables.slot2 = currentStack;
                    case 3 -> variables.slot3 = currentStack;
                    case 4 -> variables.slot4 = currentStack;
                    case 5 -> variables.slot5 = currentStack;
                    case 6 -> variables.slot6 = currentStack;
                    case 7 -> variables.slot7 = currentStack;
                    case 8 -> variables.slot8 = currentStack;
                    case 9 -> variables.slot9 = currentStack;
                }
            }
            // Force a sync to ensure that client/server are updated
            player.containerMenu.broadcastChanges();
        }

        // Sync the saved variables to ensure they're stored
        variables.syncPlayerVariables(player);
    }
}
