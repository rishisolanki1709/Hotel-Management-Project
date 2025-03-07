
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







@WebServlet("/Add_Room")
public class Add_Room extends HttpServlet
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
        String r_number = req.getParameter("r_number");
        
        try
        {            
            
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            //make Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","krishna04");
            
            //make PReparedSatement object
            
            PreparedStatement psmt = con.prepareStatement("insert into rooms values(?,?,?,?)");
            
            psmt.setString(1, r_number);
            psmt.setString(2, req.getParameter("r_availability"));
            psmt.setString(3, req.getParameter("r_bed"));
            psmt.setString(4, req.getParameter("r_price"));
            
            boolean b = psmt.execute();
            if(b == false)
            {
                resp.setContentType("text/html");
                out.println("<h2 style='color:red' align='center'>Room "+r_number+" Added Succesfully</h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/successfull2.html");
                rd.include(req, resp);
                RequestDispatcher rd2 = req.getRequestDispatcher("/edit_room.html");
                rd2.include(req, resp);
            }
            else{
                resp.setContentType("text/html");
                out.println("<h2 style='color:green' align='center'>Duplicate Room Numbers "+r_number+"</h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/add_room.html");
                rd.include(req, resp);
            }
            
            
        }
            
        catch(Exception ex)
        {
              resp.setContentType("text/html");
                out.println("<h2 style='color:red' align='center'>Duplicate Room Numbers "+r_number+"</h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/add_room.html");
                rd.include(req, resp);
        }
        
        
        
        
    }
    
}
        
        