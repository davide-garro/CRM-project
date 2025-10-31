package com.davidev.controller;

import com.davidev.PartnerRoleService;
import com.davidev.account.PartnerRole;
import com.davidev.controller.dto.PartnerRoleDto;
import com.davidev.controller.dto.PatchPartnerRoleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                        .build()
                );
    }

    @GetMapping(value = "/partner-roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<PartnerRoleDto> getPartnerRoles(Pageable pageable){
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
                .build();
    }

    @PatchMapping(value = "/partner-roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public PatchPartnerRoleDto patchPartnerRole(@RequestBody PatchPartnerRoleDto patchPartnerRoleDto){
            PartnerRole updated =  partnerRoleService.updatePartnerRole(
                    patchPartnerRoleDto.id(),
                    patchPartnerRoleDto.code(),
                    patchPartnerRoleDto.description(),
                    patchPartnerRoleDto.etag()
            );
            return new PatchPartnerRoleDto(updated.getId(),updated.getCode(), updated.getDescription(), Arrays.toString(updated.getEtag()));
    }

    @PostMapping(value = "/partner-roles/{id}")
    public void deletePartnerRole(@PathVariable(value = "id") UUID id, @RequestBody String deletedReason){
        partnerRoleService.deletePartnerRole(id, deletedReason);
    }
}
