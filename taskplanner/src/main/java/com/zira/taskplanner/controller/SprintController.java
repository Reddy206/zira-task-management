package com.zira.taskplanner.controller;

import com.zira.taskplanner.model.Sprint;
import com.zira.taskplanner.model.Task;
import com.zira.taskplanner.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sprints")
public class SprintController {

    @Autowired
    SprintService sprintService;

    @PostMapping
    public Sprint createSprint(@RequestBody Sprint sprint){
        return sprintService.createSprint(sprint);
    }
    @GetMapping
    public List<Sprint> getAllSprints(){
        return sprintService.findAllSprints();
    }

    @GetMapping(value = "/{sprintId}")
    public Sprint findSprintById(@PathVariable String sprintId){
        return sprintService.findSprintById(sprintId);
    }
    @PostMapping("/{sprintId}/tasks/{taskId}")
    public void addToSprint(@PathVariable String sprintId, @PathVariable String taskId){
        sprintService.addToSprint(sprintId,taskId);
    }

    @DeleteMapping("/{sprintId}/tasks/{taskId}")
    public void removeFromSprint(@PathVariable String sprintId, @PathVariable String taskId){
        sprintService.removeFromSprint(sprintId,taskId);
    }

    @GetMapping(value = "/{sprintId}/tasks")
    public List<Task> getTasksBySprint(@PathVariable String sprintId){
        return sprintService.getTasksBySprint(sprintId);
    }

}
