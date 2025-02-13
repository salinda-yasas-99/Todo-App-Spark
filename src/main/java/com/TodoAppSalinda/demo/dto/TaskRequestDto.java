package com.TodoAppSalinda.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
    private String title;
    private boolean completed;
    private String description;

}
