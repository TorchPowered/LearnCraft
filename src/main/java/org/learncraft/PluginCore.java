package org.learncraft;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.learncraft.configuration.LearnCraftAssignments;
import org.learncraft.configuration.LearnCraftSettings;
import org.learncraft.configuration.assignment.Assignment;
import org.learncraft.constants.LearnCraftFiles;
import org.learncraft.gui.MainMenuFrame;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Core to allow Spigot to load LearnCraft.
 *
 * @since 1.0-SNAPSHOT
 * @author Open-source contributors to LearnCraft
 */
public final class PluginCore extends JavaPlugin {
    public static File ROOT;
    public static Logger LOGGER;

    private LearnCraftSettings settings;
    private LearnCraftAssignments assignmentManager;


    @Override
    public void onEnable() {
        ROOT = this.getDataFolder().getParentFile();
        LOGGER = getLogger();

        LOGGER.info("Loading LearnCraft, please wait...");

        // check for whitelist, if no whitelist enable
        if(!Bukkit.hasWhitelist()) {
            Bukkit.setWhitelist(true);
        }

        // register listener
        Bukkit.getPluginManager().registerEvents(new InternalListener(), this);

        // setup files
        if(!LearnCraftFiles.LEARNCRAFT_FOLDER.exists()) {
           LearnCraftFiles.LEARNCRAFT_FOLDER.getFile().mkdir();
            try {
                LearnCraftFiles.LEARNCRAFT_SETTINGS_FILE.getFile().createNewFile();
            } catch (IOException e) {
                errorSequence();
                e.printStackTrace();
                return;
            }
            try {
                LearnCraftFiles.LEARNCRAFT_ASSIGNMENTS_FILE.getFile().createNewFile();
            } catch (IOException e) {
                errorSequence();
                e.printStackTrace();
                return;
            }
        }

        LOGGER.info("Loading LearnCraft assignments...");

        this.assignmentManager = new LearnCraftAssignments(LearnCraftFiles.LEARNCRAFT_ASSIGNMENTS_FILE.getFile());

        LOGGER.info("Loading LearnCraft interface components...");
        try {
            FileUtils.copyURLToFile(getClass().getClassLoader().getResource("minecraft-font.ttf"), LearnCraftFiles.LEARNCRAFT_FONT_FILE.getFile());
        } catch (IOException e) {
            errorSequence();
            e.printStackTrace();
            return;
        }

        try {
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(Font.createFont(Font.TRUETYPE_FONT, LearnCraftFiles.LEARNCRAFT_FONT_FILE.getFile()));
        } catch (FontFormatException e) {
            errorSequence();
            e.printStackTrace();
            return;
        } catch (IOException e) {
            errorSequence();
            e.printStackTrace();
            return;
        }

        LOGGER.info("Loading LearnCraft interface...");
        MainMenuFrame mainMenuFrame = new MainMenuFrame();
        mainMenuFrame.setVisible(true);
    }

    private void errorSequence() {
        LOGGER.info("Failed to load LearnCraft, please ask one of your school technicians or from GitHub.");
        Bukkit.getPluginManager().disablePlugin(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("assignments")) {
            ArrayList<Assignment> assignments = new LearnCraftAssignments(LearnCraftFiles.LEARNCRAFT_ASSIGNMENTS_FILE.getFile()).getAssignmentList();
            StringBuilder builder = new StringBuilder();
            for (Assignment assignment : assignments) {
                builder.append(assignment.getName() + ", ");
            }
            String finalString = ChatColor.GOLD + "Assignments: " + ChatColor.RESET + builder.toString();
            sender.sendMessage(finalString);
            sender.sendMessage(ChatColor.GOLD + "Do /assignment <assignmentname> to see more information about it!");
            return true;
        }
        if(command.getName().equalsIgnoreCase("assignment")) {
            if(args.length > 1) {
                sender.sendMessage(ChatColor.RED + "To show your assignments please use this syntax: /assignment <assignmentname>");
                return true;
            }
            if(args.length < 1) {
                sender.sendMessage(ChatColor.RED + "To show your assignments please use this syntax: /assignment <assignmentname>");
                return true;
            }
            String assignmentName = args[0];
            Assignment assignment = new LearnCraftAssignments(LearnCraftFiles.LEARNCRAFT_ASSIGNMENTS_FILE.getFile()).getAssignment(assignmentName);
            if(assignment == null) {
                sender.sendMessage(ChatColor.RED + "That assignment wasn't found, to see all your assignments; do /assignments");
                return true;
            }
            sender.sendMessage(ChatColor.GOLD + "Assignment Name: " + ChatColor.RESET + assignment.getName());
            sender.sendMessage(ChatColor.GOLD + "Assignment Due Date: " + ChatColor.RESET + LearnCraftAssignments.getDateFormat().format(assignment.getDueDate()));
            sender.sendMessage(ChatColor.GOLD + "Assignment Description:");
            sender.sendMessage(ChatColor.BLUE + assignment.getDescription());
            return true;
        }
        return false;
    }
}
