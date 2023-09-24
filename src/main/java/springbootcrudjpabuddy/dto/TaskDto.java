package springbootcrudjpabuddy.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springbootcrudjpabuddy.entity.Task;

/**
 * DTO for {@link Task}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("startDate")
    private Instant startDate;

    @JsonProperty("endDate")
    private Instant endDate;

    @JsonProperty("assignee")
    private UserDto assignee;

    @JsonProperty("project")
    private ProjectDto project;
}