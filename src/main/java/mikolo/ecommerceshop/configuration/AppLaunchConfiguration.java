package mikolo.ecommerceshop.configuration;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.entity.Role;
import mikolo.ecommerceshop.repositories.RoleRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
@Configuration
public class AppLaunchConfiguration {

    private final RoleRepository roleRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadRoles() {
        Role roleAdmin = roleRepository.findByRole("ROLE_ADMIN");
        Role roleUser = roleRepository.findByRole("ROLE_USER");

        if (roleAdmin == null) {
            roleAdmin = new Role(1L, "ROLE_ADMIN");
            roleRepository.save(roleAdmin);
        }
        if (roleUser == null) {
            roleUser = new Role(2L, "ROLE_USER");
            roleRepository.save(roleUser);
        }
    }
}
