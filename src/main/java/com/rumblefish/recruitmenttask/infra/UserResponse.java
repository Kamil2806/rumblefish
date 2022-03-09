package com.rumblefish.recruitmenttask.infra;

import lombok.Getter;

@Getter
public class UserResponse<T> {
    private final T responseObject;
    private final String errorMessage;

    public UserResponse(T responseObject) {
        this.responseObject = responseObject;
        this.errorMessage = null;
    }

    public UserResponse(String errorMessage) {
        this.responseObject = null;
        this.errorMessage = errorMessage;
    }
}
