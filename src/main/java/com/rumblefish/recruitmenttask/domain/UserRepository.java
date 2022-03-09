package com.rumblefish.recruitmenttask.domain;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> get(Long userId);
}
