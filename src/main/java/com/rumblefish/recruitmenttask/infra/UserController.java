package com.rumblefish.recruitmenttask.infra;

import com.rumblefish.recruitmenttask.app.UserService;
import com.rumblefish.recruitmenttask.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(CreateUserRequest createUserRequest) {
        User createdUser = userService.createUser(createUserRequest);
        return ResponseEntity.ok().body(createdUser);
    }

    @GetMapping("/{userId}/greetings")
    public ResponseEntity<String> getUserGreetings(@PathVariable Long userId) {
        String userGreetings = userService.getGreetings(userId);
        return ResponseEntity.ok().body(userGreetings);
    }
}

