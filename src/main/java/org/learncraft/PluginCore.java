package org.learncraft;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Core to allow Spigot to load LearnCraft.
 *
 * @since 1.0-SNAPSHOT
 * @author Open-source contributors to LearnCraft
 */
public final class PluginCore extends JavaPlugin {
    public static Logger LOGGER;

    @Override
    public void onEnable() {
        LOGGER = getLogger();

        LOGGER.info("Loading LearnCraft, please wait...");

    }
}
