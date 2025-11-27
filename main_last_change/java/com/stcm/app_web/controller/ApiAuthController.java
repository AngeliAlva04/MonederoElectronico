package com.stcm.app_web.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.app_web.entity.Usuario;
import com.stcm.app_web.repository.UserRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiAuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario user) {
        if (userRepository.findByNombre_usuario(user.getNombre_usuario()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Username already exists"));
        }

        user.setContraseña(passwordEncoder.encode(user.getContraseña()));
        // user.setRole("ROLE_USER"); // Rol por defecto
        userRepository.save(user);
        
        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        // La autenticación real se maneja por Spring Security
        // Este endpoint solo devuelve un mensaje de éxito si se llega a él
        return ResponseEntity.ok(Map.of("message", "Login successful"));
    }
}