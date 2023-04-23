import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/editacc2")  
public class editacc2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String email=request.getParameter("email");  
        String password=request.getParameter("password");  
        String address=request.getParameter("address");  
        String contact=request.getParameter("contact");
          
        accountant e=new accountant();  
        e.setId(id);  
        e.setName(name);  
        e.setEmail(email);  
        e.setPassword(password);  
        e.setAddress(address);
        e.setContact(contact);
          
        int status=managmentDAO.update(e);  
        if(status>0){  
            response.sendRedirect("viewacc");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  