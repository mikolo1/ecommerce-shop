package mikolo.ecommerceshop.utils;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.dto.UserDto;
import mikolo.ecommerceshop.entity.Role;
import mikolo.ecommerceshop.entity.User;
import mikolo.ecommerceshop.repositories.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
public class UserUtilities {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public User userDtoToUserEntityConverter(UserDto userDto){
        User user = new User();
        Role role = roleRepository.findByRole("USER");
        user.setCity(userDto.getCity());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Collections.singleton(role));
        return user;
    }

    public static boolean validateEmailOrPassword(String pattern, String data) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(data);
        return m.matches();
    }
}
