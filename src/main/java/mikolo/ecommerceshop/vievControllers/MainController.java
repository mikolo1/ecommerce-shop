package mikolo.ecommerceshop.vievControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/", "index"})
    public String showMainPage(){
        return "index";
    }

    @GetMapping(value = "/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping(value = "/denied")
    public String showAccesDenidedPage() {
        return "denied";
    }
}
