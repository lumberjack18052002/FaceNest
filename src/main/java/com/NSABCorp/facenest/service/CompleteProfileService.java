package com.NSABCorp.facenest.service;

import com.NSABCorp.facenest.Repositories.CompleteProfileRepository;
import com.NSABCorp.facenest.model.CompleteProfileData;
import com.NSABCorp.facenest.model.DTOs.CompleteProfileDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class CompleteProfileService {

    private CompleteProfileRepository repository;

    void completeProfileService(CompleteProfileRepository repository)
    {
        this.repository=repository;
    }

    public CompleteProfileData saveProfile(
            CompleteProfileDTO request,
            MultipartFile profilePicture
    ) throws IOException {

        CompleteProfileData profile = new CompleteProfileData();

        profile.setDob(LocalDate.parse(request.getDob()));
        profile.setGender(request.getGender());
        profile.setBio(request.getBio());

        profile.setCompany(request.getCompany());
        profile.setJobTitle(request.getJobTitle());
        profile.setSkills(request.getSkills());
        profile.setExperience(request.getExperience());
        profile.setEducation(request.getEducation());

        profile.setInterests(request.getInterests());
        profile.setLanguages(request.getLanguages());
        profile.setLinkedin(request.getLinkedin());
        profile.setGithub(request.getGithub());
        profile.setInstagram(request.getInstagram());
        profile.setPortfolio(request.getPortfolio());

        profile.setPurpose(request.getPurpose());
        profile.setLookingFor(request.getLookingFor());
        profile.setAvailability(request.getAvailability());

        // Save image
        if (profilePicture != null && !profilePicture.isEmpty()) {
            String path = "uploads/" + UUID.randomUUID() + "_" + profilePicture.getOriginalFilename();
            Files.copy(profilePicture.getInputStream(), Paths.get(path));
            profile.setProfilePicturePath(path);
        }

        return repository.save(profile);
    }
}
