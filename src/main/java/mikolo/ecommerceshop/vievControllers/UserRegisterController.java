package mikolo.ecommerceshop.vievControllers;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.dto.UserDto;
import mikolo.ecommerceshop.entity.User;
import mikolo.ecommerceshop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserRegisterController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("newUser", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDto userDto){
        userService.create(userDto);
        return "redirect:/index";
    }
}
