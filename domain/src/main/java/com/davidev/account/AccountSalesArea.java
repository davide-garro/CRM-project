package com.davidev.account;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Access(AccessType.FIELD)
@Table(name = "account_sales_area", schema = "dbo")
public class AccountSalesArea {
    @EmbeddedId
    private AccountSalesAreaId accountSalesAreaId = new AccountSalesAreaId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("accountId")
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("salesAreaId")
    @JoinColumn(name = "sales_area_id", nullable = false)
    private SalesArea salesArea;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    private int priority;

    @Column(name = "valid_from", nullable = false)
    private LocalDateTime validFrom;

    @Column(name = "valid_to", nullable = false)
    private LocalDateTime validTo;

    protected AccountSalesArea() {
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
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (AccountSalesArea) object;
        return Objects.equals(this.accountSalesAreaId, that.accountSalesAreaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.accountSalesAreaId);
    }
}
