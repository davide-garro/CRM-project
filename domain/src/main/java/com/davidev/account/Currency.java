package com.davidev.account;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "currency", schema = "dbo")
@Access(AccessType.FIELD)
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(length = 32, nullable = false, unique = true)
    private String name;

    @Column(length = 3, nullable = false, unique = true, columnDefinition = "CHAR(3)")
    @Size(min = 3, max = 3)
    @Pattern(regexp = "^[A-Z]{3}$", message = "currency code must be ISO compliant(alpha 3)")
    private String code;

    public Currency() {
    }

    public Currency(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Currency(UUID id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @Size(min = 3, max = 3) @Pattern(regexp = "^[A-Z]{3}$", message = "currency code must be ISO compliant alpha 3") String getCode() {
        return code;
    }

    public void setCode(@Size(min = 3, max = 3) @Pattern(regexp = "^[A-Z]{3}$", message = "currency code must be ISO compliant alpha 3") String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Currency currency)) return false;
        return Objects.equals(id, currency.id) && Objects.equals(name, currency.name) && Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code);
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
