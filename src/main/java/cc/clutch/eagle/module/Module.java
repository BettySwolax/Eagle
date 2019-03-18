package cc.clutch.eagle.module;

import cc.clutch.eagle.EaglePlugin;

import com.google.common.collect.Lists;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

public abstract class Module implements Listener {

    private final String name;
    private final EaglePlugin instance;

    public Module(String name, EaglePlugin instance) {
        this.name = name;
        this.instance = instance;

        registerListeners(this);
    }

    private void registerListeners(Listener... l) {
        Lists.newArrayList(l).forEach(o -> Bukkit.getPluginManager().registerEvents(o, getInstance()));
    }

    public String getName() {
        return name;
    }

    public EaglePlugin getInstance() {
        return instance;
    }

    protected void callEvent(Event event) {
        getInstance().getServer().getPluginManager().callEvent(event);
    }

    protected void print(String message) {
        Bukkit.getConsoleSender().sendMessage("[" + getName() + "] " + message);
    }
}
