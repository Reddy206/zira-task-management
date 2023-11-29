package com.zira.taskplanner.repository;

import com.zira.taskplanner.enums.TaskStatus;
import com.zira.taskplanner.model.Sprint;
import com.zira.taskplanner.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task,String> {
    List<Task> findByAssigneeId(String assigneeId);
    List<Task> findByStatus(TaskStatus status);

    List<Task> findBySprintId(String sprintId);

    List<Task> findByDueDateBefore(LocalDate currentDate);
}
