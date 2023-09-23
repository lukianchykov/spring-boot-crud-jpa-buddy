package springbootcrudjpabuddy.dto;

import java.io.Serializable;
import java.time.Instant;

import lombok.Value;
import springbootcrudjpabuddy.entities.Task;

/**
 * DTO for {@link Task}
 */
@Value
public class TaskDto implements Serializable {

    Long id;

    String name;

    Instant startDate;

    Instant endDate;
}