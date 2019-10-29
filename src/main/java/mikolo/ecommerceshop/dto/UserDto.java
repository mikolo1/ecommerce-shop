package mikolo.ecommerceshop.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

//    @NotBlank
//    @Max(255)
    private String firstName;

//    @NotBlank
//    @Max(255)
    private String lastName;

    @Email
    private String email;

//    @NotBlank
//    @Min(6)
//    @Max(255)
    private String password;

    private String city;
}
