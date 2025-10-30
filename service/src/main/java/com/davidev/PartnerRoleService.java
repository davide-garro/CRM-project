package com.davidev;

import com.davidev.account.AccountPartnerRole;
import com.davidev.account.PartnerRole;
import com.davidev.exception.PartnerRoleNotFoundException;
import com.davidev.exception.PreconditionFailedException;
import com.davidev.repository.PartnerRoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartnerRoleService {

    private final PartnerRoleRepository partnerRoleRepository;

    public PartnerRoleService(PartnerRoleRepository partnerRoleRepository) {
        this.partnerRoleRepository = partnerRoleRepository;
    }

    public Optional<PartnerRole> findPartnerRoleById(UUID id){
        return partnerRoleRepository.findById(id);
    }

    public Page<PartnerRole> paginatedReadAll(int page, int size, Sort sort){
        Pageable pageable = PageRequest.of(page,size, sort);
        return partnerRoleRepository.findAll(pageable);
    }

    public PartnerRole savePartnerRole(String code, String description){
        return partnerRoleRepository.save(new PartnerRole(code, description));
    }
    @Transactional
    public PartnerRole updatePartnerRole(UUID id, String code, String description, String clientEtag){
        var found = partnerRoleRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        String dbEtag = Arrays.toString(found.getEtag());
        if(!clientEtag.equals(dbEtag)){
            throw new PreconditionFailedException("Etag must must!");
        }
        found.setCode(code);
        found.setDescription(description);

        return partnerRoleRepository.save(found);
    }
    @Transactional
    public void deletePartnerRole(UUID id){
        Optional<PartnerRole> found = partnerRoleRepository.findById(id);
        if(found.isEmpty()){
            throw new PartnerRoleNotFoundException("No partner role found for id: " + id);
        }
        List<AccountPartnerRole> dependencies = partnerRoleRepository.retrievePartnerRoleDependencies(id);
        if(dependencies.isEmpty()){
            partnerRoleRepository.deleteById(id);
            return;
        }
        dependencies.forEach(apr -> {
            apr.setActive(false);
            apr.setValidTo(LocalDateTime.now());
        });
    }
}
