package com.davidev.controller.dto;

import java.util.UUID;

public record PatchPartnerRoleDto(UUID id, String code, String description, String etag) {
}
