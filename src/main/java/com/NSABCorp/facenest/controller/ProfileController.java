package com.NSABCorp.facenest.controller;

import com.NSABCorp.facenest.Repositories.MasterDataRepository;
import com.NSABCorp.facenest.model.MasterData;
import com.NSABCorp.facenest.model.MasterDataResponseDTO;
import com.NSABCorp.facenest.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final MasterDataRepository masterDataRepository;

    public ProfileController(MasterDataRepository masterDataRepository) {
        this.masterDataRepository = masterDataRepository;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMyProfile(Authentication authentication) {

        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();

        MasterData md = masterDataRepository.findById(principal.getId())
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        MasterDataResponseDTO dto = new MasterDataResponseDTO();
        dto.setId(md.getId());
        dto.setEmail(md.getEmail());
        dto.setFullName(md.getFullName());
        dto.setUsername(md.getUsername());
        dto.setPhone(md.getPhone());
        dto.setLocation(md.getLocation());
        dto.setRole(md.getRole());
        dto.setProfileCreated(md.isProfileCreated());

        return ResponseEntity.ok(dto);
    }


}

