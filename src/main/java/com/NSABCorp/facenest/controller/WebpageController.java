package com.NSABCorp.facenest.controller;

import com.NSABCorp.facenest.model.CompleteProfileData;
import com.NSABCorp.facenest.model.DTOs.CompleteProfileDTO;
import com.NSABCorp.facenest.service.CompleteProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class WebpageController {
    @Autowired
    private CompleteProfileService service;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveProfile(
            @RequestPart("data") CompleteProfileDTO request,
            @RequestPart(value = "profilePicture", required = false) MultipartFile profilePicture
    ) throws IOException {

        CompleteProfileData saved = service.saveProfile(request, profilePicture);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("/profile")
    public String profile() {
        return "You are logged in!";
    }
}
