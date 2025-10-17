package com.davidev.account;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Access(AccessType.FIELD)
@Table(name = "account", schema = "dbo", indexes = {
        @Index(name = "UX_account_vat_country", columnList = "vat_number, country_id", unique = true)
})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWSEQUENTIALID()")
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

    @OneToMany(mappedBy = "AccountAddress")
    private List<AccountAddress> accountAddressList = new ArrayList<>();

    @OneToMany(mappedBy = "SalesArea")
    private List<SalesArea> salesAreaList = new ArrayList<>();

    public Account() {
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

    public void setId(UUID id) {
        this.id = id;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Account account)) return false;
        return isSynchronized == account.isSynchronized && isMaster == account.isMaster && isBlocked == account.isBlocked && Objects.equals(id, account.id) && Objects.equals(externalId, account.externalId) && Objects.equals(sourceSystem, account.sourceSystem) && Objects.equals(vatNumber, account.vatNumber) && Objects.equals(domesticVatNumber, account.domesticVatNumber) && Objects.equals(accountName, account.accountName) && Objects.equals(sector, account.sector) && Objects.equals(accountType, account.accountType) && Objects.equals(status, account.status) && Objects.equals(firmSize, account.firmSize) && Objects.equals(annualTurnover, account.annualTurnover) && Objects.equals(turnoverCurrency, account.turnoverCurrency) && Objects.equals(phone, account.phone) && Objects.equals(fax, account.fax) && Objects.equals(email, account.email) && Objects.equals(website, account.website) && Objects.equals(language, account.language) && Objects.equals(country, account.country) && Objects.equals(paymentTerms, account.paymentTerms) && Objects.equals(creditLimit, account.creditLimit) && Objects.equals(defaultCurrency, account.defaultCurrency) && Objects.equals(blockReason, account.blockReason) && Objects.equals(createdAt, account.createdAt) && Objects.equals(createdBy, account.createdBy) && Objects.equals(updatedAt, account.updatedAt) && Objects.equals(updatedBy, account.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId, sourceSystem, isSynchronized, isMaster, vatNumber, domesticVatNumber, accountName, sector, accountType, status, firmSize, annualTurnover, turnoverCurrency, phone, fax, email, website, language, country, paymentTerms, creditLimit, defaultCurrency, isBlocked, blockReason, createdAt, createdBy, updatedAt, updatedBy);
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
                ", sector=" + sector +
                ", accountType=" + accountType +
                ", status=" + status +
                ", firmSize=" + firmSize +
                ", annualTurnover=" + annualTurnover +
                ", turnoverCurrency=" + turnoverCurrency +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", language=" + language +
                ", country=" + country +
                ", paymentTerms=" + paymentTerms +
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
