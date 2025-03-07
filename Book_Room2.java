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

@WebServlet("/Book_Room2")
public class Book_Room2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        HttpSession session = req.getSession(false); // Do not create a new session
        if (session == null || session.getAttribute("email") == null) {
        resp.sendRedirect("customer_home.html");
        return;
        }

        
        
        PrintWriter out = resp.getWriter();
        
        try {
            // Get the session, handle null session
            HttpSession hs = req.getSession(false);
            // Retrieve session and request parameters
            String name = (String) hs.getAttribute("cus_name");
            String email = (String) hs.getAttribute("cus_email");
            String adhar = (String) hs.getAttribute("cus_adhar");
            String gender = (String) hs.getAttribute("cus_gender");
            String age = (String) hs.getAttribute("cus_age");
            String mobile = (String) hs.getAttribute("cus_mobile");
            String country = (String) hs.getAttribute("cus_country");
            String price = (String) hs.getAttribute("price");
            String paid = req.getParameter("paid");
            String rnumber = (String) hs.getAttribute("rnumber");

            // Parse numeric fields
            int p1 = Integer.parseInt(price);
            int p2 = Integer.parseInt(paid);
            String remaining = Integer.toString(p1 - p2);


             // Load the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
           
            // Establish a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject", "root", "krishna04");
            
            PreparedStatement psmt = con.prepareStatement("INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            psmt.setString(1, name);
            psmt.setString(2, email);
            psmt.setString(3, mobile);
            psmt.setString(4, adhar);
            psmt.setString(5, gender);
            psmt.setString(6, age);
            psmt.setString(7, country);
            psmt.setString(8, rnumber);
            psmt.setString(9, price);
            psmt.setString(10, paid);
            psmt.setString(11, remaining);
            
             boolean b = psmt.execute();
           if(b==false)
           {
              PreparedStatement psmt2 = con.prepareStatement("update rooms set availability = 'not available' where roomnumber = ?");
              psmt2.setString(1, rnumber);
              boolean b2 = psmt2.execute();
           if(b2==false)
           {
               resp.setContentType("text/html");
                RequestDispatcher rd = req.getRequestDispatcher("/show_rooms4.jsp");
               rd.include(req, resp);
               RequestDispatcher rd2 = req.getRequestDispatcher("/succesfull.html");
               rd2.include(req, resp);
              
               
               
               
               hs.removeAttribute("cus_name");
               hs.removeAttribute("cus_email");
               hs.removeAttribute("cus_mobile");
               hs.removeAttribute("cus_adhar");
               hs.removeAttribute("cus_age");
               hs.removeAttribute("cus_gender");
               hs.removeAttribute("cus_country");
           }

           }


            
        }
        catch(Exception ex)
        {
            out.println(ex.getMessage());
        }
    }
}
