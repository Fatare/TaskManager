package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private List<Task> tasks = new ArrayList<>();
    int nextId = 0;

    public static void main(String[] args) {
        Main app = new Main();
        app.run();

    }

    public void run() {
        List<Task> tasks = new ArrayList<>();
        while (true) {
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsComplete();
                    break;
                case 4:
                    removeCompletedTasks();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wrong output, choose again.");
            }
        }
    }

    private int getUserChoice() {
        int choice = 0;
        boolean validInput = false;
        Scanner reader = new Scanner(System.in);

        while (!validInput) {
            try {
                String option = "Task Manager Menu:\n" +
                        "1. Add Task\n" +
                        "2. View Tasks\n" + // ✅
                        "3. Mark Task as Complete\n" + // ✅
                        "4. Remove Completed tasks.\n" + // ✅
                        "5. Exit"; // ✅
                System.out.println(option);
                System.out.print("Enter your choice: ");

                choice = reader.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Output out of data.");
                reader.nextLine();
            }
        }
        return choice;
        // return reader.nextInt();
    }

    private void addTask() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter description: ");
        String givenDescription = reader.nextLine();

        System.out.print("Enter deadline of the task (RRRR-MM-DD): ");
        String deadlineStr = reader.next();
        Date deadline = parseDate(deadlineStr);

        System.out.print("Enter category of the task: ");
        String category = reader.next();


        System.out.println("Choose priority:");
        System.out.println("1. HIGH");
        System.out.println("2. MEDIUM");
        System.out.println("3. LOW");
        System.out.print("Choose: ");
        int prioChoice = reader.nextInt();
        Task.Priority priority = Task.Priority.Low;

        switch (prioChoice) {
            case 1:
                priority = Task.Priority.High;
                break;
            case 2:
                priority = Task.Priority.Mid;
                break;
            case 3:
                priority = Task.Priority.Low;
                break;
        }

        Task newTask = new Task(nextId, givenDescription, StatusEnum.ToDo);
        newTask.setPriority(priority);
        tasks.add(newTask);
        nextId++;

        System.out.println("Task has been added");
    }


    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
        } else {
            Collections.sort(tasks, new PriorityComparator());

            for (int i = 0; i <= tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get((i)));
            }
        }
    }

    private void markTaskAsComplete() {
        viewTasks();
        Scanner reader = new Scanner(System.in);

        int givenID = reader.nextInt();
        Optional<Task> foundTask = tasks.stream().filter(task -> task.uniqueID == givenID).findFirst();
        if (foundTask.isPresent()) {
            if (foundTask.get().status == StatusEnum.Completed) {
                System.out.println("Task already is Completed.");
            } else {
                foundTask.get().status = StatusEnum.Completed;
                System.out.println("Updated status.");
            }
        } else {
            System.out.println("Task not found.");
        }
    }

    private void loadTasks() {

    }


    class PriorityComparator implements Comparator<Task> {
        @Override
        public int compare(Task task1, Task task2) {
            return task1.getPriority().compareTo(task2.getPriority());
        }
    }

    private void removeCompletedTasks() {
        tasks.removeIf(task -> task.status == StatusEnum.Completed);
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Nieprawidłowy format daty. Termin zadania zostanie ustawiony na null.");
            return null;
        }
    }
}