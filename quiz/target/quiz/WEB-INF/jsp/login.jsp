<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz App - Login</title>

      <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/login.css">
       <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <script src="<%= request.getContextPath() %>/resources/js/script.js" defer></script>
</head>
<body>
    <div class="login-container">
        <h2>Quiz App Login</h2>
        <form action="${pageContext.request.contextPath}/login" method="POST">
            <div class="input-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>

            <div class="input-group">
                <label for="password">Password</label>
                <div class="password-wrapper">
                    <input type="password" id="password" name="password" required>
                     <span class="eye-icon" id="eye-icon" onclick="togglePassword()">
                                    <i class="fas fa-eye"></i> <!-- Default "eye" icon to show password -->
                     </span>
                </div>
            </div>

<div>
        <c:if test="${not empty isValidUser}">
            <p class="error">Invalid Username or Password</p>
        </c:if>
        </div>
            <button type="submit" class="login-btn">Login</button>
            <p class="register-text">Don't have an account? <a href="/quiz/register">Sign Up</a></p>
        </form>
    </div>
</body>
</html>
