<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Quiz Result</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Quiz Completed!</h2>

        <p class="result">Your Score: <strong><%= request.getAttribute("score") %></strong></p>

        <c:if test="${score >= 80}">
            <p class="congratulations">Great job! You scored above 80%. Keep it up!</p>
        </c:if>

        <c:if test="${score < 80 && score >= 50}">
            <p class="encouragement">Good effort! You scored above 50%, but there's room for improvement. Try again!</p>
        </c:if>

        <c:if test="${score < 50}">
            <p class="encouragement">Don't worry! You scored below 50%. Take a moment to review and try again!</p>
        </c:if>

        <a href="/quiz/view/quiz-instructions"><button>Try Again</button></a>
    </div>
</body>
</html>
