package org.example;

public class TaskManager {
    // Class (static) variables.
    // First the public class variables,
    // then protected,
    // then package level (no access modifier) final
    // , and then private.
    // Instance variables.
    // Methods

    // Access to tasks
    private final TaskRepository _repository = new TaskRepository();
    // Class for gathering input and displaying choices
    private final InputMenu _input = new InputMenu();

    public void run() {
        while (true) {
            int choice = _input.getMenuOption();
            switch (choice) {
                case 1:
                    // get input from user
                    var description = _input.getDescription();
                    var priority = _input.getPriority();
                    var category = _input.getCategory();
                    var deadline = _input.getDeadline();

                    var id = _repository.addTask(description, StatusEnum.ToDo, priority, deadline, category);
                    System.out.println("Added task with id: " + id);
                    break;
                case 2:
                    // TODO: zadanie domowe
                    var tasks = _repository.getTasks();

                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        tasks.forEach(System.out::println);
                    }
                    break;
                case 3:
                    // TODO: zadanie domowe
                    var taskId = _input.getTaskId();
                    var taskMarkedAsCompleted = _repository.markTaskAsComplete(taskId);
                    System.out.println(taskMarkedAsCompleted ? "Updated status." : "Task not found or already compelted.");
                    break;
                case 4:
                    // TODO: zadanie domowe
                    var anyRemoved = _repository.removeCompletedTasks();
                    System.out.println(anyRemoved ? "Removed completed tasks." : "No tasks to remove.");
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wrong output, choose again.");
            }
        }
    }

}
