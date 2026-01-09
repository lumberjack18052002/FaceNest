package com.NSABCorp.facenest.service;

import com.NSABCorp.facenest.Repositories.ProfileRepository;
import com.NSABCorp.facenest.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(ProfileRepository profileRepository,
                                    PasswordEncoder passwordEncoder) {
        this.profileRepository = profileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // USER REGISTRATION
    public User createUser(String email, String plainPassword) {
        String encodedPassword = passwordEncoder.encode(plainPassword);
        User user = new User(email, encodedPassword);
        return profileRepository.save(user);
    }

    // SPRING SECURITY LOGIN (DO NOT CALL MANUALLY)
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = profileRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Email not registered " + email);
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
