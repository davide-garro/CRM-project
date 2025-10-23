package com.davidev.account;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AccountSalesAreaId implements Serializable {

    private UUID accountId;

    private UUID salesAreaId;

    protected AccountSalesAreaId() {
    }

    public AccountSalesAreaId(UUID accountId, UUID salesAreaId) {
        this.accountId = accountId;
        this.salesAreaId = salesAreaId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public UUID getSalesAreaId() {
        return salesAreaId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AccountSalesAreaId that)) return false;
        return Objects.equals(this.accountId, that.accountId) && Objects.equals(this.salesAreaId, that.salesAreaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, salesAreaId);
    }

    @Override
    public String toString() {
        return "AccountSalesAreaId{" +
                "accountId=" + accountId +
                ", salesAreaId=" + salesAreaId +
                '}';
    }
}
