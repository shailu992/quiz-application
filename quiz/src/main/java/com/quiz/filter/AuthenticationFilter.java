package com.quiz.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")  // This filter will be applied to all requests
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Optional: Initialize filter (if needed)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the user is authenticated (i.e., "username" is set in the session)
        HttpSession session = httpRequest.getSession(false); // Don't create a new session if one doesn't exist
        boolean isAuthenticated = (session != null && session.getAttribute("user") != null);

        // If the user is not authenticated and trying to access a protected page, redirect to login
        String requestURI = httpRequest.getRequestURI();

        if (requestURI.startsWith("/quiz/assets/") || requestURI.startsWith("/quiz/resources/")
                || requestURI.startsWith("/quiz/register") || requestURI.startsWith("/quiz/registration")  ) {
            chain.doFilter(request, response); // Allow static resources to be served
            return;
        }

        // You can define the list of allowed pages for non-authenticated users, such as login page
        if (!isAuthenticated && !requestURI.endsWith("/quiz/login.jsp") && !requestURI.endsWith("/quiz/login")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            requestDispatcher.forward(request, response); // Redirect to login page if not authenticated
            return; // Prevent further request processing
        }

        // If the user is authenticated, continue with the request
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Optional: Cleanup filter (if needed)
    }
}
