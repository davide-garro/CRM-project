package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;
import org.hibernate.sql.ast.tree.from.CorrelatedTableGroup;

import java.util.Objects;
import java.util.UUID;
import static com.davidev.util.Util.n;

@Entity
@Table(name = "status", schema = "dbo")
@Access(AccessType.FIELD)
public class Status {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 64, nullable = false, unique = true)
    private String name;

    protected Status() {
    }

    public Status(String name) {
        this.name = name;
    }

    public Status(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
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
        if( object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (Status) object;
        if(this.id != null && that.id != null){
            return Objects.equals(this.id, that.id);
        }
        return Objects.equals(n(this.name), n(that.name));
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : Objects.hashCode(n(this.name));
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
