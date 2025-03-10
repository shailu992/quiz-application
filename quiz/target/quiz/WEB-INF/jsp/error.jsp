<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #721c24;
        }
        p {
            color: #721c24;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Oops! Something went wrong.</h2>
        <p>An error occurred while processing your request.</p>
        <p><strong>Error Details:</strong> <%= exception.getMessage() %></p>
        <a href="index.jsp">Go Back to Home</a>
    </div>
</body>
</html>