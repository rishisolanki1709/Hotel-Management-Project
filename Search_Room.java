
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

@WebServlet("/Search_Room")
public class Search_Room extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        HttpSession session = req.getSession(false); // Do not create a new session
if (session == null || session.getAttribute("email") == null) {
    resp.sendRedirect("index.html");
    return;
}

        
        
        PrintWriter out = resp.getWriter();
        String rnumber = req.getParameter("r_number");
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/minorproject", "root", "krishna04");
            
            PreparedStatement psmt = con.prepareStatement("select * from rooms where roomnumber = ?");
            psmt.setString(1, rnumber);
            
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                HttpSession hs = req.getSession(false);
               
                String r_number = rs.getString("roomnumber");
                String availability = rs.getString("availability");
                String price = rs.getString("price");
                String bed = rs.getString("bed");
                
                hs.setAttribute("r_number", r_number);
                hs.setAttribute("availability", availability);
                hs.setAttribute("price", price);
                hs.setAttribute("bed", bed);
                
                RequestDispatcher rd = req.getRequestDispatcher("/update_room.jsp");
                rd.forward(req, resp);
                
            }
            
            else
            {
                out.print("<h2 style='color:red' align='center'>Room Not Found</h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/search_room.html");
                rd.include(req, resp);
                
            }
            con.close();
            
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
        
    }
    
}
