/* =========================
   1) Core lookup tables
   ========================= */

CREATE TABLE dbo.source_system (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE dbo.status (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE dbo.sector (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE dbo.account_type (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE dbo.size (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  [range]  VARCHAR(20)  NOT NULL,
  label    VARCHAR(32)  NOT NULL,
  segment  VARCHAR(32)  NOT NULL
);
CREATE INDEX IX_size_lbl_rng_seg ON dbo.size(label, [range], segment);

CREATE TABLE dbo.payment_terms (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  code VARCHAR(16) NOT NULL UNIQUE,
  name VARCHAR(64) NOT NULL
);

CREATE TABLE dbo.currency (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  name VARCHAR(32) NOT NULL UNIQUE,
  code CHAR(3) NOT NULL UNIQUE
);

CREATE TABLE dbo.[language] (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  code CHAR(2) NOT NULL,
  culture VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE dbo.address_type (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  [value] VARCHAR(32) NOT NULL UNIQUE
);

CREATE TABLE dbo.country (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  code CHAR(3) NOT NULL UNIQUE,
  name VARCHAR(100) NOT NULL UNIQUE
);

/* =========================
   2) Master & address
   ========================= */

CREATE TABLE dbo.address (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  address_type_id UNIQUEIDENTIFIER NOT NULL,
  attention VARCHAR(100) NULL,
  street VARCHAR(200) NOT NULL,
  city VARCHAR(100) NOT NULL,
  state_region VARCHAR(100) NOT NULL,
  zipcode VARCHAR(20) NOT NULL,
  country_id UNIQUEIDENTIFIER NOT NULL
);

CREATE TABLE dbo.app_user (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  [subject]  VARCHAR(255) NOT NULL UNIQUE,
  email      VARCHAR(254) NOT NULL UNIQUE,
  username   VARCHAR(64)  NOT NULL UNIQUE,
  full_name  VARCHAR(150) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name  VARCHAR(100) NOT NULL,
  [group]    VARCHAR(64)  NULL
);

CREATE TABLE dbo.sales_area (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  market   VARCHAR(32) NULL,
  channel  VARCHAR(32) NULL,
  sales_org VARCHAR(32) NULL,
  division VARCHAR(32) NULL
);

CREATE UNIQUE INDEX UX_sales_area_dims ON dbo.sales_area(market, channel, sales_org, division);

CREATE TABLE dbo.partner_role (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  code VARCHAR(32) NOT NULL UNIQUE,
  [description] VARCHAR(255) NULL
);

CREATE TABLE dbo.account (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  external_id VARCHAR(128) NOT NULL UNIQUE,
  source_system_id UNIQUEIDENTIFIER NOT NULL,
  is_synchronized BIT NOT NULL CONSTRAINT DF_account_is_sync DEFAULT (0),
  is_master BIT NOT NULL CONSTRAINT DF_account_is_master DEFAULT (0),
  vat_number VARCHAR(32) NOT NULL,
  domestic_vat_number VARCHAR(32) NULL,
  account_name VARCHAR(200) NOT NULL,
  sector_id UNIQUEIDENTIFIER NOT NULL,
  account_type_id UNIQUEIDENTIFIER NOT NULL,
  status_id UNIQUEIDENTIFIER NOT NULL,
  firm_size_id UNIQUEIDENTIFIER NULL,
  annual_turnover DECIMAL(19,4) NULL,
  turnover_currency_id UNIQUEIDENTIFIER NULL,
  phone VARCHAR(32) NULL,
  fax   VARCHAR(32) NULL,
  email VARCHAR(254) NULL,
  website VARCHAR(2048) NULL,
  language_id UNIQUEIDENTIFIER NOT NULL,
  country_id  UNIQUEIDENTIFIER NOT NULL,
  payment_terms_id UNIQUEIDENTIFIER NOT NULL,
  credit_limit DECIMAL(19,4) NULL,
  default_currency_id UNIQUEIDENTIFIER NULL,
  is_blocked BIT NOT NULL CONSTRAINT DF_account_is_blocked DEFAULT (0),
  block_reason VARCHAR(255) NULL,
  created_at DATETIME2(3) NOT NULL CONSTRAINT DF_account_created_at DEFAULT SYSUTCDATETIME(),
  created_by_id UNIQUEIDENTIFIER NOT NULL,
  updated_at DATETIME2(3) NULL,
  updated_by_id UNIQUEIDENTIFIER NULL
);

CREATE UNIQUE INDEX UX_account_vat_country ON dbo.account(vat_number, country_id);

/* =========================
   3) Assignment tables
   ========================= */

CREATE TABLE dbo.account_address (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  account_id UNIQUEIDENTIFIER NOT NULL,
  address_id UNIQUEIDENTIFIER NOT NULL,
  is_active  BIT NOT NULL CONSTRAINT DF_acc_addr_is_active DEFAULT (0),
  is_primary BIT NOT NULL CONSTRAINT DF_acc_addr_is_primary DEFAULT (0),
  valid_from DATETIME2(3) NOT NULL,
  valid_to   DATETIME2(3) NULL,
  CONSTRAINT CK_account_address_dates CHECK(valid_to IS NULL OR valid_to > valid_from),
  CONSTRAINT CK_account_address_active_dates CHECK (is_primary = 0 OR (is_active = 1 AND valid_to IS NULL));,
  CONSTRAINT UX_account_address_version UNIQUE(account_id, address_id, valid_from)
);
CREATE UNIQUE INDEX IX_account_address_primary ON dbo.account_address(account_id, address_id) WHERE is_primary = 1 AND is_active = 1;
CREATE UNIQUE INDEX IX_account_address_active ON dbo.account_address(account_id, address_id) WHERE valid_to IS NULL;

CREATE TABLE dbo.account_sales_area (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  account_id UNIQUEIDENTIFIER NOT NULL,
  sales_area_id UNIQUEIDENTIFIER NOT NULL,
  is_active BIT NOT NULL CONSTRAINT DF_acc_sa_is_active DEFAULT (0),
  priority  INT NULL,
  valid_from DATETIME2(3) NOT NULL,
  valid_to   DATETIME2(3) NULL,
  CONSTRAINT CK_account_sales_area_priority CHECK (priority IS NULL OR priority >= 0),
  CONSTRAINT CK_account_sales_area_dates CHECK(valid_to IS NULL OR valid_to > valid_from),
  CONSTRAINT CK_account_sales_area_active CHECK((valid_to IS NULL AND is_active=1) OR (valid_to IS NOT NULL AND is_active=0)),
  CONSTRAINT UX_account_sales_area_version UNIQUE(account_id, sales_area_id, valid_from)
);

CREATE UNIQUE INDEX IX_account_sales_area_active ON dbo.account_sales_area(account_id, sales_area_id) WHERE valid_to IS NULL;

CREATE TABLE dbo.account_partner_role (
  id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),
  account_id UNIQUEIDENTIFIER NOT NULL,
  partner_role_id UNIQUEIDENTIFIER NOT NULL,
  is_active BIT NOT NULL CONSTRAINT DF_acc_pr_is_active DEFAULT (0),
  valid_from DATETIME2(3) NOT NULL,
  valid_to   DATETIME2(3) NULL,
  CONSTRAINT CK_account_partner_role_dates CHECK(valid_to IS NULL OR valid_to > valid_from),
  CONSTRAINT CK_account_partner_role_active CHECK((valid_to IS NULL AND is_active=1) OR (valid_to IS NOT NULL AND is_active=0)),
  CONSTRAINT UX_account_partner_role_version UNIQUE(account_id, partner_role_id, valid_from)
);

CREATE UNIQUE INDEX IX_account_partner_role_active ON dbo.account_partner_role(account_id, partner_role_id) WHERE valid_to IS NULL;

/* =========================
   4) Foreign keys
   ========================= */

-- address lookups
ALTER TABLE dbo.address
  ADD CONSTRAINT FK_address_type
      FOREIGN KEY (address_type_id) REFERENCES dbo.address_type(id);
ALTER TABLE dbo.address
  ADD CONSTRAINT FK_address_country
      FOREIGN KEY (country_id) REFERENCES dbo.country(id);

-- account lookups
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_source_system
      FOREIGN KEY (source_system_id) REFERENCES dbo.source_system(id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_sector
      FOREIGN KEY (sector_id) REFERENCES dbo.sector(id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_type
      FOREIGN KEY (account_type_id) REFERENCES dbo.account_type(id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_status
      FOREIGN KEY (status_id) REFERENCES dbo.status(id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_size
      FOREIGN KEY (firm_size_id) REFERENCES dbo.size(id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_turnover_currency
      FOREIGN KEY (turnover_currency_id) REFERENCES dbo.currency(id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_language
      FOREIGN KEY (language_id) REFERENCES dbo.[language](id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_country
      FOREIGN KEY (country_id) REFERENCES dbo.country(id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_payment_terms
      FOREIGN KEY (payment_terms_id) REFERENCES dbo.payment_terms(id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_default_currency
      FOREIGN KEY (default_currency_id) REFERENCES dbo.currency(id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_created_by
      FOREIGN KEY (created_by_id) REFERENCES dbo.app_user(id);
ALTER TABLE dbo.account
  ADD CONSTRAINT FK_account_updated_by
      FOREIGN KEY (updated_by_id) REFERENCES dbo.app_user(id);

-- account_address joins
ALTER TABLE dbo.account_address
  ADD CONSTRAINT FK_acc_addr_account
      FOREIGN KEY (account_id) REFERENCES dbo.account(id);
ALTER TABLE dbo.account_address
  ADD CONSTRAINT FK_acc_addr_address
      FOREIGN KEY (address_id) REFERENCES dbo.address(id);

-- account_sales_area joins
ALTER TABLE dbo.account_sales_area
  ADD CONSTRAINT FK_acc_sa_account
      FOREIGN KEY (account_id) REFERENCES dbo.account(id);
ALTER TABLE dbo.account_sales_area
  ADD CONSTRAINT FK_acc_sa_sales_area
      FOREIGN KEY (sales_area_id) REFERENCES dbo.sales_area(id);

-- account_partner_role joins
ALTER TABLE dbo.account_partner_role
  ADD CONSTRAINT FK_acc_pr_account
      FOREIGN KEY (account_id) REFERENCES dbo.account(id);
ALTER TABLE dbo.account_partner_role
  ADD CONSTRAINT FK_acc_pr_role
      FOREIGN KEY (partner_role_id) REFERENCES dbo.partner_role(id);

/* =========================
   5) Indexes
   ========================= */

-- Accounts: lookups/filters/sorts/search
CREATE INDEX IX_account_status       ON dbo.account(status_id);
CREATE INDEX IX_account_sector       ON dbo.account(sector_id);
CREATE INDEX IX_account_type         ON dbo.account(account_type_id);
CREATE INDEX IX_account_country      ON dbo.account(country_id);
CREATE INDEX IX_account_language     ON dbo.account(language_id);
CREATE INDEX IX_account_payterms     ON dbo.account(payment_terms_id);
CREATE INDEX IX_account_name         ON dbo.account(account_name);
CREATE INDEX IX_account_updated_at   ON dbo.account(updated_at);
CREATE INDEX IX_account_created_at   ON dbo.account(created_at);

-- Assignment tables: current rows & reverse lookups
CREATE INDEX IX_acc_addr_address     ON dbo.account_address(address_id);
CREATE INDEX IX_acc_sa_sales_area    ON dbo.account_sales_area(sales_area_id);
CREATE INDEX IX_acc_pr_role          ON dbo.account_partner_role(partner_role_id);