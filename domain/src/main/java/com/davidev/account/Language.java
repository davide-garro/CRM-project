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
@Table(name = "[language]", schema = "dbo")
@Access(AccessType.FIELD)
public class Language {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 2, nullable = false)
    @Size(min=2, max = 2, message = "code must have 2 characters")
    @Pattern(regexp = "^[A-Z]{2}$", message = "country code must have 2 uppercase letters")
    private String code;

    @Column(length = 20, unique = true, nullable = false)
    private String culture;

    protected Language() {
    }

    public Language(String code, String culture) {
        this.code = code;
        this.culture = culture;
    }

    public UUID getId() {
        return id;
    }

    public @Size(min = 2, max = 2, message = "code must have 2 characters") @Pattern(regexp = "^[A-Z]{2}$", message = "country code must have 2 uppercase letters") String getCode() {
        return code;
    }

    public String getCulture() {
        return culture;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (Language) object;
        if(this.id != null && that.id != null){
            return Objects.equals(id, that.id);
        }
        return Objects.equals(n(this.culture), n(that.culture));
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : Objects.hash(n(this.culture));
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
