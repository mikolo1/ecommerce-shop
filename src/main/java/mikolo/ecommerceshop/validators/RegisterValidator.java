package mikolo.ecommerceshop.validators;


import mikolo.ecommerceshop.dto.UserDto;
import mikolo.ecommerceshop.entity.User;
import mikolo.ecommerceshop.utils.Consts;
import mikolo.ecommerceshop.utils.MainUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Service
public class RegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto user = (UserDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.userFirstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.userLastName.empty");

        if (StringUtils.isNotBlank(user.getEmail())) {
            boolean match = MainUtils.validateEmailOrPassword(Consts.EMAIL_PATTERN, user.getEmail());
            if (!match) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        } else {
            errors.rejectValue("email", "error.userEmail.empty");
        }

        if (StringUtils.isNotBlank(user.getPassword())) {
            boolean match = MainUtils.validateEmailOrPassword(Consts.PASSWORD_PATTERN, user.getPassword());
            if(!match){
                errors.rejectValue("password", "error.userPasswordIsNotMatch");
            }
        } else {
            errors.rejectValue("password", "error.userPassword.empty");
        }
    }

    public void validateEmailExist(Optional<User> user, Errors errors) {
        if (user.isPresent()) {
            errors.rejectValue("email", "error.userEmailExist");
        }
    }
}
