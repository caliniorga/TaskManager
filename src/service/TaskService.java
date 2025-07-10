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

    // TO DO
    public List<Task> listTasks() {
        return null;
    }

    // TO DO
    public void updateStatus(int id, String status) {

    }

    // TO DO
    public void deleteTask(int id) {
    }
}
