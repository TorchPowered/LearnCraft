package org.learncraft.configuration.assignment;

import java.util.Date;

/**
 * Represents a LearnCraft assignment.
 *
 * @since 1.0-SNAPSHOT
 * @author Open-source contributors to LearnCraft
 */
public class Assignment {
    private Date due;
    private String name;
    private String description;

    public Assignment(String name, String description, Date due) {
        this.name = name;
        this.description = description;
        this.due = due;
    }

    public Date getDueDate() {
        return due;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDueDate(Date date) {
        this.due = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
