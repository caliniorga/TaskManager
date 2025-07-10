package service;

import model.Priority;
import model.Status;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks;
    public TaskService(){
        this.tasks = new ArrayList<>();
    }

}
