package com.davidev.repository;

import com.davidev.account.PartnerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface PartnerRoleRepository extends JpaRepository<PartnerRole, UUID>, JpaSpecificationExecutor<PartnerRole> {

    @Query("SELECT pr FROM PartnerRole pr WHERE LOWER(pr.code) LIKE LOWER(CONCAT('%',:code,'%'))")
    public List<PartnerRole> searchPartnerRoleByCode(@Param(value = "code") String code);
}