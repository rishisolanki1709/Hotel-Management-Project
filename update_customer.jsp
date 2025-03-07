<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Velvet Vista Hotel - Update Customer</title>
        
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
    background-color: #f4f4f9;
    color: #2c3e50;
    display: flex;
    flex-direction: column;
    align-items: center;
}

/* Heading Styles */
h1, h2 {
    text-align: center;
    color: #34495e;
}

h1 {
    font-size: 2.5rem;
    margin-top: 20px;
}

h2 {
    font-size: 2rem;
    margin: 20px 0;
    color: #1abc9c;
}

/* Form Container Styling */
.form-container {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 600px;
}

label {
    font-weight: bold;
    margin-bottom: 8px;
    display: block;
}

input[type="text"], input[type="number"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

input[type="submit"] {
    background-color: #1abc9c;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 5px;
    font-size: 1.1rem;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #16a085;
}

/* Responsive Design */
@media (max-width: 600px) {
    h1, h2 {
        font-size: 1.8rem;
    }

    .form-container {
        width: 90%;
    }

    input[type="submit"] {
        width: 100%;
    }
}

.back-button {
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
        
        <!--<link rel="stylesheet" href="style_update_customer.css">-->
    </head>
    <body>
        <%
            String adhar = request.getParameter("adhar");
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String mobile = request.getParameter("mobile");
            String paid = request.getParameter("paid");
            String rnumber = request.getParameter("rnumber");
            String remaining = request.getParameter("remaining");
        %>

        <header>
            <h1>Welcome to Velvet Vista Hotel</h1>
            <h2>Update Customer Information</h2>
        </header>

        <main>
            <section class="form-section">
                <form action="Update_Customer" method="post">
                    <div class="form-group">
                        <label for="u_adhar">Adhar Number</label>
                        <input type="number" id="u_adhar" name="u_adhar" value="<%=adhar%>" readonly>
                    </div>

                    <div class="form-group">
                        <label for="u_name">Name</label>
                        <input type="text" id="u_name" name="u_name" value="<%=name%>">
                    </div>
                    
                    <div class="form-group">
                        <label for="u_mobile">Mobile</label>
                        <input type="text" id="u_mobile" name="u_mobile" value="<%=mobile%>">
                    </div>

                    <div class="form-group">
                        <label for="u_price">Amount</label>
                        <input type="text" id="u_price" name="u_price" value="<%=price%>">
                    </div>

                    <div class="form-group">
                        <label for="u_rnumber">Room Number</label>
                        <input type="text" id="u_rnumber" name="u_rnumber" value="<%=rnumber%>">
                    </div>

                    <div class="form-group">
                        <label for="u_paid">Deposited</label>
                        <input type="text" id="u_paid" name="u_paid" value="<%=paid%>">
                    </div>

                    <div class="form-group">
                        <label for="u_remaining">Pending</label>
                        <input type="text" id="u_remaining" name="u_remaining" value="<%=remaining%>">
                    </div>

                    <div class="form-group">
                        <input type="submit" value="Update">
                    </div>
                </form>
            </section>

            <section class="back-section">
                <div class="back-button" align="center">
                    <a href="employee_home.html">Back</a>
                </div>
            </section>
        </main>

    </body>
</html>
