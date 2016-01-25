package org.learncraft.configuration;

import org.learncraft.configuration.assignment.Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 * Represents LearnCraft's assignment manager.
 *
 * @since 1.0-SNAPSHOT
 * @author Open-source contributors to LearnCraft
 */
public class LearnCraftAssignments {
    private Properties properties;
    private File fileToSave;

    public LearnCraftAssignments(File fileToSaveTo) {
        this.fileToSave = fileToSaveTo;
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream(fileToSaveTo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            properties.store(new FileOutputStream(fileToSave), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Assignment> getAssignmentList() {
        if(properties.get("assignments") == null) {
            return new ArrayList<Assignment>();
        }
        return (ArrayList<Assignment>) properties.get("assignments");
    }

    public static SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat("MM/dd/yyyy");
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public void newAssignment(String name, String description, Date date) {
        ArrayList<Assignment> assignments = getAssignmentList();
        assignments.add(new Assignment(name, description, date));
        properties.put("assignments", assignments);
        save();
    }

    public Assignment getAssignment(String assignmentName) {
        for (Assignment assignment : getAssignmentList()) {
            if(assignment.getName().equals(assignmentName)) {
                return assignment;
            }
        }
        return null;
    }

    public void removeAssignment(String assignmentName) {
        if(getAssignment(assignmentName) == null){
            return;
        }
        Assignment assignment = getAssignment(assignmentName);
        ArrayList<Assignment> assignments = getAssignmentList();
        assignments.remove(assignment);
        properties.put("assignments", assignments);
        save();
    }
}
