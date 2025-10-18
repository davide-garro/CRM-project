package com.davidev.account;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "address_type", schema = "dbo")
@Access(AccessType.FIELD)
public class AddressType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(name = "[value]", length = 32, nullable = false, unique = true)
    String value;

    public AddressType() {
    }

    public AddressType(String value) {
        this.value = value;
    }

    public AddressType(UUID id, String value) {
        this.id = id;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AddressType that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AddressType{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
