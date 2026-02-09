package com.NSABCorp.facenest.Repositories;

import com.NSABCorp.facenest.model.CompleteProfileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompleteProfileRepository extends JpaRepository<CompleteProfileData,Long> {
}
