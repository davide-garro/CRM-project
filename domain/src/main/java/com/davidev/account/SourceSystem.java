package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "source_system", schema = "dbo")
@Access(AccessType.FIELD)
public class SourceSystem {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(length = 64, nullable = false, unique = true)
    private String name;

    public SourceSystem() {
    }

    public SourceSystem(String name) {
        this.name = name;
    }

    public SourceSystem(UUID id, String name) {
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
        if (!(object instanceof SourceSystem that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SourceSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
