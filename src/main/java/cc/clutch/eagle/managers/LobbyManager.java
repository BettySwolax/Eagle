package cc.clutch.eagle.managers;

import cc.clutch.eagle.EaglePlugin;

import cc.clutch.eagle.module.Module;

import cc.clutch.eagle.utils.C;
import cc.clutch.eagle.utils.ItemFactory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class LobbyManager extends Module {

    public LobbyManager() {
        super("LobbyManager", EaglePlugin.getInstance());
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        for (String m : getInstance().getConfigurationCursor().getConfiguration().getStringList("JOIN_MESSAGE")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', m));
        }

        ItemStack serverSelector = new ItemFactory(Material.CHEST)
                .name(ChatColor.translateAlternateColorCodes('&', getInstance().getConfigurationCursor().getConfiguration().getString("ITEM.SELECTOR.NAME")))
                .lore(C.translate(getInstance().getConfigurationCursor().getConfiguration().getString("ITEM.SELECTOR.LORE")))
                .build();

        player.getInventory().setItem(0, serverSelector);
    }
}
