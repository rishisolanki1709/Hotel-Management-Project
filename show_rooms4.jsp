<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Velvet Vista - All Room's Details</title>
        
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

/* Table Styling */
table {
    width: 90%;
    max-width: 1000px;
    margin: 20px auto;
    border-collapse: collapse;
    background-color: #fff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

table th, table td {
    padding: 12px;
    border: 1px solid #ddd;
    text-align: center;
}

table th {
    background-color: #1abc9c;
    color: white;
    font-weight: bold;
}

table td a {
    text-decoration: none;
    color: #16a085;
    font-weight: bold;
}

table td a:hover {
    color: #1abc9c;
}

/* Back Link */
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
        <!--<link rel="stylesheet" href="style_show_rooms4.css">-->
    </head>
    <body>
        <h1>Welcome to Velvet Vista</h1>
        <h2>All Room's Details</h2>

        <main>
            <section>
                <div>
                    <table>
                        <thead>
                            <tr>
                                <th>S no.</th>
                                <th>Room Number</th>
                                <th>Availability</th>
                                <th>Bed Type</th>
                                <th>Price</th>
                                <th>Book Room</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject", "root", "krishna04");
                                    PreparedStatement psmt = con.prepareStatement("SELECT * FROM rooms");
                                    ResultSet rs = psmt.executeQuery();
                                    int count = 1;
                                    while (rs.next()) {
                                        String roomnumber = rs.getString("roomnumber");
                                        String availability = rs.getString("availability");
                                        String bed = rs.getString("bed");
                                        String price = rs.getString("price");
                            %>
                            <tr>
                                <td><%= count%></td>
                                <td><%= roomnumber%></td>
                                <td><%= availability%></td>
                                <td><%= bed%></td>
                                <td><%= price%></td>
                                <%
                                    if (availability.equals("available")) {
                                %>
                                <td><a href="book_room2.jsp?roomnumber=<%= roomnumber%>&price=<%= price%>&bed=<%= bed%>">Book Now</a></td>
                                <%
                                    }
                                %>
                            </tr>
                            <%
                                        count++;
                                    }
                                    con.close();
                                } catch (Exception ex) {
                                    out.print(ex.getMessage());
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </section>
            <div class="back-button" align="center">
                <a href="new_customer2.html">Back</a>
            </div>
        </main>
    </body>
</html>
