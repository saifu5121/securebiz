package com.securebiz.demo.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/public")
    public String publicApi(){
        return "Public API - no login required";
    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userApi(){
        return "USER API- logged in user";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminApi(){
        return "ADMIN API- admin only";
    }
}
