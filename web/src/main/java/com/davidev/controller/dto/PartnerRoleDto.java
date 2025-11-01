package com.davidev.controller.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PartnerRoleDto(
        UUID id,
        String code,
        String description,
        String etag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updatedAt,
        String updatedBy,
        boolean isActive,
        LocalDateTime deletedAt,
        String deletedBy,
        String deletedReason) {

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        UUID id;
        String code;
        String description;
        String etag;
        LocalDateTime createdAt;
        String createdBy;
        LocalDateTime updatedAt;
        String updatedBy;
        boolean isActive;
        LocalDateTime deletedAt;
        String deletedBy;
        String deletedReason;

        public Builder withId(UUID id){
            this.id = id;
            return this;
        }
        public Builder withCode(String code){
            this.code = code;
            return this;
        }
        public Builder withDescription(String description){
            this.description = description;
            return this;
        }
        public Builder withEtag(String etag){
            this.etag = etag;
            return this;
        }
        public Builder createdAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }
        public Builder createdBy(String createdBy){
            this.createdBy = createdBy;
            return this;
        }
        public Builder updatedAt(LocalDateTime updatedAt){
            this.updatedAt = updatedAt;
            return this;
        }
        public Builder updatedBy(String updatedBy){
            this.updatedBy = updatedBy;
            return this;
        }
        public Builder isActive(boolean isActive){
            this.isActive = isActive;
            return this;
        }
        public Builder deletedAt(LocalDateTime deletedAt){
            this.deletedAt = deletedAt;
            return this;
        }
        public Builder deletedBy(String deletedBy){
            this.deletedBy = deletedBy;
            return this;
        }
        public Builder deletedReason(String deletedReason){
            this.deletedReason = deletedReason;
            return this;
        }

        public PartnerRoleDto build(){
            return new PartnerRoleDto(
                    this.id,
                    this.code,
                    this.description,
                    this.etag,
                    this.createdAt,
                    this.createdBy,
                    this.updatedAt,
                    this.updatedBy,
                    this.isActive,
                    this.deletedAt,
                    this.deletedBy,
                    deletedReason
            );
        }

    }
}
