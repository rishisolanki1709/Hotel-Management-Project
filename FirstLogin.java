
//import com.mysql.cj.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/FirstLogin")
public class FirstLogin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");
        HttpSession hs = req.getSession(true);
        hs.setAttribute("email", email);

        try {
            // now performing jdbc 5 steps i,e.

            // load the driver
            Class.forName("com.mysql.jdbc.Driver");

            // make Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject", "root", "krishna04");

            int count = 0;
            //make PrepareStatement object

            PreparedStatement psmt = con.prepareStatement("select * from employee where email = ?");

            psmt.setString(1, email);

            ResultSet rs = psmt.executeQuery();
            

            // employee 
            if (rs.next()) {
                
                String pwd = rs.getString("password");
                hs.setAttribute("password", pwd);
                RequestDispatcher rd = req.getRequestDispatcher("/employee_login.jsp");
                rd.forward(req, resp);
                count++;                
            } 

            
            // Admin
            else if (count == 0) {
                psmt = con.prepareStatement("select * from admin where email = ?");
                psmt.setString(1, email);

                 
                
                ResultSet rs2 = psmt.executeQuery();
                if (rs2.next()) {
                String pwd = rs2.getString("password");
                hs.setAttribute("password", pwd);
                RequestDispatcher rd = req.getRequestDispatcher("/admin_login.jsp");
                rd.forward(req, resp);
                count++; 


                }

            } 
            
            if (count == 0)
            {
                RequestDispatcher rd = req.getRequestDispatcher("/customer_home.html");
                rd.forward(req, resp);
//                resp.getWriter().println("<script>window.open('customer_home.html', '_blank');</script>");
            }
            
            else
            {
                out.println("Error...");
            }

            con.close();

        } catch (Exception ex) {
            out.println(ex.getMessage());
        }

    }

}
