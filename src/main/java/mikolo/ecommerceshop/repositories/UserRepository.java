package mikolo.ecommerceshop.repositories;

import mikolo.ecommerceshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findUserByEmail(String email);
    User findByEmail(String email);
}
