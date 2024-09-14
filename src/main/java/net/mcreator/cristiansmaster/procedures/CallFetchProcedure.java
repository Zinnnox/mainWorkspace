package net.mcreator.cristiansmaster.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class CallFetchProcedure {
    public static void execute(Entity entity) {
        if (entity instanceof Player player) {
            FetchProcedure.execute(player);
        }
    }
}
