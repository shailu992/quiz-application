package com.quiz.configuration;

import jakarta.servlet.ServletContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DatabaseConfig {

    private static final Logger logger = LogManager.getLogger(DatabaseConfig.class);

    private static Properties properties = new Properties();

    public static void loadProperties(ServletContext context) {
        try {
            String filePath = context.getRealPath("/WEB-INF/database.properties");
            File file = new File(filePath);
            if (!file.exists()) {
                throw new IOException("database properties file not found at:" + filePath);
            }

            try (InputStream inputStream = new FileInputStream(file)) {
                properties.load(inputStream);

            }

        } catch (IOException exception) {
            throw new RuntimeException("Failed to load database properties");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
