/*Loading child tables*/
-- 1) Source systems
INSERT INTO dbo.source_system (name) VALUES
  ('CRM'),
  ('ERP'),
  ('MANUAL');

-- 2) Status (account lifecycle)
INSERT INTO dbo.status (name) VALUES
  ('ACTIVE'),
  ('INACTIVE'),
  ('PROSPECT'),
  ('SUSPENDED');

-- 3) Sector (sample set)
INSERT INTO dbo.sector (name) VALUES
  ('MANUFACTURING'),
  ('RETAIL'),
  ('TECHNOLOGY'),
  ('HEALTHCARE'),
  ('FINANCIAL SERVICES'),
  ('OTHER');

-- 4) Account types
INSERT INTO dbo.account_type (name) VALUES
  ('DIRECT'),
  ('RESELLER'),
  ('DISTRIBUTOR'),
  ('PARTNER');

-- 5) Employee size ranges
INSERT INTO dbo.size ([range], label, segment) VALUES
  ('1–10',     'Micro',      'SMB'),
  ('11–50',    'Small',      'SMB'),
  ('51–200',   'Medium',     'Mid'),
  ('201–1000', 'Large',      'Enterprise'),
  ('>1000',    'Enterprise', 'Enterprise');

-- 6) Payment terms
INSERT INTO dbo.payment_terms (code, name) VALUES
  ('IMMEDIATE', 'Immediate'),
  ('NET15',     'Net 15 days'),
  ('NET30',     'Net 30 days'),
  ('NET45',     'Net 45 days'),
  ('NET60',     'Net 60 days');

-- 7) Currencies (subset)
INSERT INTO dbo.currency (name, code) VALUES
  ('Euro',           'EUR'),
  ('US Dollar',      'USD'),
  ('British Pound',  'GBP'),
  ('Swiss Franc',    'CHF');

-- 8) Languages
INSERT INTO dbo.[language] (code, culture) VALUES
  ('en', 'en-US'),
  ('it', 'it-IT'),
  ('de', 'de-DE'),
  ('fr', 'fr-FR');

-- 9) Address types
INSERT INTO dbo.address_type ([value]) VALUES
  ('BILLING'),
  ('SHIPPING'),
  ('HQ'),
  ('LEGAL');

-- 10) Countries (ISO-3166 alpha-3 subset)
INSERT INTO dbo.country (code, name) VALUES
  ('ITA', 'Italy'),
  ('USA', 'United States'),
  ('GBR', 'United Kingdom'),
  ('DEU', 'Germany'),
  ('FRA', 'France'),
  ('CHE', 'Switzerland'),
  ('ESP', 'Spain');

-- 11) Partner roles
INSERT INTO dbo.partner_role (code, [description]) VALUES
  ('SOLD_TO',  'Sold-to party'),
  ('BILL_TO',  'Bill-to party'),
  ('SHIP_TO',  'Ship-to party'),
  ('PAYER',    'Payer'),
  ('RESELLER', 'Reseller'),
  ('SUPPORT',  'Support/Service');

-- 12) Sales areas (examples; expand as needed)
INSERT INTO dbo.sales_area (market, channel, sales_org, division) VALUES
  ('EU', 'DIRECT',  'EU_SALES', 'CONSUMER'),
  ('EU', 'CHANNEL', 'EU_SALES', 'B2B'),
  ('NA', 'DIRECT',  'NA_SALES', 'CONSUMER'),
  ('NA', 'CHANNEL', 'NA_SALES', 'B2B');
