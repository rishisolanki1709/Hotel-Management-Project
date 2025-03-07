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
        <title>Show All Admins - Velvet Vista</title>
        
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

/* Table Styling */
.table-container {
    width: 90%;
    max-width: 800px;
    margin: 20px auto;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #fff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 20px;
    overflow-x: auto;
}

table {
    width: 100%;
    border-collapse: collapse;
    text-align: left;
}

table thead th {
    background-color: #3498db;
    color: white;
    padding: 10px;
    text-align: center;
}

table tbody td {
    padding: 10px;
    border-bottom: 1px solid #ddd;
    text-align: center;
}

table tbody tr:nth-child(even) {
    background-color: #f2f2f2;
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
        
        <!--<link rel="stylesheet" href="style_show_all_admin.css">-->
    </head>
    <body>
        <h1>Velvet Vista</h1>
        <h2>All Admin Details</h2>

        <main>
            <section>
                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>S No.</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Mobile</th>
                                <th>Adhar</th>
                                <th>Age</th>
                                <th>Gender</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");

                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject", "root", "krishna04");

                                    PreparedStatement psmt = con.prepareStatement("select * from admin");

                                    ResultSet rs = psmt.executeQuery();
                                    int count = 1;
                                    while (rs.next()) {
                                        String name = rs.getString("name");
                                        String email = rs.getString("email");
                                        String adhar = rs.getString("adhar");
                                        String mobile = rs.getString("mobile");
                                        String age = rs.getString("age");
                                        String gender = rs.getString("gender");
                            %>
                            <tr>
                                <td><%= count%></td>
                                <td><%= name%></td>
                                <td><%= email%></td>
                                <td><%= mobile%></td>
                                <td><%= adhar%></td>
                                <td><%= age%></td>
                                <td><%= gender%></td>
                            </tr>
                            <%
                                        count++;
                                    }
                                } catch (Exception ex) {
                                    out.print(ex.getMessage());
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </section>
            <div class="back-button" align="center">
                <a href="edit_admin.html">Back</a>
            </div>
        </main>
    </body>
</html>
