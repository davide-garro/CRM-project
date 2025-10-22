package com.davidev.account;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AccountSalesAreaId implements Serializable {

    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @Column(name = "sales_area_id", nullable = false)
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

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public UUID getSalesAreaId() {
        return salesAreaId;
    }

    public void setSalesAreaId(UUID salesAreaId) {
        this.salesAreaId = salesAreaId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AccountSalesAreaId that)) return false;
        return Objects.equals(accountId, that.accountId) && Objects.equals(salesAreaId, that.salesAreaId);
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
