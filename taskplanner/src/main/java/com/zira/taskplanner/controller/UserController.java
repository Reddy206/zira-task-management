package com.zira.taskplanner.controller;

import com.zira.taskplanner.model.Task;
import com.zira.taskplanner.model.User;
import com.zira.taskplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getUsers();
    }
    @GetMapping(value = "/{userId}/tasks")
    public List<Task> getTasksAssignedToUser(@PathVariable String userId){
        return userService.getTasksAssignedToUser(userId);
    }

}
