package tests;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.MSSQLServerContainer;

public class SqlServerContainerExtension implements BeforeAllCallback, AfterAllCallback {
    private static final MSSQLServerContainer<?> DB =
            new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2022-latest").acceptLicense();

    @Override public void beforeAll(ExtensionContext ctx) {
        DB.start();
        System.setProperty("spring.datasource.url", DB.getJdbcUrl());
        System.setProperty("spring.datasource.username", DB.getUsername());
        System.setProperty("spring.datasource.password", DB.getPassword());
    }
    @Override public void afterAll(ExtensionContext ctx) {

    }
}
