package com.securebiz.demo.dto;


import lombok.*;

@Getter
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;
}
