package com.zira.taskplanner.service;

import com.zira.taskplanner.enums.TaskStatus;
import com.zira.taskplanner.model.Task;
import com.zira.taskplanner.model.User;
import com.zira.taskplanner.repository.TaskRepository;
import com.zira.taskplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    public Task createTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    public List<Task> getDelayedTasks(){
        LocalDate currentDate = LocalDate.now();

        List<Task> allTasks = taskRepository.findByDueDateBefore(currentDate);
        return allTasks.stream().filter(task ->
                task.getStatus() != TaskStatus.DONE).collect(Collectors.toList());
    }

    public List<Task> getTasksAssignedToUser(String userId) {
        return taskRepository.findByAssigneeId(userId);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(String taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> getAllTasksByStatus(String taskStatus) {
        return taskRepository.findByStatus(TaskStatus.valueOf(taskStatus.toUpperCase()));
    }

    public void assignTaskToUser(String taskId, String userId) {
        Task task =
                taskRepository.findById(taskId)
                              .orElseThrow(()-> new RuntimeException("Task not found with id: " + taskId ));
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with id: " + userId));

        task.setAssigneeId(userId);
        taskRepository.save(task);

    }

    public Task changeTaskStatus(String taskId, TaskStatus newStatus) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()-> new RuntimeException("Task not found with id: " + taskId));

        if(!isValidStatusTransition(task.getStatus(),newStatus)){
            throw new RuntimeException("Invalid status transition for task: " + taskId);
        }
        task.setStatus(newStatus);
        return taskRepository.save(task);
    }

    private boolean isValidStatusTransition(TaskStatus currentStatus, TaskStatus newStatus){
        return switch (currentStatus) {
            case TO_DO -> newStatus == TaskStatus.DEV_IN_PROGRESS;
            case DEV_IN_PROGRESS -> newStatus == TaskStatus.DONE || newStatus == TaskStatus.TO_DO;
            default -> false;
        };
    }
}
