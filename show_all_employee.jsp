<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Velvet Vista Hotel - Employee Details</title>
    
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

/* Table Styling */
.table-container {
    margin: 20px auto;
    width: 90%;
    max-width: 1200px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin: 0 auto;
    background-color: #fff;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}

table th, table td {
    padding: 12px 15px;
    text-align: left;
    border: 1px solid #ddd;
}

table thead {
    background-color: #3498db;
    color: #fff;
}

table tbody tr:nth-child(even) {
    background-color: #f2f2f2;
}

table tbody tr:hover {
    background-color: #eaf3fc;
}

/* Back Button */
.back-button {
    margin: 20px 0;
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
    
    <!--<link rel="stylesheet" href="style_show_all_employee.css">-->
</head>

<body>
    <h1 align="center">Welcome to Velvet Vista Hotel</h1>
    <h2 align="center">All Employee Details</h2>
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
                            <th>Aadhar</th>
                            <th>Age</th>
                            <th>Gender</th>
                            <th>Salary</th>
                            <th>Job Role</th>
                            <th>Password</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject", "root", "krishna04");
                                PreparedStatement psmt = con.prepareStatement("select * from employee");
                                ResultSet rs = psmt.executeQuery();
                                int count = 1;
                                while (rs.next()) {
                                    String name = rs.getString("name");
                                    String email = rs.getString("email");
                                    String adhar = rs.getString("adhar");
                                    String mobile = rs.getString("mobile");
                                    String age = rs.getString("age");
                                    String gender = rs.getString("gender");
                                    String job = rs.getString("job");
                                    String salary = rs.getString("salary");
                                    String pwd = rs.getString("password");
                        %>
                        <tr>
                            <td><%=count%></td>
                            <td><%=name%></td>
                            <td><%=email%></td>
                            <td><%=mobile%></td>
                            <td><%=adhar%></td>
                            <td><%=age%></td>
                            <td><%=gender%></td>
                            <td><%=salary%> $</td>
                            <td><%=job%></td>
                            <td><%=pwd%></td>
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
            <a href="edit_employee.html">Back</a>
        </div>
    </main>
</body>

</html>
