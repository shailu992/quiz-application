<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Instructions</title>
   <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/styles.css">
</head>
<body>
<div class="container">
  <!-- Form to start quiz -->
  <form action="${pageContext.request.contextPath}/start-quiz" method="POST">

        <h2>Welcome to the Quiz</h2>

       <h1>Quiz Instructions</h1>

           <p>Welcome to the quiz! Please read the following instructions carefully before starting:</p>

           <ol>
               <li><strong>Time Limit:</strong>
                   <ul>
                       <li>You have <strong>30 seconds</strong> to complete the quiz.</li>
                       <li>The timer will start as soon as you begin, and you will see a countdown displayed on the screen.</li>
                       <li>Once the 30 seconds are up, the quiz will be <strong>auto-submitted</strong>, and no further answers can be changed or added.</li>
                   </ul>
               </li>

               <li><strong>Answering Questions:</strong>
                   <ul>
                       <li><strong>Click</strong> on a question to expand and view all answer options.</li>
                       <li>You will see multiple-choice options for each question. Select the option that you believe is correct.</li>
                       <li>After choosing an answer, it will be automatically saved, and you can move to the next question or review your answer.</li>
                       <li>If you want to change your answer, simply click a different option before the timer expires.</li>
                   </ul>
               </li>

               <li><strong>Navigating the Quiz:</strong>
                   <ul>
                       <li>Use the <strong>Next</strong> or <strong>Previous</strong> buttons (if available) to navigate through questions.</li>
                       <li>You can return to a previous question at any time during the quiz if you have time remaining.</li>
                       <li>Once you select an answer and move to the next question, your selection is saved automatically.</li>
                   </ul>
               </li>

               <li><strong>Scoring:</strong>
                   <ul>
                       <li>Each <strong>correct answer</strong> is worth <strong>1 point</strong>.</li>
                       <li><strong>Incorrect or skipped answers</strong> will not result in any points.</li>
                       <li>The total score will be displayed at the end of the quiz.</li>
                   </ul>
               </li>

               <li><strong>Auto-Submission:</strong>
                   <ul>
                       <li>When the 30 seconds expire, the quiz will be <strong>automatically submitted</strong>, and you will not be able to modify any answers after that time.</li>
                       <li>Please ensure you have completed all questions or reviewed them before the time runs out.</li>
                   </ul>
               </li>

               <li><strong>Reviewing Your Answers:</strong>
                   <ul>
                       <li>After your quiz is submitted, you can review the answers you selected.</li>
                       <li><strong>Correct answers</strong> will be highlighted for your reference.</li>
                       <li>You may also see explanations for correct answers (if available).</li>
                   </ul>
               </li>

               <li><strong>Technical Considerations:</strong>
                   <ul>
                       <li>Ensure your internet connection is stable before starting the quiz to avoid any interruptions.</li>
                       <li>If the quiz timer doesn’t start or you experience technical difficulties, try refreshing the page or contacting support if available.</li>
                   </ul>
               </li>

               <li><strong>Important Notes:</strong>
                   <ul>
                       <li>Do not refresh the page during the quiz, as it may lead to a loss of progress.</li>
                       <li>If you finish early, you can wait for the timer to run out, but once the time expires, the quiz will be submitted automatically.</li>
                   </ul>
               </li>
           </ol>


        <button type="submit" class="btn">Start Quiz</button>
    </div>
  </form>
  <div/>
</body>
</html>
