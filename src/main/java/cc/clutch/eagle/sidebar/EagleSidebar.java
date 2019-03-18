package cc.clutch.eagle.sidebar;

import cc.clutch.eagle.EaglePlugin;
import cc.clutch.eagle.utils.C;

import com.bizarrealex.aether.scoreboard.Board;
import com.bizarrealex.aether.scoreboard.BoardAdapter;
import com.bizarrealex.aether.scoreboard.cooldown.BoardCooldown;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class EagleSidebar implements BoardAdapter {

    @Override
    public String getTitle(Player player) {
        return C.translate(EaglePlugin.getInstance().getConfigurationCursor().getConfiguration().getString("SCOREBOARD.TITLE"));
    }

    @Override
    public List<String> getScoreboard(Player player, Board board, Set<BoardCooldown> cooldowns) {
        List<String> toReturn = new ArrayList<>();

//        toReturn.add(C.BORDER_LINE_SCOREBOARD);
//        toReturn.add("&6Online&7:&f ");
//        toReturn.add(" ");
//        toReturn.add("&6Rank&7:&f ");
//        toReturn.add(C.BORDER_LINE_SCOREBOARD);

        for (String line : EaglePlugin.getInstance().getConfigurationCursor().getConfiguration().getStringList("SCOREBOARD.LAYOUT")) {
            toReturn.add(C.translate(line));
        }

        replacePlaceholders(toReturn, player.getUniqueId());

        return toReturn;
    }

    private void replacePlaceholders(List<String> list, UUID uuid) {
        for(int i = 0; i < list.size(); i++) {

            list.set(i, list.get(i).replaceAll("<online_count>", String.valueOf(Bukkit.getServer().getOnlinePlayers().size())));
            list.set(i, list.get(i).replaceAll("<rank>", "&aDefault"));
        }
    }
}
