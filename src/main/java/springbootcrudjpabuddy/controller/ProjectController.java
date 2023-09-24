package springbootcrudjpabuddy.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import springbootcrudjpabuddy.dto.ProjectDto;
import springbootcrudjpabuddy.entity.Project;
import springbootcrudjpabuddy.mapper.ProjectMapper;
import springbootcrudjpabuddy.repository.ProjectRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @GetMapping("/by-id/{id}")
    public ProjectDto getProjectById(@PathVariable Long id) {
        Project projectEntity = projectRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Project not found"));
        return projectMapper.toDto(projectEntity);
    }

    @GetMapping("/by-name/{name}")
    public List<ProjectDto> findByName(@PathVariable String name) {
        List<Project> projects = projectRepository.findByName(name);
        return projects.stream().map(projectMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/active")
    public List<ProjectDto> getActiveProjects() {
        List<Project> activeProjects = projectRepository.findActiveProjects();
        return activeProjects.stream().map(projectMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public ProjectDto saveProject(@RequestBody @NotNull @Valid ProjectDto projectDto) {
        Project projectEntity = projectMapper.toEntity(projectDto);
        Project savedProject = projectRepository.save(projectEntity);
        return projectMapper.toDto(savedProject);
    }

    @PatchMapping("/{id}")
    public ProjectDto updateProject(@PathVariable Long id, @RequestBody @NonNull @Valid ProjectDto projectDto) {
        Project projectEntity = projectRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Project not found"));

        projectMapper.partialUpdate(projectDto, projectEntity);
        Project updatedProject = projectRepository.save(projectEntity);
        return projectMapper.toDto(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        Project projectEntity = projectRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Project not found"));

        projectRepository.delete(projectEntity);
        return ResponseEntity.noContent().build();
    }
}
