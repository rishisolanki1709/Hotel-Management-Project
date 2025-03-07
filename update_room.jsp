<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update Room - Velvet Vista</title>
        
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
    display: flex;
    flex-direction: column;
    align-items: center;
}

/* Heading Styles */
h1, h2 {
    text-align: center;
    color: #2c3e50;
}

h1 {
    font-size: 2.5rem;
    margin-top: 20px;
}

h2 {
    font-size: 2rem;
    margin: 20px 0;
    color: #3498db;
}

/* Form Container */
.form-container {
    margin: 20px auto;
    width: 400px;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #fff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* Form Elements */
form {
    display: flex;
    flex-direction: column;
    gap: 15px;
}

form label {
    font-weight: bold;
    color: #2c3e50;
}

form input[type="text"] {
    padding: 10px;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    outline: none;
    transition: border-color 0.3s;
}

form input[type="text"]:focus {
    border-color: #3498db;
}

form input[type="submit"] {
    padding: 10px 20px;
    font-size: 1rem;
    font-weight: bold;
    color: #fff;
    background-color: #3498db;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

form input[type="submit"]:hover {
    background-color: #2980b9;
}

/* Back Link */
.back-button a {
    text-decoration: none;
    font-size: 1.2rem;
    font-weight: bold;
    color: #e74c3c;
    border: 2px solid #e74c3c;
    border-radius: 5px;
    padding: 12px 20px;
    transition: background 0.3s, color 0.3s, border-color 0.3s;
}

.back-button a:hover {
    background: #e74c3c;
    color: #fff;
    border-color: #c0392b;
}

        </style>
        
<!--        <link rel="stylesheet" href="style_update_room.css">-->
    </head>
    <body>
        <%
            String rnumber = (String) session.getAttribute("r_number");
            String availability = (String) session.getAttribute("availability");
            String bed = (String) session.getAttribute("bed");
            String price = (String) session.getAttribute("price");
        %>

        <h1>Velvet Vista</h1>
        <h2>Update Room Information</h2>

        <main>
            <section>
                <div class="form-container">
                    <form action="Update_Room" method="post">
                        <label for="u_room">Room Number</label>
                        <input type="text" id="u_room" name="u_room" value="<%=rnumber%>" readonly>

                        <label for="u_availability">Availability</label>
                        <input type="text" id="u_availability" name="u_availability" value="<%=availability%>">

                        <label for="u_bed">Bed Type</label>
                        <input type="text" id="u_bed" name="u_bed" value="<%=bed%>">

                        <label for="u_price">Price</label>
                        <input type="text" id="u_price" name="u_price" value="<%=price%>">

                        <input type="submit" value="Update Room">
                    </form>
                </div>
            </section>
            <div class="back-button a"  >
                <a href="edit_room.html">Back</a>
            </div>
        </main>
    </body>
</html>
