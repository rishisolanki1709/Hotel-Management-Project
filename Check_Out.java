
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/Check_Out")
public class Check_Out extends HttpServlet
{    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        
        HttpSession session = req.getSession(false); // Do not create a new session
if (session == null || session.getAttribute("email") == null) {
    resp.sendRedirect("index.html");
    return;
}    
        PrintWriter out = resp.getWriter();

        String remaining = req.getParameter("u_remaining");
        if ( Integer.parseInt(remaining) != 0 )
        {
            resp.setContentType("text/html");
            out.println("<h2 style=\"color: red;\"><b>You Have Some Pending Amount.</b></h2>");
            RequestDispatcher rd = req.getRequestDispatcher("/update_customer2.jsp");
            rd.include(req, resp);
        }
        else
        {
        
        try
        {
            String rnumber = req.getParameter("u_rnumber");

            // Load the Driver 
            Class.forName("com.mysql.jdbc.Driver");
            
            // make Connection 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","krishna04");
            
            // make PreparedStatement object
            
            PreparedStatement psmt = con.prepareStatement("update rooms set availability = 'available' where roomnumber = ?");
            PreparedStatement psmt2 = con.prepareStatement("delete from customer where roomnumber = ?");
            psmt.setString(1, rnumber);
            psmt2.setString(1, rnumber);
            boolean b = psmt.execute();
            if (b == false)
            {
                boolean b2 = psmt2.execute();
                if(b2 == false)
                {
                    resp.setContentType("text/html");
                RequestDispatcher rd2 = req.getRequestDispatcher("/successfull2.html");
                rd2.include(req, resp);
                RequestDispatcher rd = req.getRequestDispatcher("/employee_home.html");
                rd.include(req, resp);
                }
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
    
}