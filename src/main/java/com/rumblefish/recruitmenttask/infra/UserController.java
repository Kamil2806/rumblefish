package com.rumblefish.recruitmenttask.infra;

import com.rumblefish.recruitmenttask.app.UserService;
import com.rumblefish.recruitmenttask.domain.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse<User>> createUser(CreateUserRequest createUserRequest) {
        log.info("creating user started");
        try {
            User createdUser = userService.createUser(createUserRequest);
            log.info("creating user finished");

            return ok().body(new UserResponse<>(createdUser));
        } catch (Exception ex) {
            log.info("creating user failed");
            return badRequest().body(new UserResponse<>(ex.getMessage()));
        }
    }

    @GetMapping("/{userId}/greetings")
    public ResponseEntity<UserResponse<String>> getUserGreetings(@PathVariable Long userId) {
        log.info("receiving greetings started");
        try {
            String userGreetings = userService.getGreetings(userId);
            log.info("receiving greetings finished");

            return ok().body(new UserResponse<>(userGreetings));
        } catch (Exception ex) {
            log.info("receiving greetings failed");
            return badRequest().body(new UserResponse<>(ex.getMessage()));
        }
    }
}

