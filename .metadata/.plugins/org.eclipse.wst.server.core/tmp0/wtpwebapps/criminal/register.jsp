<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Floating Registration Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: url('https://www.uti.eu.com/wp-content/uploads/law-enforcement-record-management-00.jpg') center/cover no-repeat;
        }

        .register-container {
            background: rgba(10, 28, 49, 0.9);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            width: 300px;
            text-align: center;
            color: #fff;
        }

        .register-container input, .register-container select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
            border: 1px solid #3498db;
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0.1);
            color: #fff;
            outline: none;
        }

        .register-container input:focus, .register-container select:focus {
            background-color: rgba(255, 255, 255, 0.2);
        }

        .register-container button {
            width: 100%;
            padding: 10px;
            background-color: #3498db;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .register-container button:hover {
            background-color: #297fb8;
        }

        .register-container a {
            color: #bbb;
            text-decoration: none;
            margin-top: 10px;
            display: inline-block;
        }

        .register-container a:hover {
            color: #fff;
        }

        /* Adjust styling for gender input */
        .gender-container {
            display: flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 10px;
        }

        .gender-container input[type="radio"] {
            margin-right: 5px;
        }

        .gender-container label {
            margin-right: 15px;
        }

        /* Display registration success message */
        .success-message {
            color: green;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Register</h2>
        <!-- Display registration success message if set -->
        <% String successMessage = (String) session.getAttribute("successMessage"); %>
        <% if (successMessage != null) { %>
            <div class="success-message"><%= successMessage %></div>
            <% session.removeAttribute("successMessage"); %> <!-- Remove success message from session after displaying -->
        <% } %>
        <form action="register" method="post" class="form-group">
            <input type="text" name="txtname" placeholder="Username" required>
            <input type="email" name="txtemail"  placeholder="Email" required>
            <input type="password" name="txtpassword" placeholder="Password" required>
            <label for="gender">Gender:</label>
            <div class="gender-container">
                <input type="radio" id="male" name="gender" value="male">
                <label for="male">Male</label>
                <input type="radio" id="female" name="gender" value="female">
                <label for="female">Female</label>
                <input type="radio" id="other" name="gender" value="other">
                <label for="other">Other</label>
            </div>
            <label for="dob">Date of Birth:</label>
            <input name="txtdate"  type="date" id="dob" name="dob" required>
            <button type="submit">Register</button>
        </form>
    </div>

    <script>
        // JavaScript code can remain unchanged
        const passwordInput = document.querySelector('input[type="password"]');
        const toggleIcon = document.querySelector('.toggle-icon');

        toggleIcon.addEventListener('click', () => {
            const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
            passwordInput.setAttribute('type', type);
            toggleIcon.textContent = type === 'password' ? '\uD83D\uDD41' : '\uD83D\uDD13';
        });
    </script>
</body>
</html>
