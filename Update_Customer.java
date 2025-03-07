
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


@WebServlet("/Update_Customer")
public class Update_Customer extends HttpServlet
{    
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
 
        HttpSession session = req.getSession(false); // Do not create a new session
if (session == null || session.getAttribute("email") == null) {
    resp.sendRedirect("index.html");
    return;
}

        
        PrintWriter out = resp.getWriter();
        try
        {
            String adhar = req.getParameter("u_adhar");
            String name = req.getParameter("u_name");
            String mobile = req.getParameter("u_mobile");
            String rnumber = req.getParameter("u_rnumber");
            String paid = req.getParameter("u_paid");
            String price = req.getParameter("u_price");
            String remaining = req.getParameter("u_remaining");
            
                        
            
            
            
            
            // Load the Driver 
            Class.forName("com.mysql.jdbc.Driver");
            
            // make Connection 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","krishna04");
            
            // make PreparedStatement object
            
            PreparedStatement psmt = con.prepareStatement("update customer set name = ? , mobile = ? , roomnumber = ? , amount = ? , paid = ? , remaining = ? where adhar = ?");
            
            psmt.setString(1, name);
            psmt.setString(2, mobile);
            psmt.setString(3, rnumber);
            psmt.setString(4, price);
            psmt.setString(5, paid);
            psmt.setString(6, remaining);
            psmt.setString(7, adhar);
            
            boolean b = psmt.execute();
            if (b == false)
            {
                resp.setContentType("text/html");
                RequestDispatcher rd2 = req.getRequestDispatcher("/successfull2.html");
                rd2.include(req, resp);
                RequestDispatcher rd = req.getRequestDispatcher("/employee_home.html");
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

   


        