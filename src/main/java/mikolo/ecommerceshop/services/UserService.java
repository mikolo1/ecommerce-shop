package mikolo.ecommerceshop.services;

import lombok.RequiredArgsConstructor;
import mikolo.ecommerceshop.dto.UserDto;
import mikolo.ecommerceshop.entity.User;
import mikolo.ecommerceshop.repositories.UserRepository;
import mikolo.ecommerceshop.utils.UserUtilities;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserUtilities userUtilities;
    private final UserRepository userRepository;

    public User create(UserDto userDto) {
        User user = userUtilities.userDtoToUserEntityConverter(userDto);
        return userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
