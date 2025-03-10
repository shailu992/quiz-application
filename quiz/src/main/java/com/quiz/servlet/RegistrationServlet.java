package com.quiz.servlet;

import com.quiz.common.PasswordUtil;
import com.quiz.configuration.DatabaseConfig;
import com.quiz.model.User;
import com.quiz.service.RegistrationService;
import com.quiz.serviceImpl.RegistrationServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet
public class RegistrationServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(RegistrationServlet.class);

    RegistrationService registrationService = new RegistrationServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {

            DatabaseConfig.loadProperties(request.getServletContext());
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");

            User user = new User();
            user.setUserName(username);
            user.setPassword(PasswordUtil.hashPassword(password));
            user.setAddress(address);
            user.setEmail(email);
            user.setPhoneNumber(Long.valueOf(phoneNumber));

            registrationService.saveRegistrationInformation(user);

            request.setAttribute("user", user);
            response.setContentType("text/html");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registrationdetails.jsp");
            requestDispatcher.forward(request, response);

        } catch (SQLException e) {
            logger.error("Exception while Saving Registration Details");
            request.setAttribute("exception", e.getMessage());
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }

    }
}
