package com.davidev.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.davidev.util.Util.n;

@Entity
@Access(AccessType.FIELD)
@Table(name = "account", schema = "dbo", indexes = {
        @Index(name = "UX_account_vat_country", columnList = "vat_number, country_id", unique = true)
})
public class Account {

    @Id
    @Generated(event = EventType.INSERT)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()", updatable = false)
    private UUID id;

    @Column(name = "external_id", length = 128, nullable = false, unique = true)
    private String externalId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "source_system_id", nullable = false)
    private SourceSystem sourceSystem;

    @Column(name = "is_synchronized")
    private boolean isSynchronized;

    @Column(name = "is_master")
    private boolean isMaster;

    @Column(name = "vat_number", length = 32, nullable = false)
    private String vatNumber;

    @Column(name = "domestic_vat_number", length = 32)
    private String domesticVatNumber;

    @Column(name = "account_name", length = 200, nullable = false)
    private String accountName;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", nullable = false)
    private Sector sector;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_type_id", nullable = false)
    private AccountType accountType;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "firm_size_id", nullable = false)
    private Size firmSize;

    @Column(name = "annual_turnover")
    private BigDecimal annualTurnover;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "turnover_currency_id", nullable = false)
    private Currency turnoverCurrency;

    @Column(length = 32)
    private String phone;

    @Column(length = 32)
    private String fax;

    @Column(length = 254)
    private String email;

    @Column(length = 2048)
    private String website;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_terms_id", nullable = false)
    private PaymentTerms paymentTerms;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "default_currency_id", nullable = false)
    private Currency defaultCurrency;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    @Column(name = "block_reason")
    private String blockReason;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private AppUser createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by_id")
    private AppUser updatedBy;

    @OneToMany(mappedBy = "account_id")
    private List<AccountAddress> accountAddressList = new ArrayList<>();

    @OneToMany(mappedBy = "account_id")
    private List<AccountSalesArea> salesAreaList = new ArrayList<>();

    @OneToMany(mappedBy = "account_id")
    private List<AccountPartnerRole> partnerRoleList = new ArrayList<>();

    protected Account() {
    }

    public Account(String externalId, SourceSystem sourceSystem, boolean isSynchronized, boolean isMaster, String vatNumber, String domesticVatNumber, String accountName, Sector sector, AccountType accountType, Status status, Size firmSize, BigDecimal annualTurnover, Currency turnoverCurrency, String phone, String fax, String email, String website, Language language, Country country, PaymentTerms paymentTerms, BigDecimal creditLimit, Currency defaultCurrency, boolean isBlocked, String blockReason, LocalDateTime createdAt, AppUser createdBy, LocalDateTime updatedAt, AppUser updatedBy) {
        this.externalId = externalId;
        this.sourceSystem = sourceSystem;
        this.isSynchronized = isSynchronized;
        this.isMaster = isMaster;
        this.vatNumber = vatNumber;
        this.domesticVatNumber = domesticVatNumber;
        this.accountName = accountName;
        this.sector = sector;
        this.accountType = accountType;
        this.status = status;
        this.firmSize = firmSize;
        this.annualTurnover = annualTurnover;
        this.turnoverCurrency = turnoverCurrency;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.website = website;
        this.language = language;
        this.country = country;
        this.paymentTerms = paymentTerms;
        this.creditLimit = creditLimit;
        this.defaultCurrency = defaultCurrency;
        this.isBlocked = isBlocked;
        this.blockReason = blockReason;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public Account(UUID id, String externalId, SourceSystem sourceSystem, boolean isSynchronized, boolean isMaster, String vatNumber, String domesticVatNumber, String accountName, Sector sector, AccountType accountType, Status status, Size firmSize, BigDecimal annualTurnover, Currency turnoverCurrency, String phone, String fax, String email, String website, Language language, Country country, PaymentTerms paymentTerms, BigDecimal creditLimit, Currency defaultCurrency, boolean isBlocked, String blockReason, LocalDateTime createdAt, AppUser createdBy, LocalDateTime updatedAt, AppUser updatedBy) {
        this.id = id;
        this.externalId = externalId;
        this.sourceSystem = sourceSystem;
        this.isSynchronized = isSynchronized;
        this.isMaster = isMaster;
        this.vatNumber = vatNumber;
        this.domesticVatNumber = domesticVatNumber;
        this.accountName = accountName;
        this.sector = sector;
        this.accountType = accountType;
        this.status = status;
        this.firmSize = firmSize;
        this.annualTurnover = annualTurnover;
        this.turnoverCurrency = turnoverCurrency;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.website = website;
        this.language = language;
        this.country = country;
        this.paymentTerms = paymentTerms;
        this.creditLimit = creditLimit;
        this.defaultCurrency = defaultCurrency;
        this.isBlocked = isBlocked;
        this.blockReason = blockReason;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public UUID getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public SourceSystem getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(SourceSystem sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public boolean isSynchronized() {
        return isSynchronized;
    }

    public void setSynchronized(boolean aSynchronized) {
        isSynchronized = aSynchronized;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public void setMaster(boolean master) {
        isMaster = master;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getDomesticVatNumber() {
        return domesticVatNumber;
    }

    public void setDomesticVatNumber(String domesticVatNumber) {
        this.domesticVatNumber = domesticVatNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Size getFirmSize() {
        return firmSize;
    }

    public void setFirmSize(Size firmSize) {
        this.firmSize = firmSize;
    }

    public BigDecimal getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(BigDecimal annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public Currency getTurnoverCurrency() {
        return turnoverCurrency;
    }

    public void setTurnoverCurrency(Currency turnoverCurrency) {
        this.turnoverCurrency = turnoverCurrency;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public PaymentTerms getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(PaymentTerms paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getBlockReason() {
        return blockReason;
    }

    public void setBlockReason(String blockReason) {
        this.blockReason = blockReason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public AppUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(AppUser createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AppUser getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(AppUser updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<AccountAddress> getAccountAddressList() {
        return accountAddressList;
    }

    public void setAccountAddressList(List<AccountAddress> accountAddressList) {
        if (accountAddressList != null){
            this.accountAddressList = accountAddressList;
        }
    }

    public List<AccountSalesArea> getSalesAreaList() {
        return salesAreaList;
    }

    public void setSalesAreaList(List<AccountSalesArea> salesAreaList) {
        if(salesAreaList != null){
            this.salesAreaList = salesAreaList;
        }
    }

    public List<AccountPartnerRole> getPartnerRoleList() {
        return partnerRoleList;
    }

    public void setPartnerRoleList(List<AccountPartnerRole> partnerRoleList) {
        if(partnerRoleList != null){
            this.partnerRoleList = partnerRoleList;
        }
    }

    private void addToCollectionField(Object object){
            switch (object){
                case null -> throw new IllegalArgumentException("Cannot add a null value to the collection");
                case AccountAddress accountAddress-> this.getAccountAddressList().add(accountAddress);
                case AccountSalesArea accountSalesArea -> this.getSalesAreaList().add(accountSalesArea);
                case AccountPartnerRole accountPartnerRole -> this.getPartnerRoleList().add(accountPartnerRole);
                default -> throw new IllegalArgumentException("Cannot add object to the collection: invalid type object, expected one of the following: AccountAddress, AccountSalesArea, AccountPartnerRole");
            }
    }

    private void removeFromCollection(Object object){
        if(object == null){
            throw new IllegalArgumentException("Cannot remove null value from the collection");
        }
        switch (object){
            case AccountAddress accountAddress->
                    this
                            .getAccountAddressList()
                            .removeIf((item -> {
                                if(item.getAccountAddressId() == null){
                                    throw new IllegalStateException("Cannot remove AccountAddress object from the collection: id cannot be null");
                                }
                                return item.getAccountAddressId().equals(accountAddress.getAccountAddressId());
                            }));
            case AccountSalesArea accountSalesArea->
                    this
                            .getSalesAreaList()
                            .removeIf(item->{
                                if(item.getAccountSalesAreaId() == null){
                                    throw new IllegalStateException("Cannot remove AccountSalesArea object from the collection: id cannot be null");
                                }
                                return item.getAccountSalesAreaId().equals(accountSalesArea.getAccountSalesAreaId());
                            });
            case AccountPartnerRole accountPartnerRole->
                    this
                            .getPartnerRoleList()
                            .removeIf(item->{
                                if(item.getAccountPartnerRoleId() == null){
                                    throw new IllegalStateException("Cannot remove AccountPartnerRole object from the collection: id cannot be null");
                                }
                                return item.getAccountPartnerRoleId().equals(accountPartnerRole.getAccountPartnerRoleId());
                            });
            default->
                    throw new IllegalArgumentException("cannot remove object from the collection: invalid object type,expected one of the following: AccountAddress, AccountSalesArea, AccountPartnerRole");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(object == null || org.hibernate.Hibernate.getClass(this) != org.hibernate.Hibernate.getClass(object)) return false;
        var that = (Account) object;
        if(this.id != null && that.id != null){
            return Objects.equals(this.id, that.id);
        }
        return Objects.equals(n(this.vatNumber), n(that.vatNumber)) && Objects.equals((this.country != null ? this.country.getId() : null), (that.country != null ? that.country.getId() : null));
    }

    @Override
    public int hashCode() {
        return this.id != null ? this.id.hashCode() : Objects.hash(n(this.vatNumber), (this.country != null ? this.country.getId() : null));
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", externalId='" + externalId + '\'' +
                ", sourceSystem=" + sourceSystem +
                ", isSynchronized=" + isSynchronized +
                ", isMaster=" + isMaster +
                ", vatNumber='" + vatNumber + '\'' +
                ", domesticVatNumber='" + domesticVatNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", sector=" + (sector != null ? sector.getName() : null) +
                ", accountType=" + (accountType != null ? accountType.getName() : null) +
                ", status=" + (status != null ? status.getName() : null) +
                ", firmSize=" + firmSize +
                ", annualTurnover=" + annualTurnover +
                ", turnoverCurrency=" + (turnoverCurrency != null ? turnoverCurrency.getName() : null) +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", language=" + (language != null ? language.getCode() : null)+
                ", country=" + (country!= null ? country.getCountry() : null) +
                ", paymentTerms=" + (paymentTerms != null ? paymentTerms.getName() : null) +
                ", creditLimit=" + creditLimit +
                ", defaultCurrency=" + defaultCurrency +
                ", isBlocked=" + isBlocked +
                ", blockReason='" + blockReason + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy=" + createdBy +
                ", updatedAt=" + updatedAt +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
