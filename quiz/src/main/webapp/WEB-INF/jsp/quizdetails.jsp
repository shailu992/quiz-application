<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz with Timer</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/styles.css">
    <script src="<%= request.getContextPath() %>/resources/js/start-quiz.js"></script>
</head>
<body>

<div class="container">
    <h2>Quiz Questions</h2>

    <!-- Timer Display -->
    <div id="timer">Time Left: 02:00</div>

   <form id="quizForm" action="<%= request.getContextPath() %>/score" method="POST">
        <c:forEach var="question" items="${questions}" varStatus="status">
            <div class="question" onclick="toggleQuestion(${question.questionId})">
                ${status.index + 1}. ${question.question}
            </div>
            <div class="options" id="${question.questionId}">
                <c:forEach var="answer" items="${question.answers}">
                    <label><input type="radio" name="q${question.questionId}" value="${answer.answerId}"> ${answer.answer}</label><br>
                </c:forEach>
            </div>
        </c:forEach>

        <button type="button" class="btn" onclick="submitQuiz()">Submit</button>
    </form>

    <div id="result" style="display:none; font-size: 20px; color: green;"></div>
</div>
</body>
</html>
