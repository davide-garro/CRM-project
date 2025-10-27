package com.davidev.controller;

import com.davidev.PartnerRoleService;
import com.davidev.controller.dto.PartnerRoleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/crm/api/v1")
public class PartnerRoleController {

    private final PartnerRoleService partnerRoleService;

    public PartnerRoleController(PartnerRoleService partnerRoleService) {
        this.partnerRoleService = partnerRoleService;
    }

    @GetMapping("/partner-roles")
    public Page<PartnerRoleDto> getPartnerRoles(Pageable pageable){
        return partnerRoleService
                .paginatedReadAll(pageable.getPageNumber(), pageable.getPageNumber(), pageable.getSort())
                .map(
                        partnerRole -> new PartnerRoleDto(
                                partnerRole.getId(),
                                partnerRole.getCode(),
                                partnerRole.getDescription()
                        )
                );
    }

}
