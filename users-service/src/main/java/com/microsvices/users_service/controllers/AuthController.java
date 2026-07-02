package com.microsvices.users_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsvices.users_service.dto.AuthResponse;
import com.microsvices.users_service.dto.LoginRequest;
import com.microsvices.users_service.dto.RegisterRequest;
import com.microsvices.users_service.entity.User;
import com.microsvices.users_service.repository.UserRepository;
import com.microsvices.users_service.security.JwtUtil;
import com.microsvices.users_service.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
   
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final  JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        // Autentica con Spring Security — lanza excepción si falla
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Si llegamos aquí, las credenciales son válidas
        User user = userRepository.findByUsername(request.getUsername()).get();
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole().name());

        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        System.out.println(request);
        userService.register(request.getUsername(), request.getPassword(), request.getRole());
        return ResponseEntity.ok("Usuario registrado");
    }
}
