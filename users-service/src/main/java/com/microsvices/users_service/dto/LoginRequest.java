package com.microsvices.users_service.dto;

import com.microsvices.users_service.validation.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    
    private String username;
    private String password;
    // private Roles role;
    // private String token;
}

