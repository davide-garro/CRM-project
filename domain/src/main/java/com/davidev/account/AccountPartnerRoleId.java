package com.davidev.account;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AccountPartnerRoleId implements Serializable {

    private UUID accountId;

    private UUID partnerRoleId;

    protected AccountPartnerRoleId() {
    }

    public AccountPartnerRoleId(UUID accountId, UUID partnerRoleId) {
        this.accountId = accountId;
        this.partnerRoleId = partnerRoleId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public UUID getPartnerRoleId() {
        return partnerRoleId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AccountPartnerRoleId that)) return false;
        return Objects.equals(accountId, that.accountId) && Objects.equals(partnerRoleId, that.partnerRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, partnerRoleId);
    }

    @Override
    public String toString() {
        return "AccountPartnerRoleId{" +
                "accountId=" + accountId +
                ", partnerRoleId=" + partnerRoleId +
                '}';
    }
}