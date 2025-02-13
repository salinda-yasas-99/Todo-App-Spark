package com.TodoAppSalinda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {
    private String id;
    private String title;
    private String description;
    private boolean completed;
    private String taskStatus;
}
