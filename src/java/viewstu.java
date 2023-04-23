import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/viewstu")  
public class viewstu extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='Studentform.html'>Add New Student</a>");  
        out.println("<h1>Student List</h1>");  
          
        List<stu> list=studentDAO.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Courses</th><th>Fees</th> <th>Contact</th><th>Edit</th><th>Delete</th></tr>");  
        for(stu e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td>  <td>"+e.getCourses()+"</td><td>"+e.getFees()+"</td><td>"+e.getContact()+"</td><td><a href='editacc?id="+e.getId()+"'>edit</a></td>  <td><a href='deleteacc?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  