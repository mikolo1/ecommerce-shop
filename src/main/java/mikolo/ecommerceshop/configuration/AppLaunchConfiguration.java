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
        Role roleAdmin = roleRepository.findByRole("ADMIN");
        Role roleUser = roleRepository.findByRole("USER");

        if (roleAdmin == null) {
            roleAdmin = new Role(1L, "ADMIN");
            roleRepository.save(roleAdmin);
        }
        if (roleUser == null) {
            roleUser = new Role(2L, "USER");
            roleRepository.save(roleUser);
        }
    }
}
