package com.TodoAppSalinda.demo.controller;

import com.TodoAppSalinda.demo.dto.TaskRequestDto;
import com.TodoAppSalinda.demo.dto.TaskResponseDto;
import com.TodoAppSalinda.demo.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @Operation(summary = "Get all tasks || Active/Deactive",tags = { "Tasks" })
    public List<TaskResponseDto> getTasks(
            @RequestParam boolean completed,
            @RequestParam String taskStatus) {
        return taskService.getTasksByStatusAndCompletion(completed, taskStatus);
    }

    @PostMapping
    @Operation(summary = "Create new task",tags = { "Tasks" })
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.createTask(taskRequestDto));
    }

    @PutMapping("/{taskId}/completed")
    @Operation(summary = "Update task status by id",tags = { "Tasks" })
    public TaskResponseDto updateTaskCompletion(
            @PathVariable String taskId,
            @RequestParam boolean completed) {
        return taskService.updateTaskCompletion(taskId, completed);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete task status by id",tags = { "Tasks" })
    //In here assuming the record isn't entirely deleted. marking it as deactive when deleting
    public ResponseEntity<String> deleteTaskById(@RequestParam String taskId) {
        boolean isDeleted = taskService.deactivateTaskById(taskId);

        if (isDeleted) {
            return ResponseEntity.ok("Task deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Task not found.");
        }
    }

}
