package domains.user.http.requests;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SaveUserRequest {

    @NotNull(message = "The name field cannot be null.")
    @Max(value = 100, message = "The name should not have more than 100 characters.")
    private String name;

    @NotNull(message = "The email field cannot be null.")
    @Email(message = "Email should be valid.")
    @Max(value = 100, message = "The email should not have more than 100 characters.")
    private String email;

    @NotNull(message = "The password field cannot be null")
    @Min(value = 8, message = "The password should not have less than 8 characters.")
    @Max(value = 100, message = "The password should not have more than 100 characters.")
    private String password;
}
