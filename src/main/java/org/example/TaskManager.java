package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    // Class (static) variables.
    // First the public class variables,
    // then protected,
    // then package level (no access modifier) final
    // , and then private.
    // Instance variables.
    // Methods

    private static String menuOptionsText =
            "Task Manager Menu:\n" +
                    "1. Add Task\n" +
                    "2. View Tasks\n" +
                    "3. Mark Task as Complete\n" +
                    "4. Remove Completed tasks.\n" +
                    "5. Exit";

    // Access to tasks
    private final TaskRepository _repository = new TaskRepository();
    // Class for gathering input and displaying choices
    private final InputMenu _input = new InputMenu();

    public void run() {

        List<Task> tasks = new ArrayList<>();
        while (true) {
            int choice = _input.getMenuOption();
            switch (choice) {
                case 1:
                    // get input from user
                    var description = _input.getDescription();
                    var priority = _input.getPriority();
                    var category = _input.getCategory();
                    var deadline = _input.getDeadline();

                    // create new task based on input
                    Task task = new Task(description,StatusEnum.ToDo, priority, deadline, category);
                    // add new task using repository
                    _repository.addTask(task);
                    break;
                case 2:
                    // TODO: zadanie domowe

                    _repository.viewTasks();
                    break;
                case 3:
                    // TODO: zadanie domowe
                    _repository.viewTasks();
                    _repository.markTaskAsComplete();
                    break;
                case 4:
                    // TODO: zadanie domowe
                    _repository.removeCompletedTasks();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wrong output, choose again.");
            }
        }
    }

}
