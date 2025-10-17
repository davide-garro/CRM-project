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


}
