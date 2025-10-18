package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "status", schema = "dbo")
@Access(AccessType.FIELD)
public class Status {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(length = 64, nullable = false, unique = true)
    private String name;

    public Status() {
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
        if (!(object instanceof Status status)) return false;
        return Objects.equals(id, status.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
