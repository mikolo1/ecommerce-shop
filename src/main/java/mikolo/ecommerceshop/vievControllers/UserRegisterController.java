package mikolo.ecommerceshop.vievControllers;

import mikolo.ecommerceshop.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegisterController {

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("newUser", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        return "rerirect:/index";
    }
}
