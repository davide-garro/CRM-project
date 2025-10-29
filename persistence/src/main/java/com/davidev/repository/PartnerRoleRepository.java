package com.davidev.repository;

import com.davidev.account.AccountPartnerRole;
import com.davidev.account.PartnerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PartnerRoleRepository extends JpaRepository<PartnerRole, UUID> {

    @Query("SELECT apr FROM AccountPartnerRole apr WHERE apr.partnerRole.id = :partnerRoleId AND apr.isActive = true")
    public List<AccountPartnerRole> retrievePartnerRoleDependencies(@Param(value = "partnerRoleId") UUID partnerRoleId);
}