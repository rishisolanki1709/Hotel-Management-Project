
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/CheckAdminPassword")
public class CheckAdminPass extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false); // Do not create a new session
        if (session == null || session.getAttribute("email") == null) {
        resp.sendRedirect("index.html");
        return;
        }
        
        
        PrintWriter out = resp.getWriter();
        HttpSession hs = req.getSession(false);
        String pwd = (String) hs.getAttribute("password");
        String pwd2 = (String)req.getParameter("password");
        if(pwd.equals(pwd2))
        {
            RequestDispatcher rd = req.getRequestDispatcher("/admin_home.html");
            rd.forward(req, resp);
        }
        else
        {
            resp.setContentType("text/html");
            RequestDispatcher rd = req.getRequestDispatcher("/admin_login.jsp");
            rd.include(req, resp);
            out.println("<div style='color:red' align='center' ><b>Incorrect Password</b></div>");
        }

    }
    
}