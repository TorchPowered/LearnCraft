package org.learncraft.constants;

import org.learncraft.PluginCore;

import java.io.File;

/**
 * Represents locations of important LearnCraft files.
 *
 * @since 1.0-SNAPSHOT
 * @author Open-source contributors to LearnCraft
 */
public enum LearnCraftFiles {
    LEARNCRAFT_FOLDER(PluginCore.ROOT, "LearnCraft"),
    LEARNCRAFT_SETTINGS_FILE(LEARNCRAFT_FOLDER, "settings.yml"),
    LEARNCRAFT_ASSIGNMENTS_FILE(LEARNCRAFT_FOLDER, "data.assignments"),
    LEARNCRAFT_FONT_FILE(LEARNCRAFT_FOLDER, "minecraft.tff");

    private File parentFile;
    private String fileName;

    LearnCraftFiles(File parentFile, String fileName) {
        this.parentFile = parentFile;
        this.fileName = fileName;
    }

    LearnCraftFiles(LearnCraftFiles location, String fileName) {
        this.parentFile = location.getParentFile();
        this.fileName = fileName;
    }

    public File getParentFile() {
        return this.parentFile;
    }

    public File getFile() {
        return new File(parentFile, fileName);
    }

    public boolean exists() {
        return getFile().exists();
    }
}
