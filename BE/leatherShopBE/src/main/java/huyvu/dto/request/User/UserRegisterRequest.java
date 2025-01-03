package huyvu.dto.request.User;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class UserRegisterRequest {
    private String fullname ;
    @NotBlank @Length(min = 6) @NotBlank
    private String username;
    @NotBlank @Length(min = 6)
    private String password;
}
