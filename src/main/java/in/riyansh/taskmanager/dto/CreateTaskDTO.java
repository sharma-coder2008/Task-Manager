package in.riyansh.taskmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTaskDTO
{
    String title;
    String description;
    String deadline;
    public boolean completed;
}