package com.quiz.service;

import com.quiz.model.User;

import java.sql.SQLException;

public interface RegistrationService {
    User saveRegistrationInformation(User user) throws SQLException;

    User findRegistrationDetailsByUserDetails(User user) throws SQLException;
}
