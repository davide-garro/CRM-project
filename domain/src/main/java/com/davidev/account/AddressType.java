package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.Objects;
import java.util.UUID;

import static com.davidev.util.Util.n;

@Entity
@Table(name = "address_type", schema = "dbo")
@Access(AccessType.FIELD)
public class AddressType {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false)
    private UUID id;

    @Column(name = "[value]", length = 32, nullable = false, unique = true)
    String value;

    protected AddressType() {
    }

    public AddressType(String value) {
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (AddressType) object;
        if(this.id != null && that.id != null){
            return Objects.equals(id, that.id);
        }
        return Objects.equals(n(this.value), n(that.value));
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : Objects.hash(n(this.value));
    }

    @Override
    public String toString() {
        return "AddressType{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
