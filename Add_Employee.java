
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


@WebServlet("/Add_Employee")
public class Add_Employee extends HttpServlet
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
            
            String name = req.getParameter("e_name");
            String email = req.getParameter("e_email");
            String mobile = req.getParameter("e_mobile");
            String adhar = req.getParameter("e_adhar");
            String gender = req.getParameter("e_gender");
            String age = req.getParameter("e_age");
            String job = req.getParameter("e_job");
            String salary = req.getParameter("e_salary");
            String pwd = req.getParameter("e_password");
            
            
            
            
            
            
            // Load the Driver 
            Class.forName("com.mysql.jdbc.Driver");
            
            // make Connection 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minorproject","root","krishna04");
            
            // make PreparedStatement object
            
            PreparedStatement psmt = con.prepareStatement("insert into employee(name,email,adhar,mobile,gender,job,salary,age,password) values(?,?,?,?,?,?,?,?,?)");
            
            psmt.setString(1, name);
            psmt.setString(2, email);
            psmt.setString(3, adhar);
            psmt.setString(4, mobile);
            psmt.setString(5, gender);
            psmt.setString(6, job);
            psmt.setString(7, salary);
            psmt.setString(8, age);
            psmt.setString(9, pwd);
            
            boolean b = psmt.execute();
            if (b == false)
            {
                resp.setContentType("text/html");
                out.println(" <h2 style=\"color: green; text-align: center;\"><b>Your Employee Added Succesfully...</b></h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/successfull2.html");
                rd.include(req, resp);
                RequestDispatcher rd2 = req.getRequestDispatcher("edit_employee.html");
                rd2.include(req, resp);
                        
            }
            
            
            con.close();
        }
        catch(Exception ex)
        {
            out.println(ex.getMessage());
        }
    }
}

   


        