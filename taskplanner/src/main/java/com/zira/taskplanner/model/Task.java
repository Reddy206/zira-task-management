package com.zira.taskplanner.model;

import com.zira.taskplanner.enums.TaskStatus;
import com.zira.taskplanner.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private String taskId;
    private String taskName;
    private String description;
    private TaskType taskType;
    private TaskStatus status;
    private LocalDate dueDate;
    private String assigneeId;
    private String sprintId;
}
