package com.davidev.controller.dto;

import java.util.UUID;

public record PartnerRoleDto(UUID id, String code, String description) {
    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        UUID id;
        String code;
        String description;

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
        public PartnerRoleDto build(){
            return new PartnerRoleDto(this.id,this.code, this.description);
        }

    }
}
