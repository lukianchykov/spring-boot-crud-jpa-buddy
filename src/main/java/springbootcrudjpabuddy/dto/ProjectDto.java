package springbootcrudjpabuddy.dto;

import java.io.Serializable;
import java.util.Set;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import springbootcrudjpabuddy.entities.Project;

/**
 * DTO for {@link Project}
 */
@Value
public class ProjectDto implements Serializable {

    Long id;

    @NotNull
    @Size(max = 255)
    String name;

    UserDto manager;

    Set<TaskDto> tasks;
}