package com.davidev.account;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "account_address", schema = "dbo")
public class AccountAddress {
    @EmbeddedId
    private AccountAddressId accountAddressId = new AccountAddressId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("accountId")
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("addressId")
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

    public AccountAddress(AccountAddressId accountAddressId, Account account, Address address, boolean isActive, boolean isPrimary, LocalDateTime validFrom, LocalDateTime validTo) {
        this.accountAddressId = accountAddressId;
        this.account = account;
        this.address = address;
        this.isActive = isActive;
        this.isPrimary = isPrimary;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public AccountAddressId getAccountAddressId() {
        return accountAddressId;
    }

    public void setAccountAddressId(AccountAddressId accountAddressId) {
        this.accountAddressId = accountAddressId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDateTime validTo) {
        this.validTo = validTo;
    }

    @Override
    public boolean equals(Object object) {
       if(this == object) return true;
       if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
       var that = (AccountAddress) object;
       return Objects.equals(this.accountAddressId,that.accountAddressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountAddressId);
    }

    @Override
    public String toString() {
        return "AccountAddress{" +
                "accountAddressId=" + this.accountAddressId +
                ", isActive=" + isActive +
                ", isPrimary=" + isPrimary +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}
