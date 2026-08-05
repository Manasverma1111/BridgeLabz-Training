package com.clinic.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Centralized HikariCP connection pool for the Health Clinic application.
 *
 * Why HikariCP instead of a raw DriverManager/Singleton Connection:
 * Creating a raw JDBC connection is expensive (TCP handshake, auth handshake,
 * session initialization). HikariCP creates a fixed set of connections upfront
 * and lets DAO code borrow/return them, avoiding this repeated overhead and
 * making the application safe for concurrent (multi-threaded) use.
 *
 * connection.close() on a pooled connection does NOT close the physical
 * connection -- it returns it to the pool for reuse.
 */
public final class HikariConnectionPool {

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();

        String url = "jdbc:mysql://localhost:3306/health_clinic_db"
                + "?useSSL=false"
                + "&serverTimezone=UTC"
                + "&allowPublicKeyRetrieval=true"
                + "&characterEncoding=UTF-8"
                + "&rewriteBatchedStatements=true";

        config.setJdbcUrl(url);
        config.setUsername(getEnvOrDefault("DB_USER", "clinic_app_user"));
        config.setPassword(getEnvOrDefault("DB_PASSWORD", "StrongPassword123!"));

        // Pool sizing
        config.setMaximumPoolSize(10);   // max simultaneous connections
        config.setMinimumIdle(5);        // minimum connections kept ready/idle

        // Timeouts
        config.setConnectionTimeout(30000);  // 30 sec -- max wait to get a connection
        config.setIdleTimeout(600000);       // 10 min -- idle connection eviction
        config.setMaxLifetime(1800000);      // 30 min -- max connection lifetime

        // Performance tuning (MySQL-specific prepared statement caching)
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        config.setPoolName("HealthClinicPool");

        dataSource = new HikariDataSource(config);
    }

    private HikariConnectionPool() {
        // prevent instantiation -- static utility class
    }

    private static String getEnvOrDefault(String key, String defaultValue) {
        String value = System.getenv(key);
        return (value == null || value.isBlank()) ? defaultValue : value;
    }

    /** Borrows a connection from the pool. Caller must close() it (returns it to the pool). */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /** Shuts down the pool cleanly. Call once on application exit. */
    public static void closePool() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
}
