package mikolo.ecommerceshop.utils;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.entity.User;
import mikolo.ecommerceshop.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserUtils {

    private final UserService userService;

    public String loggedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        return username;
    }

    public User getUserByUserName() {
        String userName = loggedUser();
        return userService.findByEmail(userName);
    }
}
