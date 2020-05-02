package me.uniodex.unioperks.commands.subcommands;

import me.uniodex.unioperks.UnioPerks;
import me.uniodex.unioperks.commands.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class scAutoSell implements SubCommand {

    private UnioPerks plugin;
    private int minArgs = 1;
    private String name = "autosell";
    private String permission = "unioperks.autosell";
    private String usage;

    public scAutoSell(UnioPerks plugin) {
        this.plugin = plugin;
        usage = plugin.getMessage("commands.autoSell.usage");
    }

    public int getMinArgs() {
        return minArgs;
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }

    public String getUsage() {
        return usage;
    }

    public void run(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getMessage("commands.playerOnly"));
            return;
        }

        Player player = (Player) sender;
        if (plugin.getDropControlManager().isInAutoSellMode(player)) {
            plugin.getDropControlManager().setAutoSell(player, false);
            sender.sendMessage(plugin.getMessage("commands.autoSell.toggledOff"));
        } else {
            plugin.getDropControlManager().setAutoSell(player, true);
            sender.sendMessage(plugin.getMessage("commands.autoSell.toggledOn"));
        }
    }
}
