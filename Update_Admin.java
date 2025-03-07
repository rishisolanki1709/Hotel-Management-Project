
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


@WebServlet("/Update_Admin")
public class Update_Admin extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        
        HttpSession session = req.getSession(false); // Do not create a new session
if (session == null || session.getAttribute("email") == null) {
    resp.sendRedirect("index.html");
    return;
}

        
        
        RequestDispatcher rd = req.getRequestDispatcher("/admin_home.html");
        rd.include(req, resp);
    }

    
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        
        
        HttpSession session = req.getSession(false); // Do not create a new session
if (session == null || session.getAttribute("email") == null) {
    resp.sendRedirect("login.html");
    return;
}

        
        
        PrintWriter out = resp.getWriter();
        try
        {
            String adhar = req.getParameter("u_adhar");
            String name = req.getParameter("u_name");
            String email = req.getParameter("u_email");
            String mobile = req.getParameter("u_mobile");
            String gender = req.getParameter("u_gender");
            String age = req.getParameter("u_age");
            String pwd = req.getParameter("u_password");
            
            
            
            
            
            
            // Load the Driver 
            Class.forName("com.mysql.jdbc.Driver");
            
            // make Connection 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","krishna04");
            
            // make PreparedStatement object
            
            PreparedStatement psmt = con.prepareStatement("update admin set name = ? , email = ? , mobile = ? , gender = ? , age = ? , password = ? where adhar = ? ");
            
            psmt.setString(1, name);
            psmt.setString(2, email);
            psmt.setString(3, mobile);
            psmt.setString(4, gender);
            psmt.setString(5, age);
            psmt.setString(6, pwd);
            psmt.setString(7, adhar);
            
            boolean b = psmt.execute();
            if (b == false)
            {
                  resp.setContentType("text/html");
                out.println("<h2 style='color: green; text-align: center;'><b>Your Admin Detail's Updated Succesfully</b></h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/successfull2.html");
                rd.include(req, resp);
                RequestDispatcher rd2 = req.getRequestDispatcher("edit_admin.html");
                rd2.include(req, resp);
                        
                        
            }
            else
            {
                out.println("Error Occurs");
            }
            
            con.close();
        }
        catch(Exception ex)
        {
            out.println(ex.getMessage());
        }
    }
}

   


        