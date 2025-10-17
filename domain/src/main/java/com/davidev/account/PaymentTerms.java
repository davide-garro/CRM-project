package com.davidev.account;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "payment_terms", schema = "dbo")
public class PaymentTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
    private UUID id;

    @Column(length = 16, unique = true, nullable = false)
    private String code;

    @Column(length = 64, nullable = false)
    private String name;

    public PaymentTerms() {
    }

    public PaymentTerms(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public PaymentTerms(UUID id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        if (!(object instanceof PaymentTerms that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name);
    }

    @Override
    public String toString() {
        return "PaymentTerms{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}