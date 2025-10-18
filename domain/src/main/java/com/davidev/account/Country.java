package com.davidev.account;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "country", schema = "dbo")
@Access(AccessType.FIELD)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(length = 3, nullable = false, unique = true)
    @Size(min = 3, max = 3, message = "country code must have 3 characters")
    @Pattern(regexp = "^[A-Z]{3}$", message = "country code must have three uppercase letters")
    private String code;

    @Column(length = 100, nullable = false, unique = true)
    private String country;

    public Country() {
    }

    public Country(String code, String country) {
        this.code = code;
        this.country = country;
    }

    public Country(UUID id, String code, String country) {
        this.id = id;
        this.code = code;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @Size(min = 3, max = 3, message = "country code must have 3 characters") @Pattern(regexp = "^[A-Z]{3}$", message = "country code must have three uppercase letters") String getCode() {
        return code;
    }

    public void setCode(@Size(min = 3, max = 3, message = "country code must have 3 characters") @Pattern(regexp = "^[A-Z]{3}$", message = "country code must have three uppercase letters") String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Country country1)) return false;
        return Objects.equals(id, country1.id) && Objects.equals(code, country1.code) && Objects.equals(country, country1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, country);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
