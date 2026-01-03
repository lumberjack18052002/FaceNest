package com.NSABCorp.facenest.controller;


import com.NSABCorp.facenest.model.Profile;
import com.NSABCorp.facenest.model.ProfileRequestDTO;
import com.NSABCorp.facenest.model.ProfileResponseDTO;
import com.NSABCorp.facenest.service.ProfileAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileAccessService profileService;

    @PostMapping("/createProfile")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProfileResponseDTO> createProfile(@RequestBody ProfileRequestDTO profile)
    {
        return profileService.saveProfile(profile);
    }

    @GetMapping("/findprofile/{id}")
    public ResponseEntity<ProfileResponseDTO> findProfile(@PathVariable Long id)
    {
        return profileService.getProfileById(id);
    }

    @PutMapping("/updateprofile/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProfileResponseDTO> UpdateProfile(@PathVariable Long id, @RequestBody ProfileRequestDTO profilerequestDTO)
    {
         return ResponseEntity.ok(profileService.updateProfile(id,profilerequestDTO));
    }

    @GetMapping("/allprofiles")
    public List<ProfileResponseDTO> findProfile()
    {
        return profileService.getAllProfiles();
    }

    @DeleteMapping("/deleteprofile")
    public ResponseEntity<Void> deleteProfile(@RequestParam(value="id")Long id)
    {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
