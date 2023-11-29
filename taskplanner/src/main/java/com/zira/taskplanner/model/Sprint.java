package com.zira.taskplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "sprints")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {
    @Id
    private String sprintId;
    private String sprintName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<String> taskIds;
}
