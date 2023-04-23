import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
//@WebServlet("/ViewServlet")  
public class viewacc extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='addaccountant.html'>Add New Employee</a>");  
        out.println("<h1>Accountant List</h1>");  
          
        List<accountant> list=managmentDAO.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Address</th> <th>Contact</th><th>Edit</th><th>Delete</th></tr>");  
        for(accountant e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td>  <td>"+e.getPassword()+"</td><td>"+e.getAddress()+"</td><td>"+e.getContact()+"</td><td><a href='editacc?id="+e.getId()+"'>edit</a></td>  <td><a href='deleteacc?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  