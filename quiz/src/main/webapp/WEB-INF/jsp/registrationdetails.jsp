<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Registration form</title>
  <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
         }
       table {
            width: 50%;
            margin: 0 auto;
            border-collapse: collapse;
        }
        th {
            text-align: left;
            padding-bottom: 10px;
        }
        td {
            padding: 10px;
        }
       .buttons {
            text-align: center;
        }
      </style>
</head>
<body>
   <h2 style="text-align:center;"> Registration Details</h2>
   <form action="/registration">
      <table>
         <tr>
            <td>User Name:</td>
            <td><c:out value="${user.userName}"/></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><c:out value="XXXXX"/></td>
         </tr>
         <tr>
            <td>Address:</td>
            <td><c:out value="${user.address}"/></td>
         </tr>
         <tr>
            <td>Email:</td>
            <td><c:out value="${user.email}"/></td>
         </tr>
         <tr>
            <td>Phone Number:</td>
            <td><c:out value="${user.phoneNumber}"/></td>
         </tr>

         <tr></tr>
         <tr><p class="register-text">login and continue <a href="/quiz/welcome">login</a></p></tr>


      </table>
   </form>
</body>
