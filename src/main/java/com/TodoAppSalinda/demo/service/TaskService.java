package com.TodoAppSalinda.demo.service;

import com.TodoAppSalinda.demo.dto.TaskRequestDto;
import com.TodoAppSalinda.demo.dto.TaskResponseDto;
import com.TodoAppSalinda.demo.model.Task;
import com.TodoAppSalinda.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        Task task = convertToEntity(taskRequestDto);
        Task savedTask = taskRepository.save(task);
        return convertToDto(savedTask);
    }

    public List<TaskResponseDto> getTasksByStatusAndCompletion(boolean completed, String taskStatus) {
        List<Task> tasks = taskRepository.findByCompletedAndTaskStatus(completed, taskStatus);
        return tasks.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public TaskResponseDto updateTaskCompletion(String taskId, boolean completed) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setCompleted(completed);
            task.setTaskStatus(completed ? "Completed" : "Pending");
            Task updatedTask = taskRepository.save(task);
            return convertToDto(updatedTask);
        } else {
            throw new RuntimeException("Task not found with ID: " + taskId);
        }
    }

    public boolean deactivateTaskById(String id) {

        if (taskRepository.existsById(id)) {

            Task task = taskRepository.findById(id).get();

            task.setTaskStatus("Deactive");

            taskRepository.save(task);
            return true;
        }
        return false;
    }

    private Task convertToEntity(TaskRequestDto taskRequestDto) {
        Task task = new Task();
        task.setTitle(taskRequestDto.getTitle());
        task.setDescription(taskRequestDto.getDescription());
        task.setCompleted(false);
        task.setTaskStatus("Active");
        return task;
    }

    private TaskResponseDto convertToDto(Task task) {
        return new TaskResponseDto(task.getId(), task.getTitle(), task.getDescription(), task.isCompleted(), task.getTaskStatus());
    }
}
