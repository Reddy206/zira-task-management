package com.zira.taskplanner.controller;

import com.zira.taskplanner.dto.ChangeTaskStatusRequest;
import com.zira.taskplanner.model.Task;
import com.zira.taskplanner.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    @GetMapping(value = "/{taskId}")
    public Task findTaskById(@PathVariable String taskId){
        return taskService.findById(taskId);
    }

    @GetMapping("/delayed")
    public List<Task> getDelayedTasks() {
        return taskService.getDelayedTasks();
    }

    @GetMapping("/assigned/{userId}")
    public List<Task> getTasksAssignedToUser(@PathVariable String userId) {
        return taskService.getTasksAssignedToUser(userId);
    }

    @GetMapping(value = "/status")
    public List<Task> getAllTasksByStatus(@RequestParam String taskStatus){
        return taskService.getAllTasksByStatus(taskStatus);
    }

    @PostMapping(value = "/{taskId}/assign/{userId}")
    public String assignTaskToUser(@PathVariable String taskId, @PathVariable String userId){
        taskService.assignTaskToUser(taskId,userId);
        return "Task Assigned To User Successfully";
    }

    @PutMapping(value = "/{taskId}/change-status")
    public Task changeTaskStatus(@PathVariable String taskId,
                                 @RequestBody ChangeTaskStatusRequest changeTaskStatusRequest){
        return taskService.changeTaskStatus(taskId,changeTaskStatusRequest.getNewStatus());
    }
}
