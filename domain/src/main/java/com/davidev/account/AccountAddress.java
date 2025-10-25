package com.davidev.account;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "account_address", schema = "dbo")
public class AccountAddress {

    @Id
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false)
    private UUID id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "is_primary", nullable = false)
    private boolean isPrimary;

    @Column(name = "valid_from", nullable = false)
    private LocalDateTime validFrom;

    @Column(name = "valid_to", nullable = false)
    private LocalDateTime validTo;

    protected AccountAddress() {
    }

    public AccountAddress(Account account, Address address, boolean isActive, boolean isPrimary, LocalDateTime validFrom, LocalDateTime validTo) {
        this.account = account;
        this.address = address;
        this.isActive = isActive;
        this.isPrimary = isPrimary;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public UUID getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    @Override
    public boolean equals(Object object) {
       if(this == object) return true;
       if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
       var that = (AccountAddress) object;
       return Objects.equals(this.id,that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AccountAddress{" +
                "id=" + this.id +
                ", isActive=" + isActive +
                ", isPrimary=" + isPrimary +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}
