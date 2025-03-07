
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





@WebServlet("/Delete_Employee")
public class Delete_Employee extends HttpServlet
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
        String d_email = req.getParameter("d_email");
        String mail = "@gmail.com";
        try
        {
            //load the Driver
            Class.forName("com.mysql.jdbc.Driver");
            //make Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","krishna04");
            //makePreparedStatement object;
            PreparedStatement psmt = con.prepareStatement("delete from employee where trim(email) = ?");
            psmt.setString(1, d_email);
            //execute the query;
            boolean b = psmt.execute();
            if(b == false && d_email.endsWith(mail))
            {
                resp.setContentType("text/html");
                out.println("<h2 style='color: green; text-align: center;'><b>Your Employee Deleted Succesfully...</b></h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/successfull2.html");
                rd.include(req, resp);
                RequestDispatcher rd2 = req.getRequestDispatcher("edit_employee.html");
                rd2.include(req, resp);
            }
            else{
                resp.setContentType("text/html");
                out.println("<h2 style='color:red' align='center'>Email Not Found</h2>");
                RequestDispatcher rd2 = req.getRequestDispatcher("delete_employee.html");
                rd2.include(req, resp);
            }
            //close the conection
            con.close();
        }catch(Exception ex)
        {
            out.println(ex.getMessage());
        }
        
    }
    
}