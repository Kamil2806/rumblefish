package com.rumblefish.recruitmenttask.domain;

import com.rumblefish.recruitmenttask.infra.CreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private Long id;
    private final String name;

    public static User from(CreateUserRequest createUserRequest) {
        return new User(null, createUserRequest.getName());
    }

    public String getGreetings() {
        return "Hello " + name;
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
