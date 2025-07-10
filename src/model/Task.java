package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private int id;
    private static int nextId = 0;
    private String title;
    private String description;
    private LocalDate deadline;
    private Priority priority;
    private Status status;
    private List<String> updateLog;

    public Task(String title, String description, LocalDate deadline, Priority priority) {
        this.id = ++this.nextId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.status = Status.TODO;
        this.updateLog = new ArrayList<>();

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addUpdate(String message) {
        this.updateLog.add(message);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public List<String> getUpdateLog() {
        return updateLog;
    }

}
