package com.davidev.controller;

import com.davidev.PartnerRoleService;
import com.davidev.account.PartnerRole;
import com.davidev.controller.dto.PartnerRoleDto;
import com.davidev.controller.dto.PatchPartnerRoleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/crm/api/v1", consumes = MediaType.APPLICATION_JSON_VALUE)
public class PartnerRoleController {

    private final PartnerRoleService partnerRoleService;

    public PartnerRoleController(PartnerRoleService partnerRoleService) {
        this.partnerRoleService = partnerRoleService;
    }

    @GetMapping(value = "/partner-role/{id}")
    public Optional<PartnerRoleDto> getPartnerRoleById(@PathVariable(name = "id") UUID id){
        return partnerRoleService.findPartnerRoleById(id)
                .map(p-> PartnerRoleDto.builder()
                        .withId(p.getId())
                        .withCode(p.getCode())
                        .withDescription(p.getDescription())
                        .withEtag(Arrays.toString(p.getEtag()))
                        .isActive(p.isActive())
                        .createdAt(p.getCreatedAt())
                        .createdBy(p.getCreatedBy().getFullName())
                        .updatedAt(p.getUpdatedAt())
                        .updatedBy(p.getUpdatedBy().getFullName())
                        .deletedAt(p.getDeletedAt())
                        .deletedBy(p.getDeletedBy().getFullName())
                        .deletedReason(p.getDeletedReason())
                        .build()
                );
    }

    @GetMapping(value = "/partner-roles/distinct", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<PartnerRoleDto> getDistinctPartnerRoles(Pageable pageable){
        return partnerRoleService
                .paginatedReadAll(
                        pageable.getPageNumber(),
                        pageable.getPageNumber(),
                        pageable.getSort()
                )
                .map(p -> PartnerRoleDto.builder()
                                .withId(p.getId())
                                .withCode(p.getCode())
                                .withDescription(p.getDescription())
                                .withEtag(Arrays.toString(p.getEtag()))
                                .isActive(p.isActive())
                                .createdAt(p.getCreatedAt())
                                .createdBy(p.getCreatedBy().getFullName())
                                .updatedAt(p.getUpdatedAt())
                                .updatedBy(p.getUpdatedBy().getFullName())
                                .deletedAt(p.getDeletedAt())
                                .deletedBy(p.getDeletedBy().getFullName())
                                .deletedReason(p.getDeletedReason())
                                .build()
                        );
    }
    @PostMapping(value = "/partner-roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public PartnerRoleDto postPartnerRole(@RequestBody PartnerRoleDto partnerRoleDto){
        PartnerRole created = partnerRoleService.savePartnerRole(partnerRoleDto.code(), partnerRoleDto.description());
        return PartnerRoleDto.builder()
                .withId(created.getId())
                .withCode(created.getCode())
                .withDescription(created.getDescription())
                .withEtag(Arrays.toString(created.getEtag()))
                .isActive(created.isActive())
                .createdAt(created.getCreatedAt())
                .createdBy(created.getCreatedBy().getFullName())
                .updatedAt(created.getUpdatedAt())
                .updatedBy(created.getUpdatedBy().getFullName())
                .deletedAt(created.getDeletedAt())
                .deletedBy(created.getDeletedBy().getFullName())
                .deletedReason(created.getDeletedReason())
                .build();
    }

    @PatchMapping(value = "/partner-roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public PartnerRoleDto patchPartnerRole(@RequestBody PatchPartnerRoleDto patchPartnerRoleDto){
            PartnerRole updated =  partnerRoleService.updatePartnerRole(
                    patchPartnerRoleDto.id(),
                    patchPartnerRoleDto.code(),
                    patchPartnerRoleDto.description(),
                    patchPartnerRoleDto.etag()
            );
        return PartnerRoleDto.builder()
                .withId(updated.getId())
                .withCode(updated.getCode())
                .withDescription(updated.getDescription())
                .withEtag(Arrays.toString(updated.getEtag()))
                .isActive(updated.isActive())
                .createdAt(updated.getCreatedAt())
                .createdBy(updated.getCreatedBy().getFullName())
                .updatedAt(updated.getUpdatedAt())
                .updatedBy(updated.getUpdatedBy().getFullName())
                .deletedAt(updated.getDeletedAt())
                .deletedBy(updated.getDeletedBy().getFullName())
                .deletedReason(updated.getDeletedReason())
                .build();
    }

    @PostMapping(value = "/partner-roles/{id}")
    public void deletePartnerRole(@PathVariable(value = "id") UUID id, @RequestBody String deletedReason){
        partnerRoleService.deletePartnerRole(id, deletedReason);
    }

    @GetMapping(value = "/partner-roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<PartnerRoleDto> getPartnerRoleSearchedFiltered(
            @RequestParam(value = "searchTerm", required = false) String searchTerm,
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "isActive", required = false) Boolean isActive,
            @PageableDefault(sort = {"updatedAt"}, direction = Sort.Direction.DESC) Pageable pageable){
        return partnerRoleService
                .searchFilterService(searchTerm,code,isActive,pageable)
                .map(p->PartnerRoleDto.builder()
                        .withId(p.getId())
                        .withCode(p.getCode())
                        .withDescription(p.getDescription())
                        .withEtag(Arrays.toString(p.getEtag()))
                        .isActive(p.isActive())
                        .createdAt(p.getCreatedAt())
                        .createdBy(p.getCreatedBy().getFullName())
                        .updatedAt(p.getUpdatedAt())
                        .updatedBy(p.getUpdatedBy().getFullName())
                        .deletedAt(p.getDeletedAt())
                        .deletedBy(p.getDeletedBy().getFullName())
                        .deletedReason(p.getDeletedReason())
                        .build());
    }
}