package springbootcrudjpabuddy.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import springbootcrudjpabuddy.entities.User;

/**
 * DTO for {@link User}
 */
@Value
public class UserDto implements Serializable {

    Long id;

    @NotNull
    String username;

    @NotNull
    String password;

    @Email(message = "Please provide a valid email")
    String email;
}