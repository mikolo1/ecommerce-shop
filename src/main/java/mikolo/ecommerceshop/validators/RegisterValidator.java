package mikolo.ecommerceshop.validators;

import mikolo.ecommerceshop.dto.AddressDto;
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
        return AddressDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AddressDto addressDto = (AddressDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.firstName", "error.userFirstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.userCity.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.userCountry.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetAndPropertyNumber", "error.userStreet.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "error.userZipCode.empty");

        if (StringUtils.isNotBlank(addressDto.getUser().getEmail())) {
            boolean match = MainUtils.validateEmailOrPassword(Consts.EMAIL_PATTERN, addressDto.getUser().getEmail());
            if (!match) {
                errors.rejectValue("user.email", "error.userEmailIsNotMatch");
            }
        } else {
            errors.rejectValue("user.email", "error.userEmail.empty");
        }

        if (StringUtils.isNotBlank(addressDto.getUser().getPassword())) {
            boolean match = MainUtils.validateEmailOrPassword(Consts.PASSWORD_PATTERN, addressDto.getUser().getPassword());
            if (!match) {
                errors.rejectValue("user.password", "error.userPasswordIsNotMatch");
            }
        } else {
            errors.rejectValue("user.password", "error.userPassword.empty");
        }
    }

    public void validateEmailExist(Optional<User> user, Errors errors) {
        if (user.isPresent()) {
            errors.rejectValue("user.email", "error.userEmailExist");
        }
    }
}
