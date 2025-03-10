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
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet
public class LoginServlet extends HttpServlet {

    RegistrationService registrationService = new RegistrationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        response.setContentType("text/html");
        HttpSession httpSession = request.getSession();


        try {
            DatabaseConfig.loadProperties(request.getServletContext());
            User userDetails = registrationService.findRegistrationDetailsByUserDetails(user);
            if (PasswordUtil.checkPassword(user.getPassword(), userDetails.getPassword())) {
                httpSession.setAttribute("user",userDetails);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/quiz-instructions.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("isValidUser", false);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
                requestDispatcher.forward(request, response);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
