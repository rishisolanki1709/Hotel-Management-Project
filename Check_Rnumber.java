
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
import java.sql.ResultSet;


@WebServlet("/Check_Rnumber")
public class Check_Rnumber extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession(false); // Do not create a new session
if (session == null || session.getAttribute("email") == null) {
    resp.sendRedirect("index.html");
    return;
}

        
        
        PrintWriter out = resp.getWriter();
        String rnumber = req.getParameter("rnumber");
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/minorproject", "root", "krishna04");
            
            PreparedStatement psmt = con.prepareStatement("select * from customer where roomnumber = ?");
            psmt.setString(1, rnumber);
            
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                HttpSession hs = req.getSession(false);
               
                String r_number = rs.getString("roomnumber");
                String price = rs.getString("amount");
                String adhar = rs.getString("adhar");
                String paid = rs.getString("paid");
                String name = rs.getString("name");
                String remaining = rs.getString("remaining");
                
                hs.setAttribute("rnumber", r_number);
                hs.setAttribute("adhar", adhar);
                hs.setAttribute("name", name);
                hs.setAttribute("price", price);
                hs.setAttribute("paid", paid);
                hs.setAttribute("remaining", remaining);
                
                
                RequestDispatcher rd = req.getRequestDispatcher("/update_customer2.jsp");
                rd.forward(req, resp);
            }
            
            else
            {
                resp.setContentType("text/html");
                out.print("<h2 style='color:red' align='center' >"+rnumber+" Room Number is not Booked :(</h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/check_out.html");
                rd.include(req, resp);
            }
            con.close();
            
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
        

    }
    
    
}