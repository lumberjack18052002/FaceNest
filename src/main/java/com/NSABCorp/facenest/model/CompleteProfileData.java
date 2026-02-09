package com.NSABCorp.facenest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "CompleteProfile")
@Data
@NoArgsConstructor
public class CompleteProfileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dob;
    private String gender;

    @Column(length = 500)
    private String bio;

    private String profilePicturePath;

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
