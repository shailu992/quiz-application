package com.quiz.serviceImpl;

import com.quiz.common.DataSourceManager;
import com.quiz.dao.RegistrationDao;
import com.quiz.daoImpl.RegistrationDaoImpl;
import com.quiz.model.User;
import com.quiz.service.RegistrationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class);

    RegistrationDao registrationDao = new RegistrationDaoImpl();

    @Override
    public User saveRegistrationInformation(User user) throws SQLException {

        Connection conn = null;
        try {
            conn = DataSourceManager.getDataSource().getConnection();
            conn.setAutoCommit(false); // Start Transaction

            registrationDao.save(conn, user);

            conn.commit(); // Commit Transaction
        } catch (SQLException e) {
            if (conn != null) {
                e.printStackTrace();
                logger.error("Connection Rollback");
                conn.rollback(); // Rollback on error
                logger.error("Connection Done");
            }
            throw e;
        } finally {
            if (conn != null) {
                logger.error("Connection closing");
                conn.close(); // Close connection
                logger.error("Connection closed");
            }


        }
        return user;
    }

    @Override
    public User findRegistrationDetailsByUserDetails(User userDetails) throws SQLException {
        Connection conn = null;
        User user = null;
        try {
            conn = DataSourceManager.getDataSource().getConnection();
            user = registrationDao.findRegistrationDetailsByUserDetails(conn, userDetails);
        } catch (SQLException sqlException) {
            logger.error("Exception while finding user details", sqlException.getMessage());
            conn.close();
            logger.error("Connection closed");

        }
        return user;

    }
}
