package com.securebiz.demo.Controller;

import com.securebiz.demo.Service.UserService;
import com.securebiz.demo.Entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;

    }
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
