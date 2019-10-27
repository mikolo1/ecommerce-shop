package mikolo.ecommerceshop.services;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.entity.Role;
import mikolo.ecommerceshop.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        mikolo.ecommerceshop.entity.User userByEmail = userRepository.findUserByEmail(s).orElseThrow(()-> new UsernameNotFoundException("User with email " + s + "not found."));
//        String rolesString = userByEmail.getRoles().stream().map(Role::getRole).collect(Collectors.joining(","));
//        String[] roles = rolesString.split(",");
        String[] roles = userByEmail.getRoles().stream().map(Role::getRole).toArray(String[]::new);
        UserDetails user = User.withUsername(userByEmail.getEmail()).password(userByEmail.getPassword()).roles(roles).build();
        return user;
    }
}
