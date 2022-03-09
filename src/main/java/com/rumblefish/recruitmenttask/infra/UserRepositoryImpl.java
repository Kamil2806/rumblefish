package com.rumblefish.recruitmenttask.infra;

import com.rumblefish.recruitmenttask.domain.User;
import com.rumblefish.recruitmenttask.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> users;
    private Long userId;

    public UserRepositoryImpl() {
        users = new HashMap<>();
        userId = 1L;
    }

    @Override
    public User save(User user) {
        user.assignId(userId++);
        users.put(user.getId(), user);

        return user;
    }

    @Override
    public Optional<User> get(Long userId) {
        return Optional.ofNullable(users.get(userId));
    }
}
