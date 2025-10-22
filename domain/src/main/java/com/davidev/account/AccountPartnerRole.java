package com.davidev.account;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Access(AccessType.FIELD)
@Table(name = "account_partner_role", schema = "dbo")
public class AccountPartnerRole {
    @EmbeddedId
    private AccountPartnerRoleId accountPartnerRoleId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("accountId")
    @JoinColumn(name = "account_id", nullable = false)
    private Account accountId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("partnerRoleId")
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

    public AccountPartnerRole(AccountPartnerRoleId accountPartnerRoleId, Account accountId, PartnerRole partnerRoleId, boolean isActive, LocalDateTime validFrom, LocalDateTime validTo) {
        this.accountPartnerRoleId = accountPartnerRoleId;
        this.accountId = accountId;
        this.partnerRoleId = partnerRoleId;
        this.isActive = isActive;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public AccountPartnerRoleId getAccountPartnerRoleId() {
        return accountPartnerRoleId;
    }

    public void setAccountPartnerRoleId(AccountPartnerRoleId accountPartnerRoleId) {
        this.accountPartnerRoleId = accountPartnerRoleId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public PartnerRole getPartnerRoleId() {
        return partnerRoleId;
    }

    public void setPartnerRoleId(PartnerRole partnerRoleId) {
        this.partnerRoleId = partnerRoleId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
        if (org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (AccountPartnerRole) object;
        return Objects.equals(accountPartnerRoleId, that.accountPartnerRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountPartnerRoleId);
    }
}
