package com.rumblefish.recruitmenttask.domain;

import lombok.Getter;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

@Getter
public class Greeting {
    private final String message;

    public Greeting(String message) {
        checkArgument(isNotBlank(message), "greeting message cannot be blank");
        this.message = message;
    }
}
