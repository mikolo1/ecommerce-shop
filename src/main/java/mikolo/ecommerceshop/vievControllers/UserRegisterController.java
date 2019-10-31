package mikolo.ecommerceshop.vievControllers;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.dto.AddressDto;
import mikolo.ecommerceshop.entity.User;
import mikolo.ecommerceshop.services.AddressService;
import mikolo.ecommerceshop.services.UserService;
import mikolo.ecommerceshop.validators.RegisterValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class UserRegisterController {

    private final UserService userService;
    private final RegisterValidator registerValidator;
    private final AddressService addressService;

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("newUser", new AddressDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("newUser") AddressDto addressDto, BindingResult result, Model model, Locale locale) {
        Optional<User> existing = userService.findByEmail(addressDto.getUser().getEmail());
        registerValidator.validateEmailExist(existing, result);
        registerValidator.validate(addressDto, result);

        if (result.hasErrors()) {
            return "register";
        }
        addressService.create(addressDto);
        return "index";
    }
}
