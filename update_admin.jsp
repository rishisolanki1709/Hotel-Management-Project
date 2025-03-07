<%-- 
    Document   : update_employee
    Created on : 3 Dec 2024, 3:42:56 pm
    Author     : Acer Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Velvet Vista - Update Admin Information</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            /* General Reset */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: 'Poppins', sans-serif;
                background: linear-gradient(to bottom, #1abc9c, #16a085);
                color: #333;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
            }

            h1, h2 {
                text-align: center;
                color: #f6872c;
                margin-bottom: 20px;
            }

            h1 {
                font-size: 2.5rem;
                text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
            }

            h2 {
                color: black;
                font-size: 1.2rem;
                font-weight: 300;
            }

            .form-container {
                background: #ffffff;
                border-radius: 15px;
                padding: 40px;
                box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
                width: 600px;
                max-width: 95%;
            }

            form {
                display: grid;
                grid-template-columns: 1fr 1fr;
                gap: 20px 30px;
            }

            form > div {
                display: flex;
                flex-direction: column;
            }

            label {
                font-size: 1rem;
                font-weight: bold;
                color: #34495e;
                margin-bottom: 5px;
            }

            input, select {
                padding: 12px 15px;
                font-size: 1rem;
                border: 2px solid #3498db;
                border-radius: 8px;
                outline: none;
                transition: all 0.3s ease;
            }

            input:focus, select:focus {
                border-color: #1abc9c;
                box-shadow: 0 0 5px rgba(26, 188, 156, 0.5);
            }

            .submit-btn {
                grid-column: span 2;
                background: linear-gradient(45deg, #3498db, #1abc9c);
                color: #fff;
                border: none;
                padding: 15px;
                border-radius: 8px;
                font-size: 1rem;
                font-weight: bold;
                cursor: pointer;
                transition: background 0.3s ease;
            }

            .submit-btn:hover {
                background: linear-gradient(45deg, #1abc9c, #3498db);
            }

            .back-button {
                text-align: center;
                margin-top: 20px;
            }

            .back-button a {
                text-decoration: none;
                font-size: 1rem;
                font-weight: bold;
                color: #e74c3c;
                border: 2px solid #e74c3c;
                border-radius: 5px;
                padding: 10px 20px;
                transition: background 0.3s, color 0.3s, border-color 0.3s;
            }

            .back-button a:hover {
                background: #e74c3c;
                color: #fff;
                border-color: #c0392b;
            }

        </style>

        <!--    <link rel="stylesheet" href="style_update_admin.css">-->
    </head>
    <body>
        <%

            String u_adhar = (String) session.getAttribute("u_adhar");
            String name = (String) session.getAttribute("u_name");
            String email = (String) session.getAttribute("u_email");
            String mobile = (String) session.getAttribute("u_mobile");
            String age = (String) session.getAttribute("u_age");
            String gender = (String) session.getAttribute("u_gender");
            String pwd = (String) session.getAttribute("u_password");

        %>


        <main>
            <section>
                <div class="form-container">
                    <h1 align="center">Velvet Vista Hotel</h1>
                    <h2 align="center">Update Employee Information</h2>
                    <form action="Update_Admin" method="post">
                        <div>
                            <label for="u_adhar">Adhar</label>
                            <input type="number" id="u_adhar" name="u_adhar" value="<%= u_adhar%>" readonly>
                        </div>

                        <div>
                            <label for="u_name">Name</label>
                            <input type="text" id="u_name" name="u_name" value="<%= name%>"required>
                        </div>

                        <div>
                            <label for="u_email">Email</label>
                            <input type="email" id="u_email" name="u_email" value="<%= email%>" required>
                        </div>

                        <div>
                            <label for="u_mobile">Mobile Number</label>
                            <input type="number" id="u_mobile" name="u_mobile"  value="<%= mobile%>" required>
                        </div>

                        <div>
                            <label for="u_gender">Gender</label>
                            <select id="u_gender" name="u_gender" required>
                                <option value="">Select Gender</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>

                        <div>
                            <label for="u_age">Age</label>
                            <input type="number" id="u_age" name="u_age" value="<%= age%>" required>
                        </div>

                        <div>
                            <label for="u_password">Password</label>
                            <input type="text" id="u_password" name="u_password" value="<%= pwd%>" required>
                        </div>

                        <input type="submit" value="Update Admin" class="submit-button">
                    </form>
                </div>
            </section>
            <div class="back-button" align="center">
                <a href="edit_admin.html">Back</a>
            </div>
        </main>
    </body>
</html>
