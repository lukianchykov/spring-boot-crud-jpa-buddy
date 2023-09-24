package springbootcrudjpabuddy.dto;

import java.time.Instant;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbootcrudjpabuddy.entity.Project;

/**
 * DTO for {@link Project}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    @JsonProperty("id")
    private Long id;

    @NotNull
    @Size(max = 255)
    @JsonProperty("name")
    private String name;

    @JsonProperty("start_date")
    private Instant startDate;

    @JsonProperty("end_date")
    private Instant endDate;

    @JsonProperty("manager")
    private UserDto manager;

    @JsonProperty("tasks")
    private Set<TaskDto> tasks;
}