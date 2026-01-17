package com.NSABCorp.facenest.controller;

import com.NSABCorp.facenest.Repositories.ProfileRepository;
import com.NSABCorp.facenest.model.RegisterRequest;
import com.NSABCorp.facenest.service.CustomUserDetailsService;
import com.NSABCorp.facenest.service.DataService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.NSABCorp.facenest.security.UserPrincipal;


import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final DataService dataService;
    private final CustomUserDetailsService userService;
    private final ProfileRepository profileRepository;

    public AuthController(DataService dataService, CustomUserDetailsService userService, ProfileRepository profileRepository) {
        this.dataService = dataService;
        this.userService = userService;
        this.profileRepository = profileRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (profileRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity
                    .status(409) // CONFLICT
                    .body(Map.of("error", "Email already registered"));
        }
        userService.createUser(request.getEmail(), request.getPassword());
        return ResponseEntity.status(201).build(); // CREATED
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

        if (authentication == null || !authentication.isAuthenticated()
                || !(authentication.getPrincipal() instanceof UserPrincipal principal)) {
            return ResponseEntity.status(401).build();
        }

        boolean profileCreated =
                dataService.getProfileCreatedStatus(principal.getId());

        return ResponseEntity.ok(
                Map.of(
                        "id", principal.getId(),
                        "profileCreated", profileCreated
                )
        );
    }




    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}
