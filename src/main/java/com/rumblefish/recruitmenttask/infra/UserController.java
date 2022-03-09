package com.rumblefish.recruitmenttask.infra;

import com.rumblefish.recruitmenttask.app.UserService;
import com.rumblefish.recruitmenttask.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse<User>> createUser(CreateUserRequest createUserRequest) {
        try {
            User createdUser = userService.createUser(createUserRequest);
            return ok().body(new UserResponse<>(createdUser));
        } catch (Exception ex) {
            return badRequest().body(new UserResponse<>(ex.getMessage()));
        }
    }

    @GetMapping("/{userId}/greetings")
    public ResponseEntity<UserResponse<String>> getUserGreetings(@PathVariable Long userId) {
        try {
            String userGreetings = userService.getGreetings(userId);
            return ok().body(new UserResponse<>(userGreetings));
        } catch (Exception ex) {
            return badRequest().body(new UserResponse<>(ex.getMessage()));
        }
    }
}

