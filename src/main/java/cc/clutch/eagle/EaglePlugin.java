package cc.clutch.eagle;

import cc.clutch.eagle.file.ConfigurationCursor;

import cc.clutch.eagle.managers.LobbyManager;
import cc.clutch.eagle.managers.SelectorManager;

import org.bukkit.plugin.java.JavaPlugin;

public class EaglePlugin extends JavaPlugin {

    private static EaglePlugin instance;

    private ConfigurationCursor configurationCursor;
    private LobbyManager lobbyManager;
    private SelectorManager selectorManager;

    public void onEnable() {
        instance = this;

        this.configurationCursor = new ConfigurationCursor();
        this.configurationCursor.setup();

        loadManagers();
    }

    void loadManagers() {
        this.lobbyManager = new LobbyManager();
        this.selectorManager = new SelectorManager();
    }

    public SelectorManager getSelectorManager() {
        return selectorManager;
    }

    public LobbyManager getLobbyManager() {
        return lobbyManager;
    }

    public ConfigurationCursor getConfigurationCursor() {
        return configurationCursor;
    }

    public static EaglePlugin getInstance() {
        return instance;
    }
}
