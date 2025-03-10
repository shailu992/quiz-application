package com.quiz.daoImpl;

import com.quiz.dao.RegistrationDao;
import com.quiz.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationDaoImpl implements RegistrationDao {

    public RegistrationDaoImpl() {
    }

    @Override
    public User save(Connection connection, User user) throws SQLException {

        String insertQuery = "INSERT INTO USER_INFORMATION (NAME,PASSWORD,ADDRESS,PHONE_NUMBER,EMAIL) VALUES (?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setObject(1, user.getUserName());
            preparedStatement.setObject(2, user.getPassword());
            preparedStatement.setObject(3, user.getAddress());
            preparedStatement.setObject(4, user.getPhoneNumber());
            preparedStatement.setObject(5,user.getEmail());
            preparedStatement.execute();
        }
        return user;
    }

    @Override
    public User findRegistrationDetailsByUserDetails(Connection connection, User userInput) throws SQLException {
        User user = new User();
        String findQuery = "SELECT USER_ID,NAME,ADDRESS,PHONE_NUMBER,PASSWORD FROM USER_INFORMATION WHERE phone_number=? OR email=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(findQuery)) {
            preparedStatement.setObject(1, userInput.getUserName());
            preparedStatement.setObject(2, userInput.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setUserId(resultSet.getInt("USER_ID"));
                user.setUserName(resultSet.getString("NAME"));
                user.setAddress(resultSet.getString("ADDRESS"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setPhoneNumber(resultSet.getLong("PHONE_NUMBER"));
            }
        }
        return user;
    }
}
