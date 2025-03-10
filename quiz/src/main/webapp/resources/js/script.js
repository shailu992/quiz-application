function togglePassword() {
        var passwordInput = document.getElementById("password");
        var eyeIcon = document.getElementById("eye-icon");
        var icon = eyeIcon.getElementsByTagName('i')[0];  // Get the <i> tag inside the icon span

        // Toggle the type of the input field between "password" and "text"
        if (passwordInput.type === "password") {
            passwordInput.type = "text"; // Show password
            icon.classList.remove('fa-eye');  // Remove "eye" icon
            icon.classList.add('fa-eye-slash'); // Add "eye-slash" icon
        } else {
            passwordInput.type = "password"; // Hide password
            icon.classList.remove('fa-eye-slash');  // Remove "eye-slash" icon
            icon.classList.add('fa-eye'); // Add "eye" icon
        }
    }