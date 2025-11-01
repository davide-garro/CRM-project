package com.davidev.repository;

import com.davidev.account.AccountPartnerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AccountPartnerRoleRepository extends JpaRepository<AccountPartnerRole, UUID> {

    public List<AccountPartnerRole> findByPartnerRoleIdAndIsActiveTrue(@Param(value = "id") UUID id);
}
