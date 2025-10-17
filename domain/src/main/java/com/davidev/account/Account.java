package com.davidev.account;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "account", schema = "dbo")
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
    @JoinColumn(name = "turnover_currency", nullable = false)
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
    @JoinColumn(name = "created_by")
    private AppUser createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private AppUser updatedBy;
}
