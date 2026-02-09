package com.NSABCorp.facenest.model.DTOs;

import lombok.Data;

@Data
public class CompleteProfileDTO {

        private String dob;
        private String gender;
        private String bio;

        private String company;
        private String jobTitle;
        private String skills;
        private Integer experience;
        private String education;

        private String interests;
        private String languages;
        private String linkedin;
        private String github;
        private String instagram;
        private String portfolio;

        private String purpose;
        private String lookingFor;
        private String availability;
}
