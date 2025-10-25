package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Access(AccessType.FIELD)
@Table(name = "account_partner_role", schema = "dbo")
public class AccountPartnerRole {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account accountId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "partner_role_id",nullable = false)
    private PartnerRole partnerRoleId;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "valid_from", nullable = false)
    private LocalDateTime validFrom;

    @Column(name = "valid_to", nullable = false)
    private LocalDateTime validTo;

    protected AccountPartnerRole() {
    }

    public AccountPartnerRole(Account accountId, PartnerRole partnerRoleId, boolean isActive, LocalDateTime validFrom, LocalDateTime validTo) {
        this.accountId = accountId;
        this.partnerRoleId = partnerRoleId;
        this.isActive = isActive;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public UUID getId() {
        return id;
    }

    public Account getAccountId() {
        return accountId;
    }

    public PartnerRole getPartnerRoleId() {
        return partnerRoleId;
    }

    public boolean isActive() {
        return isActive;
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
        if (org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (AccountPartnerRole) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
