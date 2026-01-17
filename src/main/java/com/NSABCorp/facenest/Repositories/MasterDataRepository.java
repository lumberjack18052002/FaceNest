package com.NSABCorp.facenest.Repositories;

import com.NSABCorp.facenest.model.MasterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterDataRepository extends JpaRepository<MasterData, Long> {
}
