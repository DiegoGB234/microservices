package com.microsvices.users_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microsvices.users_service.entity.User;
import com.microsvices.users_service.repository.UserRepository;
import com.microsvices.users_service.validation.Roles;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class UserService implements  UserDetailsService{


    private final UserRepository userRepository;

    private final  PasswordEncoder passwordEncoder;

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRole().name())
                .build();
    }

    // Para registrar usuarios nuevos
    public User register(String username, String rawPassword, Roles role) {
        System.out.println(role);
        User user = new User();

        
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(role);
        return userRepository.save(user);
    }
}
