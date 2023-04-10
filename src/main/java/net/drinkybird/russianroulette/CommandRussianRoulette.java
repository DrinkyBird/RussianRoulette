package net.drinkybird.russianroulette;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.ThreadLocalRandom;

public class CommandRussianRoulette implements CommandExecutor {
    private final RoulettePlugin plugin;

    CommandRussianRoulette(final RoulettePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String message, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("The server cannot play Russian Roulette.");
        } else {
            final int r = ThreadLocalRandom.current().nextInt(1, 6);
            if (r == 1) {
                plugin.bang(player);
            } else {
                plugin.click(player);
            }
        }

        return true;
    }
}
