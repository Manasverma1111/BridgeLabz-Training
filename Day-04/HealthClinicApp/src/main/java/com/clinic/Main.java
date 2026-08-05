package com.clinic;

import com.clinic.config.HikariConnectionPool;
import com.clinic.ui.ConsoleMenu;

/**
 * Entry point for the Health Clinic Console Application.
 *
 * Architecture: Console UI -> Service Layer (transactions) -> DAO Layer (SQL/JDBC) -> DTO Layer -> MySQL
 */
public class Main {
    public static void main(String[] args) {
        try {
            new ConsoleMenu().run();
        } finally {
            // Ensure the HikariCP pool is shut down cleanly on exit.
            HikariConnectionPool.closePool();
        }
    }
}
