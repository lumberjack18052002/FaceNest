package com.NSABCorp.facenest.Repositories;

import com.NSABCorp.facenest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
