
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


@WebServlet("/Update_Room")
public class Update_Room extends HttpServlet
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
            HttpSession hs = req.getSession(false);
            
            String s_room = (String)hs.getAttribute("r_number");
            String rnumber = req.getParameter("u_room");
            String availability = req.getParameter("u_availability");
            String bed = req.getParameter("u_bed");
            String price = req.getParameter("u_price");
            
            
            
            
            
            
            // Load the Driver 
            Class.forName("com.mysql.jdbc.Driver");
            
            // make Connection 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","krishna04");
            
            // make PreparedStatement object
            
            PreparedStatement psmt = con.prepareStatement(" update rooms set roomnumber = ? , availability = ? , bed = ? , price = ? where roomnumber = ?");
            
            psmt.setString(1, rnumber);
            psmt.setString(2, availability);
            psmt.setString(3, bed);
            psmt.setString(4, price);
            psmt.setString(5, s_room);
            
            boolean b = psmt.execute();
            if (b == false)
            {
                resp.setContentType("text/html");
                out.println("<h2 style='color:green' align='center'>Your Room Detail's Updated Successfully</h2>");
                RequestDispatcher rd2 = req.getRequestDispatcher("/successfull2.html");
                rd2.include(req, resp);
                RequestDispatcher rd = req.getRequestDispatcher("/edit_room.html");
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