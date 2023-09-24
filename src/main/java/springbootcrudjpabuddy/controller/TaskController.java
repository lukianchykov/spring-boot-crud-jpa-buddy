package springbootcrudjpabuddy.controller;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import springbootcrudjpabuddy.dto.TaskDto;
import springbootcrudjpabuddy.entity.Task;
import springbootcrudjpabuddy.mapper.TaskMapper;
import springbootcrudjpabuddy.repository.TaskRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskController(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        Task taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
        TaskDto taskDto = taskMapper.toDto(taskEntity);
        return ResponseEntity.ok(taskDto);
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody @Valid TaskDto taskDto) {
        Task taskEntity = taskMapper.toEntity(taskDto);
        Task savedTask = taskRepository.save(taskEntity);
        TaskDto savedTaskDto = taskMapper.toDto(savedTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTaskDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody @Valid TaskDto taskDto) {
        Task taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));

        taskMapper.updateTaskFromDto(taskDto, taskEntity);
        Task updatedTask = taskRepository.save(taskEntity);
        TaskDto updatedTaskDto = taskMapper.toDto(updatedTask);
        return ResponseEntity.ok(updatedTaskDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        Task taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));

        taskRepository.delete(taskEntity);
        return ResponseEntity.noContent().build();
    }
}
