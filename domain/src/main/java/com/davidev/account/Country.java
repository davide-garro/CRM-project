package com.davidev.account;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;
import java.util.Objects;
import java.util.UUID;
import static com.davidev.util.Util.n;

@Entity
@Table(name = "country", schema = "dbo")
@Access(AccessType.FIELD)
public class Country {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 3, nullable = false, unique = true)
    @Size(min = 3, max = 3, message = "country code must have 3 characters")
    @Pattern(regexp = "^[A-Z]{3}$", message = "country code must have three uppercase letters")
    private String code;

    @Column(length = 100, nullable = false, unique = true)
    private String country;

    protected Country() {
    }

    public Country(String code, String country) {
        this.code = code;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public @Size(min = 3, max = 3, message = "country code must have 3 characters") @Pattern(regexp = "^[A-Z]{3}$", message = "country code must have three uppercase letters") String getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (Country) object;
        if(this.id != null && that.id != null){
            return Objects.equals(this.id, that.id);
        }
        return Objects.equals(n(this.code), n(that.code));
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : Objects.hash(n(this.code));
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
