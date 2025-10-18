package com.davidev.account;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
@Table(name = "account_partner_role", schema = "dbo")
public class AccountPartnerRole {
    @EmbeddedId
    private AccountPartnerRoleId accountPartnerRoleId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("account_id")
    @JoinColumn(name = "account_id", nullable = false)
    private Account accountId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("partner_role_id")
    @JoinColumn(name = "partner_role_id",nullable = false)
    private PartnerRole partnerRoleId;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "valid_from", nullable = false)
    private LocalDateTime validFrom;

    @Column(name = "valid_to", nullable = false)
    private LocalDateTime validTo;

    public AccountPartnerRole() {
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
}
