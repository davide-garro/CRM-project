package com.davidev.repository;

import com.davidev.account.PartnerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PartnerRoleRepository extends JpaRepository<PartnerRole, UUID> {
}
