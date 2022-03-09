package com.rumblefish.recruitmenttask.domain;

import com.rumblefish.recruitmenttask.infra.CreateUserRequest;
import lombok.Getter;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

@Getter
public class User {
    private Long id;
    private final String name;

    public User(Long id, String name) {
        checkArgument(isNotBlank(name), "name cannot be blank");
        checkArgument(containOnlyAlphabets(name), "name can contain only alphabets");

        this.id = id;
        this.name = name;
    }

    public static User from(String name) {
        return new User(null, name);
    }

    private static boolean containOnlyAlphabets(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public String greeting() {
        return "Hello " + name;
    }

    public void assignId(Long id) {
        checkArgument(id != null, "id cannot be null");
        this.id = id;
    }
}
