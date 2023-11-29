package com.zira.taskplanner.service;

import com.zira.taskplanner.model.Sprint;
import com.zira.taskplanner.model.Task;
import com.zira.taskplanner.repository.SprintRepository;
import com.zira.taskplanner.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {

    @Autowired
    SprintRepository sprintRepository;

    @Autowired
    TaskRepository taskRepository;

    public Sprint createSprint(Sprint sprint){
        return sprintRepository.save(sprint);
    }

    public void addToSprint(String sprintId, String taskId){
        Sprint sprint = sprintRepository.findById(sprintId).orElseThrow(() -> new RuntimeException("Sprint not found"));
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        // Add the task to the Sprint
        sprint.getTaskIds().add(task.getTaskId());
        sprintRepository.save(sprint);

        // Update the Sprint ID in the Task
        task.setSprintId(sprint.getSprintId());
        taskRepository.save(task);
    }

    public void removeFromSprint(String sprintId, String taskId){
        Sprint sprint = sprintRepository.findById(sprintId).orElseThrow(() -> new RuntimeException("Sprint not found"));
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        // Remove the task from the Sprint
        sprint.getTaskIds().remove(task.getTaskId());
        sprintRepository.save(sprint);

        // Update the Sprint ID in the Task
        task.setSprintId(null);
        taskRepository.save(task);
    }


    public List<Sprint> findAllSprints() {
        return sprintRepository.findAll();
    }

    public Sprint findSprintById(String sprintId) {
        return sprintRepository.findById(sprintId).orElseThrow(() -> new RuntimeException("Sprint not found"));
    }

    public List<Task> getTasksBySprint(String sprintId) {
        sprintRepository.findById(sprintId)
                                        .orElseThrow(() -> new RuntimeException("Sprint not found with id: " + sprintId));
        return taskRepository.findBySprintId(sprintId);
    }
}
