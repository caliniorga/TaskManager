package ui;

import service.TaskService;
import model.Status;
import model.Priority;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// TO DO
public class ConsoleUI {
    private TaskService taskService;
    private Scanner scanner;

    public ConsoleUI() {
        this.taskService = new TaskService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Select an option: ");

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    updateTaskStatus();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public void printMenu() {
        System.out.println("\n--- Task Manager Menu ---");
        System.out.println("1. Add new task");
        System.out.println("2. List tasks");
        System.out.println("3. Update task status");
        System.out.println("4. Delete task");
        System.out.println("5. Exit");
    }

    private int readInt(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number");
            scanner.next();
            System.out.println(prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Use YYYY-MM-DD.");
            }
        }
    }

    private Status readStatus(String prompt) {
        while (true) {
            System.out.print(prompt + " (TODO, IN_PROGRESS, DONE): ");
            String input = scanner.nextLine().toUpperCase();
            try {
                return Status.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid format. Try again.");
            }

        }
    }

    private Priority readPriority(String prompt) {
        while (true) {
            System.out.print(prompt + " (LOW, MEDIUM, HIGH): ");
            String input = scanner.nextLine().toUpperCase();
            try {
                return Priority.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. Try again.");
            }
        }
    }

    private void addTask() {
        String title = readString("Enter task title: ");
        String description = readString("Enter task description: ");
        LocalDate deadline = readDate("Enter deadline (YYYY-MM-DD): ");
        Priority priority = readPriority("Enter priority: ");

        taskService.addTask(title, description, deadline, priority);
        System.out.println("Task added successfully");
    }

    private void listTasks() {
        taskService.listTasks();
    }

    private void updateTaskStatus() {
        int id = readInt("Enter task ID to update: ");
        Status status = readStatus("Enter new status");
        taskService.updateStatus(id, status);
        System.out.println("Task status updated.");
    }

    private void deleteTask() {
        int id = readInt("Enter task ID to delete: ");
        taskService.deleteTask(id);
        System.out.println("Task deleted");
    }

};