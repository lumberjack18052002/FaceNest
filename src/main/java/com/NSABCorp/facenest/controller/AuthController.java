package com.NSABCorp.facenest.controller;

import com.NSABCorp.facenest.Repositories.ProfileRepository;
import com.NSABCorp.facenest.model.RegisterRequest;
import com.NSABCorp.facenest.service.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userService;
    private final ProfileRepository profileRepository;

    public AuthController(CustomUserDetailsService userService, ProfileRepository profileRepository) {
        this.userService = userService;
        this.profileRepository = profileRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        userService.createUser(request.getEmail(), request.getPassword());
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(HttpServletRequest request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/emailAvailable")
    public ResponseEntity<?> emailAvailable(@RequestHeader String email )
    {
        if(profileRepository.existsByEmail(email))
        return ResponseEntity.status(200).build();
        else
            return ResponseEntity.status(204).build();
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(200);
    }


    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}
