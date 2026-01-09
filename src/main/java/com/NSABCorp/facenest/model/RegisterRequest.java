package com.NSABCorp.facenest.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class RegisterRequest {
    private String email;
    private String password;

}
