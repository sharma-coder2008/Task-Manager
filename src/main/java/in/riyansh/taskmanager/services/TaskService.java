package in.riyansh.taskmanager.services;

import in.riyansh.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public class TaskService
{
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;

    public void addTask(String title, String description, String deadline, boolean completed)
    {
        TaskEntity te = new TaskEntity();
        te.setId(taskId);
        te.setTitle(title);
        te.setDescription(description);
        te.setDeadline(new Date(deadline));
        te.setCompleted(completed);
        taskId++;
        tasks.add(te);
    }
