package cc.clutch.eagle.file;

import cc.clutch.eagle.EaglePlugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigurationCursor {

    File file;
    YamlConfiguration configuration;

    public void setup() {
        EaglePlugin.getInstance().saveDefaultConfig();
        file = new File(EaglePlugin.getInstance().getDataFolder(), "config.yml");
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfiguration() {
        return configuration;
    }

    public int getBelowY() {
        return configuration.getInt("below");
    }

    private void save() {
        try {
            configuration.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}