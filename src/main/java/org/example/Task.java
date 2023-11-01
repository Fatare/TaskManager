package org.example;

import java.util.Comparator;
import java.util.Date;

public class Task {
    public int uniqueID;
    public String description;
    public StatusEnum status;
    public Priority prio;
    public Date deadline;
    public String category;

    public Task(int uniqueID, String description, StatusEnum status) {
        this.uniqueID = uniqueID;
        this.description = description;
        this.status = status;
    }

    public Priority getPriority(){
        return prio;
    }
    public void setPriority (Priority prio){
        this.prio = prio;
    }

    public Date getDeadline(){
        return deadline;
    }

    public void setDeadline(Date deadline){
        this.deadline = deadline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    enum Priority {
        High, Mid, Low
    }

    @Override
    public String toString() {
        return "id: " + uniqueID + " Priority: " + prio + " Deadline: "+ deadline +" description: " + description + " status: " + status;
    }


}

