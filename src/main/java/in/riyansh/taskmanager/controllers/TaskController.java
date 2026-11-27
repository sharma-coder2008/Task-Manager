package in.riyansh.taskmanager.controllers;

import in.riyansh.taskmanager.dto.CreateTaskDTO;
import in.riyansh.taskmanager.entities.TaskEntity;
import in.riyansh.taskmanager.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController
{
    //Dependency Injection - Constructor Injection
    private TaskService taskService;
    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    //Dependency Injection - Field Injection
    //@Autowired
    //TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskEntity>> getTasks()
    {
        var tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{myId}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable int myId)
    {
        var task = taskService.getTaskById(myId);
        if(task == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<TaskEntity> addTasks(@RequestBody CreateTaskDTO body) throws ParseException
    {
        taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline(), body.completed);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{myId}")
    public ResponseEntity<TaskEntity> modifyTaskById(@PathVariable Integer myId, @RequestBody CreateTaskDTO body) throws ParseException {
        var task = taskService.getTaskById(myId);
        if(task == null)
        {
            return ResponseEntity.notFound().build();
        }
        taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline(), body.completed);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(ParseException e)
    {
        if(e instanceof ParseException)
        {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid Date Format"));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server Error"));
    }
}
