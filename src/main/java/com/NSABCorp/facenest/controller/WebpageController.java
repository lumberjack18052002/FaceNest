package com.NSABCorp.facenest.controller;

import com.NSABCorp.facenest.model.RegisterRequest;
import com.NSABCorp.facenest.service.CustomUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebpageController {
//

    @GetMapping("/profile")
    public String profile() {
        return "You are logged in!";
    }
}
