package com.quiz.servlet;

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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ScoreServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(ScoreServlet.class);
    private QuestionServiceImpl questionServiceImpl = new QuestionServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {

            // Create a Map to store selected answers (questionId -> answerId)
            Map<Integer, Integer> selectedAnswers = new HashMap<>();

            // Get all parameter names
            Enumeration<String> parameterNames = request.getParameterNames();

            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();

                // Check if the parameter name starts with "q" (question ID prefix)
                if (paramName.startsWith("q")) {
                    // Extract question ID from the parameter name
                    int questionId = Integer.parseInt(paramName.substring(1)); // Remove "q" prefix
                    int answerId = Integer.parseInt(request.getParameter(paramName)); // Selected answer

                    // Store in map (questionId -> selected answerId)
                    selectedAnswers.put(questionId, answerId);
                }
            }

            // Debugging: Print selected answers
            System.out.println("Selected Answers: " + selectedAnswers);
            Integer score =0;
            if(!selectedAnswers.isEmpty()) {
                Map<Integer, Integer> dbAnswers = questionServiceImpl.findAllQuestionAnswers();
                Integer correctAnswers = 0;
                Integer noOfQuestions = selectedAnswers.size();

                for (Integer questionId : selectedAnswers.keySet()) {
                    Integer dbAnswer = dbAnswers.get(questionId);
                    Integer userAnswer = selectedAnswers.get(questionId);

                    if (dbAnswer != null && userAnswer != null) {
                        if (dbAnswer.equals(userAnswer)) {
                            correctAnswers++;
                        }
                    }
                }
               score = (correctAnswers * 100) / noOfQuestions;
                // Store the data in request scope and forward to JSP
            }
            request.setAttribute("score", score);

            response.setContentType("text/html");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/score.jsp");
            requestDispatcher.forward(request, response);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }






    }
}
