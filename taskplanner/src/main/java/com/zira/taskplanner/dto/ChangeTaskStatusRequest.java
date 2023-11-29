package com.zira.taskplanner.dto;

import com.zira.taskplanner.enums.TaskStatus;
import lombok.Data;

@Data
public class ChangeTaskStatusRequest {
    private TaskStatus newStatus;
}
