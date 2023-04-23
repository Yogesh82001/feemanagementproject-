import java.util.*;  
import java.sql.*;  
public class studentDAO {

  
  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");  
        }catch(Exception e){System.out.println(e);}                                                                                    
        return con;  
    }  
    public static int save(stu e){  
        int status=0;  
        try{  
            Connection con=studentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into student (name,email,courses,fees,contact) values (?,?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getCourses());  
            ps.setString(4,e.getFees()); 
            ps.setString(5,e.getContact());
            
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(stu e){  
        int status=0;  
        try{  
            Connection con=managmentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update student set name=?,email=?,courses=?,fees=? ,contact=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getCourses());  
            ps.setString(4,e.getFees());  
            ps.setString(5,e.getContact());
            ps.setInt(6,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=managmentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from student where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static stu getEmployeeById(int id){  
        stu e=new stu();  
          
        try{  
            Connection con=studentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from student where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setCourses(rs.getString(4));  
                e.setFees(rs.getString(5));  
                e.setContact(rs.getString(6)); 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<stu> getAllEmployees(){  
        List<stu> list=new ArrayList<stu>();  
          
        try{  
            Connection con=managmentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from student");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                stu e=new stu();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setCourses(rs.getString(4));  
                e.setFees(rs.getString(5)); 
                e.setContact(rs.getString(6));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}    

