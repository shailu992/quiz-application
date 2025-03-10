package com.quiz.servlet;

import com.quiz.configuration.DatabaseConfig;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "DatasourceServlet", loadOnStartup = 1, urlPatterns = {"/init"})
public class DatasourceServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(DatasourceServlet.class);
    private static final long serialVersionUID = 1L;
    private static DataSource dataSource;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            PoolProperties p = new PoolProperties();
            p.setUrl(DatabaseConfig.getProperty("db.url"));
            p.setDriverClassName(DatabaseConfig.getProperty("db.driverClass"));
            p.setUsername(DatabaseConfig.getProperty("db.username"));
            p.setPassword(DatabaseConfig.getProperty("db.password"));

            // Connection Pool Settings
            p.setMaxActive(Integer.parseInt(DatabaseConfig.getProperty("db.maxActive")));
            p.setMaxIdle(Integer.parseInt(DatabaseConfig.getProperty("db.maxIdle")));
            p.setMinIdle(Integer.parseInt(DatabaseConfig.getProperty("db.minIdle")));
            p.setInitialSize(Integer.parseInt(DatabaseConfig.getProperty("db.initialSize")));
            p.setTestOnBorrow(true);
            p.setValidationQuery("SELECT 1");

            dataSource = new DataSource();
            dataSource.setPoolProperties(p);

            // Test Connection
            try (Connection conn = dataSource.getConnection()) {
                if (conn != null) {
                    logger.info("Database connected successfully!");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Error initializing datasource", e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
