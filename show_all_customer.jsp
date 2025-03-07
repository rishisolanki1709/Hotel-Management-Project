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
        <title>Velvet Vista - All Customer Details</title>
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
        <h2>All Customer Details</h2>

        <main>
            <section>
                <div class="customer-table-container">
                    <table border="2px">
                        <thead>
                            <tr>
                                <th>S No.</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Mobile</th>
                                <th>Adhar</th>
                                <th>Age</th>
                                <th>Gender</th>
                                <th>Country</th>
                                <th>Room Number</th>
                                <th>Room Rent</th>
                                <th>Deposited Amount</th>
                                <th>Remaining Amount</th>
                                <th>Update Details</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject", "root", "krishna04");
                                    PreparedStatement psmt = con.prepareStatement("select * from customer");
                                    ResultSet rs = psmt.executeQuery();
                                    int count = 1;
                                    while (rs.next()) {
                                        String name = rs.getString("name");
                                        String email = rs.getString("email");
                                        String adhar = rs.getString("adhar");
                                        String mobile = rs.getString("mobile");
                                        String age = rs.getString("age");
                                        String gender = rs.getString("gender");
                                        String country = rs.getString("country");
                                        String rnumber = rs.getString("roomnumber");
                                        String paid = rs.getString("paid");
                                        String price = rs.getString("amount");
                                        String remaining = rs.getString("remaining");
                            %>
                            <tr>
                                <td><%= count %></td>
                                <td><%= name %></td>
                                <td><%= email %></td>
                                <td><%= mobile %></td>
                                <td><%= adhar %></td>
                                <td><%= age %></td>
                                <td><%= gender %></td>
                                <td><%= country %></td>
                                <td><%= rnumber %></td>
                                <td><%= price %></td>
                                <td><%= paid %></td>
                                <td><%= remaining %></td>
                                <td>
                                    <a href="update_customer.jsp?name=<%= name %>&adhar=<%= adhar %>&rnumber=<%= rnumber %>&mobile=<%=mobile%>&price=<%= price %>&paid=<%= paid %>&remaining=<%= remaining %>">Update</a>
                                </td>
                            </tr>
                            <%
                                count++;
                                }
                            %>
                        </tbody>
                    </table>
                    <%
                        } catch (Exception ex) {
                            out.print(ex.getMessage());
                        }
                    %>
                </div>
            </section>
            <div class="back-button" align="center">
            <a href="employee_home.html">Back</a>
        </div>
        </main>
    </body>
</html>
