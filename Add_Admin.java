
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


@WebServlet("/Add_Admin")
public class Add_Admin extends HttpServlet
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
            
            String name = req.getParameter("a_name");
            String email = req.getParameter("a_email");
            String mobile = req.getParameter("a_mobile");
            String adhar = req.getParameter("a_adhar");
            String gender = req.getParameter("a_gender");
            String age = req.getParameter("a_age");
            String pwd = req.getParameter("e_password");
            
            
            
            
            
            
            // Load the Driver 
            Class.forName("com.mysql.jdbc.Driver");
            
            // make Connection 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","krishna04");
            
            // make PreparedStatement object
            
            PreparedStatement psmt = con.prepareStatement("insert into admin(name,email,adhar,mobile,gender,age,password) values(?,?,?,?,?,?,?)");
            
            psmt.setString(1, name);
            psmt.setString(2, email);
            psmt.setString(3, adhar);
            psmt.setString(4, mobile);
            psmt.setString(5, gender);
            psmt.setString(6, age);
            psmt.setString(7, pwd);
            
            boolean b = psmt.execute();
            if (b == false)
            {
                 resp.setContentType("text/html");
                out.println("<h2 style='color:green' align='center'>Admin Added Successfully</h2>");
                RequestDispatcher rd2 = req.getRequestDispatcher("/successfull2.html");
                rd2.include(req, resp);
                RequestDispatcher rd = req.getRequestDispatcher("/edit_admin.html");
                rd.include(req, resp);
                        
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

   


        