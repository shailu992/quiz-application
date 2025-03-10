package com.quiz.dao;

import com.quiz.model.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface RegistrationDao {

    User save(Connection connection, User user) throws SQLException;

    User findRegistrationDetailsByUserDetails(Connection connection,User userDetails) throws SQLException;
}
