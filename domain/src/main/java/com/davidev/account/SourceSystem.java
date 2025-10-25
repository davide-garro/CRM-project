package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.Objects;
import java.util.UUID;
import static com.davidev.util.Util.n;

@Entity
@Table(name = "source_system", schema = "dbo")
@Access(AccessType.FIELD)
public class SourceSystem {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 64, nullable = false, unique = true)
    private String name;

    protected SourceSystem() {
    }

    public SourceSystem(String name) {
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
        if(object == null || org.hibernate.Hibernate.getClass(object) != org.hibernate.Hibernate.getClass(this)) return false;
        var that = (SourceSystem) object;
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
        return "SourceSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
