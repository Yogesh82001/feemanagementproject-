import java.util.*;  
import java.sql.*;  
  
public class managmentDAO {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");  
        }catch(Exception e){System.out.println(e);}                                                                                    
        return con;  
    }  
    public static int save(accountant e){  
        int status=0;  
        try{  
            Connection con=managmentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into accountant (name,email,password,address,contact) values (?,?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getPassword());  
            ps.setString(4,e.getAddress()); 
            ps.setString(5,e.getContact());
            
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(accountant e){  
        int status=0;  
        try{  
            Connection con=managmentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update accountant set name=?,email=?,password=?,address=? ,contact=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getPassword());  
            ps.setString(4,e.getAddress());  
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
            PreparedStatement ps=con.prepareStatement("delete from accountant where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static accountant getEmployeeById(int id){  
        accountant e=new accountant();  
          
        try{  
            Connection con=managmentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from accountant where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setPassword(rs.getString(4));  
                e.setAddress(rs.getString(5));  
                e.setContact(rs.getString(6)); 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<accountant> getAllEmployees(){  
        List<accountant> list=new ArrayList<accountant>();  
          
        try{  
            Connection con=managmentDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from accountant");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                accountant e=new accountant();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setPassword(rs.getString(4));  
                e.setAddress(rs.getString(5)); 
                e.setContact(rs.getString(6));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  