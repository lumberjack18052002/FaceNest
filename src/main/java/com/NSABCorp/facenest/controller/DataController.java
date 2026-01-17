package com.NSABCorp.facenest.controller;

import com.NSABCorp.facenest.service.DataService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.NSABCorp.facenest.model.DTOs.MasterDataDTO;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MasterDataDTO request, HttpSession httpSession) {
        System.out.println(request);
        dataService.enterDataintoMasterData(request);
        return ResponseEntity.ok(
                Map.of("message", "Master data created successfully"));
    }
}
