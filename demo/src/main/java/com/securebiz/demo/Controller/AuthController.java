package com.securebiz.demo.Controller;

import com.securebiz.demo.security.JwtService;
import com.securebiz.demo.Entity.Role;
import com.securebiz.demo.Entity.User;
import com.securebiz.demo.Repository.RoleRepository;
import com.securebiz.demo.Service.UserService;
import com.securebiz.demo.dto.LoginRequest;
import com.securebiz.demo.dto.RegisterRequest;
import com.securebiz.demo.dto.UserResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserService userService,
                          RoleRepository roleRepository,
                          AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request) {

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRoles(Set.of(userRole));

        User saved = userService.createUser(user);

        return new UserResponse(
                saved.getId(),
                saved.getUsername(),
                saved.getEmail()
        );
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        return jwtService.generateToken(request.getUsername());
    }
}
