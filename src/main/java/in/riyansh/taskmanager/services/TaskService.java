package in.riyansh.taskmanager.services;

import in.riyansh.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService
{
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;

    public TaskEntity addTask(String title, String description, String deadline, boolean completed)
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

    public ArrayList<TaskEntity> getTasks()
    {
        return  tasks;
    }

    public TaskEntity getTaskById(int id)
    {
        for(TaskEntity task: tasks)
        {
            if(task.getId()==id)
            {
                return task;
            }
        }
        return null;
    }
}