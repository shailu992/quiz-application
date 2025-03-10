package com.quiz.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/view/*")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = request.getPathInfo(); // Get requested page (e.g., "/home")
        if (page == null || page.equals("/")) {
            page = "/"; // Default page
        } else {
            page += ".jsp"; // Append .jsp
        }

        String jspPath = "/WEB-INF/jsp" + page;
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
        dispatcher.forward(request, response);
    }
}
