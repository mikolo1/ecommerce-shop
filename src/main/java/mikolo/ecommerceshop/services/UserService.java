package mikolo.ecommerceshop.services;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.dto.UserDto;
import mikolo.ecommerceshop.entity.User;
import mikolo.ecommerceshop.repositories.UserRepository;
import mikolo.ecommerceshop.utils.MainUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final MainUtils mainUtils;
    private final UserRepository userRepository;

    public User create(UserDto userDto) {
        User user = mainUtils.userDtoToUserEntityConverter(userDto);
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
}
