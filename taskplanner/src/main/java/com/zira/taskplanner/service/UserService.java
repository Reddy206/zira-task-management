package com.zira.taskplanner.service;

import com.zira.taskplanner.model.Task;
import com.zira.taskplanner.model.User;
import com.zira.taskplanner.repository.TaskRepository;
import com.zira.taskplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<Task> getTasksAssignedToUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with id: " + userId));
        return taskRepository.findByAssigneeId(userId);
    }
}
