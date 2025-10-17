package com.davidev.account;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AccountAddressId implements Serializable {
    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @Column(name = "address_id", nullable = false)
    private UUID addressId;

    public AccountAddressId() {
    }

    public AccountAddressId(UUID accountId, UUID addressId) {
        this.accountId = accountId;
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AccountAddressId that)) return false;
        return Objects.equals(accountId, that.accountId) && Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, addressId);
    }

    @Override
    public String toString() {
        return "AccountAddressId{" +
                "accountId=" + accountId +
                ", addressId=" + addressId +
                '}';
    }
}
