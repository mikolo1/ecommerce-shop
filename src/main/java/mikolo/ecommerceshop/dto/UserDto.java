package mikolo.ecommerceshop.dto;

import lombok.Data;
import mikolo.ecommerceshop.entity.IncomingMessagesPreferences;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private String email;

    private IncomingMessagesPreferences incomingMessagesPreferences;

    private String password;
}
