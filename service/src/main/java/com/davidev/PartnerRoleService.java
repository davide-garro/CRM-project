package com.davidev;

import com.davidev.account.PartnerRole;
import com.davidev.repository.PartnerRoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PartnerRoleService {

    private final PartnerRoleRepository partnerRoleRepository;

    public PartnerRoleService(PartnerRoleRepository partnerRoleRepository) {
        this.partnerRoleRepository = partnerRoleRepository;
    }

    public Page<PartnerRole> paginatedReadAll(int page, int size, Sort sort){
        Pageable pageable = PageRequest.of(page,size, sort);
        return partnerRoleRepository.findAll(pageable);
    }

    public PartnerRole savePartnerRole(PartnerRole partnerRole){
        return partnerRoleRepository.save(new PartnerRole(partnerRole.getCode(), partnerRole.getDescription()));
    }
}
