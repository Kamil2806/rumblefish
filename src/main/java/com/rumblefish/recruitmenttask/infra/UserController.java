package com.rumblefish.recruitmenttask.infra;

import com.rumblefish.recruitmenttask.app.UserService;
import com.rumblefish.recruitmenttask.domain.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse<User>> createUser(@RequestBody CreateUserRequest createUserRequest) {
        log.info("creating user started");
        try {
            User createdUser = userService.createUser(createUserRequest);
            log.info("creating user finished");

            return ok().body(new UserResponse<>(createdUser));
        } catch (Exception ex) {
            log.info(format("creating user failed, error=%s", ex.getMessage()));
            return badRequest().body(new UserResponse<>(new ErrorMessage(ex.getMessage())));
        }
    }

    @GetMapping("/{userId}/greeting")
    public ResponseEntity<UserResponse<String>> getUserGreeting(@PathVariable Long userId) {
        log.info("receiving greeting started");
        try {
            String userGreeting = userService.getGreeting(userId);
            log.info("receiving greeting finished");

            return ok().body(new UserResponse<>(userGreeting));
        } catch (Exception ex) {
            log.info("receiving greeting failed", ex);
            return badRequest().body(new UserResponse<>(new ErrorMessage(ex.getMessage())));
        }
    }
}

