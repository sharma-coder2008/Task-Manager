package in.riyansh.taskmanager.entities;

import lombok.Data;
import java.util.Date;

@Data
public class TaskEntity
{
    private long id;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;
}