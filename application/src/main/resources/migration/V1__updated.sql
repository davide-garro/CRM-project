ALTER TABLE dbo.partner_role
    ADD etag ROWVERSION;

ALTER TABLE dbo.partner_role
    ADD created_at DATETIME2(3) NOT NULL;

ALTER TABLE dbo.partner_role
    ADD created_by_id UNIQUEIDENTIFIER NOT NULL;

ALTER TABLE dbo.partner_role
    ADD updated_at DATETIME2(3) NULL;

ALTER TABLE dbo.partner_role
    ADD updated_by_id UNIQUEIDENTIFIER NULL;

ALTER TABLE dbo.partner_role
    ADD is_active BIT NOT NULL CONSTRAINT DF_partner_role_is_active DEFAULT (1);

ALTER TABLE dbo.partner_role
    ADD deleted_at DATETIME2(3) NULL;

ALTER TABLE dbo.partner_role
    ADD deleted_by_id UNIQUEIDENTIFIER NULL;

ALTER TABLE dbo.partner_role
    ADD deleted_reason VARCHAR(255) NULL;

ALTER TABLE dbo.partner_role
    ADD CONSTRAINT FK_partner_role_created_by
        FOREIGN KEY (created_by_id) REFERENCES dbo.app_user(id);

ALTER TABLE dbo.partner_role
    ADD CONSTRAINT FK_partner_role_updated_by_id
        FOREIGN KEY (updated_by_id) REFERENCES dbo.app_user(id);

ALTER TABLE dbo.partner_role
    ADD CONSTRAINT FK_partner_role_deleted_by
        FOREIGN KEY (deleted_by_id) REFERENCES dbo.app_user(id);

ALTER TABLE dbo.partner_role
    ADD CONSTRAINT CK_partner_role_updated_at CHECK(updated_at>=created_at);

ALTER TABLE dbo.partner_role
    ADD CONSTRAINT CK_partner_role_deleted_at CHECK(deleted_at>=created_at);

ALTER TABLE dbo.partner_role
    ADD CONSTRAINT CK_partner_role_updated CHECK((updated_at IS NULL AND updated_by_id IS NULL) OR (updated_at IS NOT NULL AND updated_by_id IS NOT NULL));

ALTER TABLE dbo.partner_role
ADD CONSTRAINT CK_partner_role_deleted CHECK (
    (deleted_at IS NULL AND deleted_by_id IS NULL AND deleted_reason IS NULL)
    OR
    (deleted_at IS NOT NULL AND deleted_by_id IS NOT NULL AND deleted_reason IS NOT NULL)
);
ALTER TABLE dbo.partner_role
    ADD CONSTRAINT CK_partner_role_active_deleted CHECK((is_active = 1 AND deleted_at IS NULL) OR (is_active=0 AND deleted_at IS NOT NULL));
CREATE INDEX IX_partner_role_active ON dbo.partner_role(is_active) INCLUDE (id) WHERE is_active = 1;

CREATE INDEX IX_partner_role_code ON dbo.partner_role(code);
CREATE INDEX IX_partner_role_active ON dbo.partner_role(is_active);