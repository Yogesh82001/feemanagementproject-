import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Student")
public class student extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String courses=request.getParameter("courses");
        String fees=request.getParameter("fees");
        String contact=request.getParameter("contact");
        
       stu e=new stu();  
        e.setName(name);  
        e.setEmail(email);  
        e.setCourses(courses);  
        e.setFees(fees);  
        e.setContact(contact);
        int status=studentDAO.save(e);  
        if(status>0){   
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("Studentform.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  