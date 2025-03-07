
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Search_Employee")
public class Search_Employee extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        HttpSession session = req.getSession(false); // Do not create a new session
if (session == null || session.getAttribute("email") == null) {
    resp.sendRedirect("index.html");
    return;
}

        
        
        PrintWriter out = resp.getWriter();
        String adhar = req.getParameter("u_adhar");
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/minorproject", "root", "krishna04");
            
            PreparedStatement psmt = con.prepareStatement("select * from employee where adhar = ?");
            psmt.setString(1, adhar);
            
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                HttpSession hs = req.getSession(false);
               
                String name = rs.getString("name");
                String email = rs.getString("email");
                String mobile = rs.getString("mobile");
                String age = rs.getString("age");
                String gender = rs.getString("gender");
                String salary = rs.getString("salary");
                String job = rs.getString("job");
                String pwd = rs.getString("password");
                
                hs.setAttribute("u_adhar", adhar);
                hs.setAttribute("u_name", name);
                hs.setAttribute("u_mobile", mobile);
                hs.setAttribute("u_email", email);
                hs.setAttribute("u_age", age);
                hs.setAttribute("u_gender", gender);
                hs.setAttribute("u_salary", salary);
                hs.setAttribute("u_job", job);
                hs.setAttribute("u_password", pwd);
                
                RequestDispatcher rd = req.getRequestDispatcher("/update_employee.jsp");
                rd.forward(req, resp);
                
            }
            
            else
            {
                out.print("<div style='color:red' align='center' ><h2>Adhar Not Found..</h2></div>");
                  RequestDispatcher rd = req.getRequestDispatcher("/search_employee.html");
                rd.include(req, resp);
            }
            con.close();
            
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
        
    }
    
}
