package com.NSABCorp.facenest.model;

import lombok.Data;

@Data
public class MasterDataResponseDTO {

    private Long id;
    private String email;
    private String fullName;
    private String username;
    private String phone;
    private String location;
    private String role;
    private boolean profileCreated;

    // getters & setters
}

