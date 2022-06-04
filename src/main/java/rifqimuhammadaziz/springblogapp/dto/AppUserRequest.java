package rifqimuhammadaziz.springblogapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import rifqimuhammadaziz.springblogapp.model.entity.AppUserRole;
import rifqimuhammadaziz.springblogapp.validator.PasswordEqualConstraint;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@PasswordEqualConstraint(message = "Retype Password invalid")
public class AppUserRequest {

    @NotEmpty(message = "Name is required")
    @Size(min = 3, message = "Name length must be min 3 letter")
    private String fullName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;

    @NotEmpty(message = "Retype password is required")
    private String retypePassword;

    private AppUserRole appUserRole;

    protected Date createdDate;

}
