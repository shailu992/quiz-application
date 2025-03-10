package com.quiz.servlet;

import com.quiz.dto.QuestionAnswerDto;
import com.quiz.serviceImpl.QuestionServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StartQuizServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(StartQuizServlet.class);

    private QuestionServiceImpl questionServiceImpl = new QuestionServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<QuestionAnswerDto> questions = null;

        try {

            questions = questionServiceImpl.findAllActiveQuestionOptions();

            // Store the data in request scope and forward to JSP
            request.setAttribute("questions", questions);

            response.setContentType("text/html");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/quizdetails.jsp");
            requestDispatcher.forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
