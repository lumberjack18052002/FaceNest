package com.NSABCorp.facenest.service;

import com.NSABCorp.facenest.Repositories.MasterDataRepository;
import com.NSABCorp.facenest.Repositories.ProfileRepository;
import com.NSABCorp.facenest.model.DTOs.MasterDataDTO;
import com.NSABCorp.facenest.model.MasterData;
import com.NSABCorp.facenest.model.User;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.TomcatPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final MasterDataRepository masterDataRepository;
    private final ProfileRepository userRepository;

    public DataService(MasterDataRepository masterDataRepository, ProfileRepository userRepository) {
        this.masterDataRepository = masterDataRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void enterDataintoMasterData(MasterDataDTO md) {
        User user = userRepository.findById(md.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));


//        md.setAuthUser(user);
//        md.setEmail(user.getEmail());
//        md.setFullName(dto.getFullName());
//        md.setUsername(dto.getUsername());
//        md.setPhone(dto.getPhone());
//        md.setLocation(dto.getLocation());
//        md.setRole(dto.getRole());
//        md.setProfileCreated(true);

//        if (md.getAuthUser() == null) {
//            throw new IllegalStateException("authUser is NULL before save");
//        }

        int rows = jdbcTemplate.update(
                "UPDATE facenest.user_master\n" +
                        "SET\n" +
                        "    full_name = ?,\n" +
                        "    location = ?,\n" +
                        "    phone = ?,\n" +
                        "    profile_created = ?,\n" +
                        "    role = ?,\n" +
                        "    username = ?\n" +
                        "WHERE id = ?;",
                md.getFullName(), md.getLocation(), md.getPhone(), true, md.getRole(), md.getUsername(), md.getUserId()
        );
        System.out.println(rows);
    }

    public boolean getProfileCreatedStatus(Long id) {
        MasterData md = masterDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return md.isProfileCreated();

    }
}
