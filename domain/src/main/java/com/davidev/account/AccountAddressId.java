package com.davidev.account;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AccountAddressId implements Serializable {

    private UUID accountId;

    private UUID addressId;

    protected AccountAddressId() {
    }

    public AccountAddressId(UUID accountId, UUID addressId) {
        this.accountId = accountId;
        this.addressId = addressId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public UUID getAddressId() {
        return addressId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AccountAddressId that)) return false;
        return Objects.equals(this.accountId, that.accountId) && Objects.equals(this.addressId, that.addressId);
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
