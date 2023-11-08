package org.example;

import java.text.MessageFormat;
import java.util.*;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    int nextId = 0;

    public void addTask(Task taskToAdd) {
        tasks.add(taskToAdd);
        nextId++;

        System.out.println("Task has been added");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
        } else {
            tasks.sort(new PriorityComparator());

            int i = 0;

            for (var task : tasks) {
                System.out.println(MessageFormat.format("{0}. {1}", i++, task));
            }
        }
    }

    public void getTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
        } else {
            tasks.sort(new PriorityComparator());

            int i = 0;

            for (var task : tasks) {
                System.out.println(MessageFormat.format("{0}. {1}", i++, task));
            }
        }
    }

    public void markTaskAsComplete(Integer id) {  //function

//        Scanner reader = new Scanner(System.in);
//
//        int givenID = reader.nextInt();
        Optional<Task> foundTask = tasks.stream().filter(task -> task.getUniqueID() == task.getUniqueID()).findFirst();
        if (foundTask.isPresent()) {
            if (foundTask.get().getStatus() == StatusEnum.Completed) {
                System.out.println("Task already is completed.");
            } else {
                foundTask.get().setStatus(StatusEnum.Completed);
                System.out.println("Updated status.");
            }
        } else {
            System.out.println("Task not found.");
        }
    }

    public void removeCompletedTasks() {
        tasks.removeIf(task -> task.getStatus() == StatusEnum.Completed);
    }

    private Optional<Task> findTask(Integer id){
        return tasks.stream().filter(task -> task.equals(id)).findFirst();
    }
    //var optionalTask = findTask(id);
//        if(optionalTask.isPresent() && !optionalTask.get().getStatus().equals(StatusEnum.Completed)) {
//            optionalTask.get().setStatus(status);
//            return true;
//        }
//        return false;

//    var x = new Task();
//        System.out.println(x.getUniqueID());
}
