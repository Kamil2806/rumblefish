package com.rumblefish.recruitmenttask.infra.db;

import com.rumblefish.recruitmenttask.domain.User;
import com.rumblefish.recruitmenttask.domain.UserRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository userRepository;

    @Override
    public User save(User user) {
        UserEntity createdUserEntity = userRepository.save(UserEntity.from(user.getName()));
        return userFrom(createdUserEntity);
    }

    @Override
    public Optional<User> get(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        return userEntity != null ? Optional.of(userFrom(userEntity)) : Optional.empty();
    }

    private User userFrom(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getName());
    }
}
