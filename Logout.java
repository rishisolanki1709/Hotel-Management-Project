
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Logout")
public class Logout extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession hs = req.getSession(false);
        if (hs != null) {
            hs.invalidate();
            
            // Forward to the login page
            resp.sendRedirect("index.html");
        }
        else
        {
            PrintWriter out = resp.getWriter();
            out.println("Session Not found");
        }
        
        
    }
    
}