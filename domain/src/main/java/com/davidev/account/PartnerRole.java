package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "partner_role", schema = "dbo")
@Access(AccessType.FIELD)
public class PartnerRole {
    @Id
    @Generated(event = EventType.INSERT)
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PartnerRole{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
