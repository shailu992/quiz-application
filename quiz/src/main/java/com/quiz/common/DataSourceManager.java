package com.quiz.common;

import com.quiz.configuration.DatabaseConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.servlet.ServletContext;

import javax.sql.DataSource;

public class DataSourceManager {
    private static HikariDataSource dataSource;

    private DataSourceManager() {

    }

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DataSourceManager.class) {
                if (dataSource == null) {
                    HikariConfig config = new HikariConfig();
                    config.setJdbcUrl(DatabaseConfig.getProperty("db.url")); // Change DB URL
                    config.setUsername(DatabaseConfig.getProperty("db.username")); // Change Username
                    config.setPassword(DatabaseConfig.getProperty("db.password")); // Change Password
                    config.setDriverClassName(DatabaseConfig.getProperty("db.driverClass"));

                    // Optional Pool Configurations
                    config.setMaximumPoolSize(10);
                    config.setMinimumIdle(5);
                    config.setIdleTimeout(30000);
                    config.setMaxLifetime(1800000);
                    config.setConnectionTimeout(30000);

                    dataSource = new HikariDataSource(config);
                }
            }
        }
        return dataSource;
    }

    public static void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
