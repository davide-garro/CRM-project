package com.davidev.account;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import static com.davidev.util.Util.n;

@Entity
@Table(name = "partner_role", schema = "dbo")
@Access(AccessType.FIELD)
public class PartnerRole {
    @Id
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 32, nullable = false, unique = true)
    private String code;

    @Column(name = "[description]")
    private String description;

    @Version
    private byte[] etag;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", nullable = false, updatable = false)
    private AppUser createdBy;

    @Column(name = "updated_at", nullable = false, updatable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by_id", nullable = false, updatable = false)
    private AppUser updatedBy;

    @Column(name = "is_active", nullable = false, updatable = false)
    private boolean isActive;

    @Column(name = "deleted_at", nullable = false, updatable = false)
    private LocalDateTime deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deleted_by_id", nullable = false, updatable = false)
    private AppUser deletedBy;

    @Column(name = "deleted_reason", nullable = false, updatable = false)
    private String deletedReason;

    protected PartnerRole() {
    }

    public PartnerRole(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public PartnerRole(UUID id, String code, String description, byte[] etag) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.etag = etag;
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getEtag() {
        return etag;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public AppUser getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public AppUser getUpdatedBy() {
        return updatedBy;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public AppUser getDeletedBy() {
        return deletedBy;
    }

    public String getDeletedReason() {
        return deletedReason;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUpdatedBy(AppUser updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void setDeletedBy(AppUser deletedBy) {
        this.deletedBy = deletedBy;
    }

    public void setDeletedReason(String deletedReason) {
        this.deletedReason = deletedReason;
    }

    @PrePersist
    public void createdAtLifeCycleCallback(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void updatedAtLifeCycleCallback(){
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (PartnerRole) object;
        if(this.id != null && that.id != null){
            return Objects.equals(this.id, that.id);
        }
        return Objects.equals(n(this.code), n(that.code));
    }

    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : Objects.hash(n(this.code));
    }

    @Override
    public String toString() {
        return "PartnerRole{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
