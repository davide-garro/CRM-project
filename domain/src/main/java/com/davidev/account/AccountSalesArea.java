package com.davidev.account;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Access(AccessType.FIELD)
@Table(name = "account_sales_area", schema = "dbo")
public class AccountSalesArea {
    @Id
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
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

    public AccountSalesArea(Account account, SalesArea salesArea, boolean isActive, int priority, LocalDateTime validFrom, LocalDateTime validTo) {
        this.account = account;
        this.salesArea = salesArea;
        this.isActive = isActive;
        this.priority = priority;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public UUID getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public SalesArea getSalesArea() {
        return salesArea;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (AccountSalesArea) object;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
