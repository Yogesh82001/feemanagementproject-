import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Accountantlogin")
public class Accountantlogin extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String address=request.getParameter("address");
        String contact=request.getParameter("contact");
        
 accountant e=new accountant();  
        e.setName(name);  
        e.setEmail(email);  
        e.setPassword(password);  
        e.setAddress(address);  
        e.setContact(contact);
        int status=managmentDAO.save(e);  
        if(status>0){   
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("addaccountant.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  