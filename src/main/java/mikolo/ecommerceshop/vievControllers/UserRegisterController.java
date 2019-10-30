package mikolo.ecommerceshop.vievControllers;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.dto.UserDto;
import mikolo.ecommerceshop.entity.User;
import mikolo.ecommerceshop.services.UserService;
import mikolo.ecommerceshop.validators.RegisterValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Locale;

@RequiredArgsConstructor
@Controller
public class UserRegisterController {

    private final UserService userService;
    private final RegisterValidator registerValidator;

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("newUser", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("newUser") UserDto userDto, BindingResult result, Model model, Locale locale) {
        User existing = userService.findByEmail(userDto.getEmail());
        registerValidator.validateEmailExist(existing, result);
        registerValidator.validate(userDto, result);

        if (result.hasErrors()) {
            return "register";
        }
        userService.create(userDto);
        return "index";
    }
}
