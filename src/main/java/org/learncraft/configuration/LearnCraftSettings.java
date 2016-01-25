package org.learncraft.configuration;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Represents LearnCraft's settings.
 *
 * @since 1.0-SNAPSHOT
 * @author Open-source contributors to LearnCraft
 */
public class LearnCraftSettings {
    private YamlConfiguration configuration;
    private File fileToSave;

    public LearnCraftSettings(File file) {
        this.fileToSave = file;
        this.configuration = new YamlConfiguration();
        if(!fileToSave.exists()){
            try {
                fileToSave.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            configuration.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            configuration.save(fileToSave);
            configuration.load(fileToSave);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void set(String key, Object object) {
        configuration.set(key, object);
        save();
    }

    public Object get(String key, Object ifDoesntExist) {
        return configuration.get(key, ifDoesntExist);
    }
}
