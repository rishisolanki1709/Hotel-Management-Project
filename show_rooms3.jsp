<%-- 
    Document   : show_rooms
    Created on : 4 Dec 2024, 6:58:18 pm
    Author     : Acer Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Velvet Vista Hotel - All Room's</title>
        
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

/* Heading Styles */
h1, h2 {
    text-align: center;
    font-family: 'Arial', sans-serif;
    color: #2c3e50;
}

h1 {
    font-size: 2.5rem;
    margin-top: 50px;
}

h2 {
    font-size: 2rem;
    margin-top: 20px;
    color: #3498db;
}

/* Table Styling */
table {
    width: 80%;
    margin: 20px auto;
    border-collapse: collapse;
    background-color: #fff;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}

th, td {
    padding: 12px;
    text-align: center;
    border: 1px solid #ddd;
}

th {
    background-color: #3498db;
    color: #fff;
    font-size: 1.1rem;
}

td {
    font-size: 1rem;
    color: #333;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

/* Back Button */
.back-button {
    text-align: center;
    margin-top: 20px;
}

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
        
        <!--<link rel="stylesheet" href="style_show_rooms3.css">-->
    </head>
    <body>
        <h1 align="center">Welcome to Velvet Vista Hotel</h1>
        <h2 align="center">All Room Details</h2>

        <main>
            <section>
                <div>
                    <table border="2px" >
                        <tr>
                            <th>
                                S no.
                            </th>
                            <th>
                                Room Number
                            </th>
                            <th>
                                Availability
                            </th>
                            <th>
                                Bed Type
                            </th>
                            <th>
                                Price
                            </th> 
                        </tr>
                        <%
                            try {
                                Class.forName("com.mysql.jdbc.Driver");

                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject", "root", "krishna04");

                                PreparedStatement psmt = con.prepareStatement("select * from rooms");

                                ResultSet rs = psmt.executeQuery();
                                int count = 1;
                                while (rs.next()) {

                                    String a = "available";
                                    String roomnumber = rs.getString("roomnumber");
                                    String availability = rs.getString("availability");
                                    String bed = rs.getString("bed");
                                    String price = rs.getString("price");

                        %>
                        <tr>
                            <td  >
                                <%=count%>
                            </td>
                            <td>
                                <%=roomnumber%>
                            </td>
                            <td>
                                <%=availability%>
                            </td>
                            <td>
                                <%=bed%>
                            </td>
                            <td>
                                <%=price%>
                            </td>

                        </tr>

                        <%
                                count++;
                            }
                        %>
                    </table>
                    <%
                        } catch (Exception ex) {
                            out.print(ex.getMessage());
                        }
                    %>


                </div>
            </section>
            <div class="back-button">
                <a href="edit_room.html">Back</a>
            </div>
        </main>
    </body>
</html>