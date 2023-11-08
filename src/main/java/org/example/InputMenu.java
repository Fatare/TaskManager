package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputMenu {

    private static String menuOptionsText =
            "Task Manager Menu:\n" +
                    "1. Add Task\n" +
                    "2. View Tasks\n" +
                    "3. Mark Task as Complete\n" +
                    "4. Remove Completed tasks.\n" +
                    "5. Exit";

    private final Scanner reader = new Scanner(System.in);

    public int getMenuOption() {
        int choice = 0;
        boolean validInput = false;
        Scanner reader = new Scanner(System.in);

        while (!validInput) {
            try {
                System.out.println(menuOptionsText);
                System.out.print("Enter your choice: ");

                choice = reader.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Output out of data.");
                reader.nextLine();
            }
        }
        return choice;
    }

    // get input choice for description
    public String getDescription() {
        System.out.print("Enter description: ");
        //String givenDescription = reader.nextLine();
        return reader.nextLine();
    }

    // get input choice for deadline
    public Date getDeadline() {
        System.out.print("Enter deadline of the task (YYYY-MM-DD): ");
        String deadlineStr = reader.next();
        Date deadline = parseDate(deadlineStr);
        return deadline;
        // return parseDate(reader.next());
    }

    // get input choice for category
    public String getCategory() {
        System.out.print("Enter category of the task: ");
        //String category = reader.next();
        return reader.next();
    }

    // get input choice for priority
    public PriorityEnum getPriority(){
        System.out.println("Choose priority:");
        System.out.println("1. HIGH");
        System.out.println("2. MEDIUM");
        System.out.println("3. LOW");
        System.out.print("Choose: ");
        int prioChoice = reader.nextInt();

        PriorityEnum priority = switch (prioChoice) {
            case 1 -> PriorityEnum.High;
            case 2 -> PriorityEnum.Mid;
            case 3 -> PriorityEnum.Low;
            default -> throw new IllegalArgumentException(Integer.toString(prioChoice));
        };

        return priority;
    }

    public int getTaskId(){
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter ID of task you want to chace to complete: ");
        return reader.nextInt();

    }
    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Deadline of the task will be set null.");
            return null;
        }
    }
}
