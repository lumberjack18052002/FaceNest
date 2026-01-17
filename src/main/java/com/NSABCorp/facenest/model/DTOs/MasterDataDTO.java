package com.NSABCorp.facenest.model.DTOs;

import lombok.Data;

@Data
public class MasterDataDTO {
    private String username;
    private String fullName;
    private String role;
    private String phone;
    private String location;
    private String email;
    private Long userId;
    boolean profileCreated;
}
