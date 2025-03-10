<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Registration form</title>
  <style>
          body {
              font-family: Arial, sans-serif;
              background-color: #f4f4f4;
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
              width: 300px;
          }
          h2 {
              text-align: center;
              color: #333;
          }
          label {
              font-weight: bold;
          }
          input, select {
              width: 100%;
              padding: 10px;
              margin: 10px 0;
              border: 1px solid #ccc;
              border-radius: 5px;
          }
          button {
              width: 100%;
              background: #28a745;
              color: white;
              border: none;
              padding: 10px;
              border-radius: 5px;
              cursor: pointer;
              font-size: 16px;
          }
          button:hover {
              background: #218838;
          }
      </style>
</head>
<body>
<div class="container">
   <h2 style="text-align:center;"> Registration Form</h2>
   <form method="POST" action="/quiz/registration">
      <table>
         <tr>
            <td>User Name:</td>
            <td><input id="userName" type="text" name="userName" required/></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input  id="password" type="password" name="password" required/></td>
         </tr>
         <tr>
            <td>Address:</td>
            <td><input id="address" type="text" name="address" required/></td>
         </tr>
         <tr>
            <td>Email:</td>
            <td><input  id="email" type="email" name="email" pattern="/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/" required/></td>
         </tr>
         <tr>
            <td>Phone number:</td>
            <td><input id="phoneNumber" type="tel" name="phoneNumber" pattern="[0-9]{10}" placeholder="Enter 10 digit number " required/> </td>
         </tr>
         <tr>
             <td colspan=2 class="buttons">
                  <input type="submit" value="submit"/>
                  <input type="reset" value="reset"/>
                  </td>
         </tr>

      </table>
   </form>
   </div>
</body>
