
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


@WebServlet("/New_Customer2")
public class New_Customer2 extends HttpServlet
{    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
        
        HttpSession session = req.getSession(false); // Do not create a new session
if (session == null || session.getAttribute("email") == null) {
    resp.sendRedirect("customer_home.html");
    return;
}

        PrintWriter out = resp.getWriter();
        try
        {
            
            String name = req.getParameter("cus_name");
            String email = req.getParameter("cus_email");
            String mobile = req.getParameter("cus_mobile");
            String adhar = req.getParameter("cus_adhar");
            String gender = req.getParameter("cus_gender");
            String age = req.getParameter("cus_age");
            String country = req.getParameter("cus_country");
            
            
            HttpSession hs = req.getSession(false);
            hs.setAttribute("cus_name", name);
            hs.setAttribute("cus_email", email);
            hs.setAttribute("cus_mobile", mobile);
            hs.setAttribute("cus_adhar", adhar);
            hs.setAttribute("cus_gender", gender);
            hs.setAttribute("cus_age", age);
            hs.setAttribute("cus_country", country);
            
            
          RequestDispatcher rd = req.getRequestDispatcher("/show_rooms4.jsp");
                rd.include(req, resp);
        }
        catch(Exception ex)
        {
            out.println(ex.getMessage());
        }
    }
}

   


        