<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Velvet Vista Hotel - Employee Login</title>
    
    <style>
        /* General Reset */
body, html {
    margin: 0;
    padding: 0;
    font-family: 'Arial', sans-serif;
    box-sizing: border-box;
}

/* Body Styling */
body {
    background-color: #f9f9f9;
    color: #333;
}

/* Form Container */
.form-container {
    margin: 20px auto;
    width: 300px;
    text-align: center;
    padding: 20px;
    background: #fff;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
}

form input[type="text"] {
    width: calc(100% - 20px);
    padding: 10px;
    margin-bottom: 15px;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 5px;
}
form input[type="password"] {
    width: calc(100% - 20px);
    padding: 10px;
    margin-bottom: 15px;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 5px;
}

form .submit-button {
    background: #3498db;
    color: #fff;
    font-weight: bold;
    border: none;
    padding: 10px 20px;
    font-size: 1rem;
    border-radius: 5px;
    cursor: pointer;
    transition: background 0.3s, box-shadow 0.3s;
}

form .submit-button:hover {
    background: #2980b9;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.2);
}

    </style>
    
<!--    <link rel="stylesheet" href="style_admin_login.css">-->
</head>

<body>
    <h1 align="center">Welcome to Velvet Vista Hotel</h1>
    <h2 align="center">Login Your Employee Account</h2>

    <main>
        <section>
            <div class="form-container">
                <%
                    HttpSession hs = request.getSession(false);
                    String email = (String) hs.getAttribute("email");
                %>
                <form action="CheckEmployeePassword" method="post">
                <input type="text" value="<%=email%>" readonly>
                <br>
                <br> 
                <input type="password" name="password" placeholder="Enter Password">
                <br>
                <br>
                <input type="submit" value="Login" class="submit-button">
            </form>
            </div>
        </section>
    </main>
</body>

</html>




<!-- -->