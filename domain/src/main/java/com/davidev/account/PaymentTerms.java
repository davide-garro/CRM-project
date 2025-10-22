package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;
import java.util.Objects;
import java.util.UUID;
import static com.davidev.util.Util.n;

@Entity
@Table(name = "payment_terms", schema = "dbo")
@Access(AccessType.FIELD)
public class PaymentTerms {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 16, nullable = false, unique = true)
    private String code;

    @Column(length = 64, nullable = false)
    private String name;

    protected PaymentTerms() {
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
        if (object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (PaymentTerms) object;
        if(this.id != null && that.id != null){
            return Objects.equals(id, that.id);
        }
        return Objects.equals(n(this.code),n(that.code));
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : Objects.hash(n(this.code));
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