package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    public final static SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private int uniqueID;
    private String description;
    private StatusEnum status;
    private PriorityEnum priority;
    private Date deadline;
    private String category;

    public Task(int uniqueID, String description, StatusEnum status, PriorityEnum priority, Date deadline, String category) {
        this.uniqueID = uniqueID;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.deadline = deadline;
        this.category = category;
    }

    @Override
    public String toString() {
        return "id: " + uniqueID + " Priority: " + priority + " Deadline: "+ DateFormat.format(deadline) +" description: " + description + " status: " + status;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
