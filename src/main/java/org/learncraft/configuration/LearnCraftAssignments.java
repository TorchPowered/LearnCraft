package org.learncraft.configuration;

import org.learncraft.configuration.assignment.Assignment;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Represents LearnCraft's assignment manager.
 *
 * @since 1.0-SNAPSHOT
 * @author Open-source contributors to LearnCraft
 */
public class LearnCraftAssignments {
    private ArrayList<Assignment> properties;
    private File fileToSave;

    public static void formatToAssignmentsDataFormat(File file) {
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
        try {
            FileOutputStream stream = new FileOutputStream(file);
            ObjectOutputStream stream1 = new ObjectOutputStream(stream);
            stream1.writeObject(assignments);
            stream1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LearnCraftAssignments(File fileToSaveTo) {
        this.fileToSave = fileToSaveTo;
        this.properties = new ArrayList<Assignment>();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileToSaveTo);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            properties = (ArrayList<Assignment>) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {
            formatToAssignmentsDataFormat(fileToSaveTo);
        }
    }

    public void save() {
        try {
            FileOutputStream stream = new FileOutputStream(fileToSave);
            ObjectOutputStream stream1 = new ObjectOutputStream(stream);
            stream1.writeObject(properties);
            stream1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Assignment> getAssignmentList() {
        return properties;
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
        save();
    }
}
