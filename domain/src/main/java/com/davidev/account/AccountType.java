package com.davidev.account;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

import static com.davidev.util.Util.n;

@Entity
@Table(name = "account_type", schema = "dbo")
@Access(AccessType.FIELD)
public class AccountType {

    @Id
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false)
    private UUID id;

    @Column(length = 64, nullable = false, unique = true)
    private String name;

    protected AccountType() {
    }

    public AccountType(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (AccountType) object;
        if(this.id != null && that.id != null){
            return Objects.equals(this.id, that.id);
        }
        return Objects.equals(n(this.name), n(that.name));
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : Objects.hash(n(this.name));
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
