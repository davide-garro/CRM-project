package com.davidev.account;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Access(AccessType.FIELD)
@Table(name = "account_sales_area", schema = "dbo")
public class AccountSalesArea {
    @EmbeddedId
    private AccountSalesAreaId accountSalesAreaId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("account_id")
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("sales_area_id")
    @JoinColumn(name = "sales_area_id", nullable = false)
    private SalesArea salesArea;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    private int priority;

    @Column(name = "valid_from", nullable = false)
    private LocalDateTime validFrom;

    @Column(name = "valid_to", nullable = false)
    private LocalDateTime validTo;

    public AccountSalesArea() {
    }

    public AccountSalesArea(AccountSalesAreaId accountSalesAreaId, Account account, SalesArea salesArea, boolean isActive, int priority, LocalDateTime validFrom, LocalDateTime validTo) {
        this.accountSalesAreaId = accountSalesAreaId;
        this.account = account;
        this.salesArea = salesArea;
        this.isActive = isActive;
        this.priority = priority;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public AccountSalesAreaId getAccountSalesAreaId() {
        return accountSalesAreaId;
    }

    public void setAccountSalesAreaId(AccountSalesAreaId accountSalesAreaId) {
        this.accountSalesAreaId = accountSalesAreaId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public SalesArea getSalesArea() {
        return salesArea;
    }

    public void setSalesArea(SalesArea salesArea) {
        this.salesArea = salesArea;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
        if (this == object) return true;
        if (!(object instanceof AccountSalesArea that)) return false;
        return Objects.equals(accountSalesAreaId, that.accountSalesAreaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSalesAreaId);
    }
}
