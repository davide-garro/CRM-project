package com.davidev.account;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "[language]", schema = "dbo")
@Access(AccessType.FIELD)
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(length = 2, nullable = false)
    @Size(min=2, max = 2, message = "code must have 2 characters")
    @Pattern(regexp = "^[A-Z]{2}$", message = "country code must have 2 uppercase letters")
    private String code;

    @Column(length = 20, unique = true, nullable = false)
    private String culture;

    public Language() {
    }

    public Language(String code, String culture) {
        this.code = code;
        this.culture = culture;
    }

    public Language(UUID id, String code, String culture) {
        this.id = id;
        this.code = code;
        this.culture = culture;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @Size(min = 2, max = 2, message = "code must have 2 characters") @Pattern(regexp = "^[A-Z]{2}$", message = "country code must have 2 uppercase letters") String getCode() {
        return code;
    }

    public void setCode(@Size(min = 2, max = 2, message = "code must have 2 characters") @Pattern(regexp = "^[A-Z]{2}$", message = "country code must have 2 uppercase letters") String code) {
        this.code = code;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Language language)) return false;
        return Objects.equals(id, language.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", culture='" + culture + '\'' +
                '}';
    }
}
