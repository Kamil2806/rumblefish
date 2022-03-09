package com.rumblefish.recruitmenttask.app;

import com.rumblefish.recruitmenttask.domain.User;
import com.rumblefish.recruitmenttask.infra.CreateUserRequest;
import com.rumblefish.recruitmenttask.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import static java.lang.String.format;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User createUser(CreateUserRequest createUserRequest) {
        return userRepository.save(User.from(createUserRequest));
    }

    public String getGreetings(Long userId) {
        User user = userRepository.get(userId)
                .orElseThrow(() -> new EntityNotFoundException(format("User with given id does not exists, id=%s", userId)));

        return user.getGreetings();
    }
}
