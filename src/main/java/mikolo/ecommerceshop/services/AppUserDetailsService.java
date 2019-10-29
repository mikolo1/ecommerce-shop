package mikolo.ecommerceshop.services;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.entity.Role;
import mikolo.ecommerceshop.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        mikolo.ecommerceshop.entity.User userEntity = userRepository.findUserByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User with email " + username + "not found."));
        String[] roles = userEntity.getRoles().stream().map(Role::getRole).toArray(String[]::new);
        return User.withUsername(userEntity.getEmail()).password(userEntity.getPassword()).roles(roles).build();
    }
}
