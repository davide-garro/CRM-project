package com.davidev.repository;

import com.davidev.account.AccountPartnerRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountPartnerRoleRepository extends JpaRepository<AccountPartnerRole, UUID> {
}
