package com.davidev.account;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "partner_role", schema = "dbo")
public class PartnerRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(length = 32, nullable = false, unique = true)
    private String code;

    @Column(name = "[description]")
    private String description;

    public PartnerRole() {
    }

    public PartnerRole(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public PartnerRole(UUID id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof PartnerRole that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, description);
    }
}
