package service;

import model.Priority;
import model.Status;
import model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks;

    public TaskService() {
        this.tasks = new ArrayList<>();
    }

    public Task addTask(String title, String description, LocalDate deadline, Priority priority) {
        Task task = new Task(title, description, deadline, priority);
        this.tasks.add(task);
        return task;
    }

    public void listTasks() {
        for (Task task : this.tasks) {
            System.out.println("ID = " + task.getId() + ", title: " + task.getTitle());
        }

    }

    public void updateStatus(int id, Status status) {
        for (Task task : this.tasks) {
            if (task.getId() == id) {
                task.setStatus(status);
                break;
            }
        }

    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
