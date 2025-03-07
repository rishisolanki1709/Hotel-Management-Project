<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Velvet Vista - Room Booking</title>
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

/* Booking Form Styles */
.booking-form-container {
    background-color: #fff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 500px;
}

.booking-form h3 {
    text-align: center;
    margin-bottom: 20px;
    color: #1abc9c;
}

.booking-form input {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 1rem;
}

.booking-form input[type="submit"] {
    background-color: #1abc9c;
    color: white;
    cursor: pointer;
    font-weight: bold;
    transition: background-color 0.3s;
}

.booking-form input[type="submit"]:hover {
    background-color: #16a085;
}

/* Responsive Design */
@media (max-width: 600px) {
    h1, h2 {
        font-size: 1.8rem;
    }

    .booking-form-container {
        width: 90%;
    }
}
/* Back Button Styling */
.back-button {
    display: flex;
    justify-content: center;
    margin-top: 20px; /* Adjust as needed */
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
        
        <!--<link rel="stylesheet" href="style_book_room2.css">-->
    </head>
    <body>
        <h1>Welcome to Velvet Vista</h1>
        <h2>Room Booking</h2>

        <main>
            <section>
                <div class="booking-form-container">
                    <%
                        String rnumber = request.getParameter("roomnumber");
                        String bed = request.getParameter("bed");
                        String price = request.getParameter("price");
                        
                        session.setAttribute("rnumber", rnumber);
                        session.setAttribute("bed", bed);
                        session.setAttribute("price", price);
                    %>
                    <h3>Room Details</h3>
                    <form action="Book_Room2" method="post" class="booking-form">
                        <input type="text" name="rnumber" value="Room Number: <%= rnumber %>" readonly />
                        <br><br>
                        <input type="text" name="bed" value="Bed Size: <%= bed %>" readonly />
                        <br><br>
                        <input type="text" name="price" value="Price: <%= price %>" readonly />
                        <br><br>
                        <input type="text" name="paid" placeholder="Amount Paid" required />
                        <br><br>
                        <input type="submit" value="Book Now" />
                    </form>
                </div>
            </section>
                        <div class="back-button">
                <a href="show_rooms4.jsp">Back</a>
            </div>
        </main>
    </body>
</html>
