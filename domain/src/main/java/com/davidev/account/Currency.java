package com.davidev.account;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "currency", schema = "dbo")
@Access(AccessType.FIELD)
public class Currency {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false)
    private UUID id;

    @Column(length = 3, nullable = false, unique = true, columnDefinition = "CHAR(3)")
    @Size(min = 3, max = 3)
    @Pattern(regexp = "^[A-Z]{3}$", message = "Currency code must be ISO 4217 alpha-3 format (e.g., 'USD')")
    private String code;

    @Column(length = 32, nullable = false, unique = true)
    private String name;

    public Currency() {
    }

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Currency(UUID id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public @Size(min = 3, max = 3) @Pattern(regexp = "^[A-Z]{3}$", message = "Currency code must be ISO 4217 alpha-3 format (e.g., 'USD')") String getCode() {
        return code;
    }

    public void setCode(@Size(min = 3, max = 3) @Pattern(regexp = "^[A-Z]{3}$", message = "Currency code must be ISO 4217 alpha-3 format (e.g., 'USD')") String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Currency currency)) return false;
        return Objects.equals(id, currency.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
