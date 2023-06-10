package net.drinkybird.russianroulette;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RoulettePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("russianroulette").setExecutor(new CommandRussianRoulette(this));
        this.getCommand("banroulette").setExecutor(new CommandBanRoulette(this));
    }

    void bang(final Player player) {
        player.getWorld().playSound(player, Sound.ENTITY_GENERIC_EXPLODE, 0.8f, 1.0f);
        Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), "Bang!", null, "RussianRoulette");
        player.kickPlayer("Bang!");
        Bukkit.broadcastMessage(player.getDisplayName() + ChatColor.RED + " lost a game of Russian Roulette...");
    }

    void kill(final Player player) {
        player.getWorld().playSound(player, Sound.ENTITY_GENERIC_EXPLODE, 0.8f, 1.0f);
        player.setHealth(0.0);
        Bukkit.broadcastMessage(player.getDisplayName() + ChatColor.RED + " lost a game of Russian Roulette...");
    }

    void click(final Player player) {
        player.sendMessage("Click...");
        player.getWorld().playSound(player, Sound.BLOCK_TRIPWIRE_CLICK_ON, 1.0f, 1.0f);
    }
}
