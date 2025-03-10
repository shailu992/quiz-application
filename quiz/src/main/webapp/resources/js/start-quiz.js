document.addEventListener("DOMContentLoaded", function () {
    let timeLeft = 120; // Timer in seconds
    let timerElement = document.getElementById("timer");

    function updateTimer() {
        if (timeLeft <= 0) {
            clearInterval(timerInterval);
            document.getElementById("quizForm").submit(); // Auto-submit when time is up
        } else {
            timerElement.innerText = timeLeft;
            timeLeft--;
        }
    }

    let timerInterval = setInterval(updateTimer, 1000);     // Update every second

     window.toggleQuestion = function (index) {
            let optionsDiv = document.getElementById(index);
            optionsDiv.style.display = optionsDiv.style.display === "block" ? "none" : "block";
        };


});
 function submitQuiz()
 {
           alert("submitting form, wait for score");
           document.getElementById("quizForm").submit();
 }


