/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.dao.impl;

import in.gadgethub.dao.UserDao;
import in.gadgethub.pojo.UserPojo;
import in.gadgethub.utility.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl implements UserDao{
    
    public boolean isRegistered(String emailId){
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection conn=DBUtil.provideConnection();
        boolean flag=false;
        
        try{
      
           ps =conn.prepareStatement("SELECT * FROM users WHERE useremail=?");
           ps.setString(1, emailId);
           rs=ps.executeQuery();
           if(rs.next()){
               flag=true;
              
           }
           
        }
        catch(SQLException ex){
            
            System.out.println("Error in isRegistered"+ex);
            ex.printStackTrace();
        }
        
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return flag;
        
        
        
    }
    
    public String registerUser(UserPojo user){
        String status="Registration Failed";
        boolean isUserRegistered=isRegistered(user.getUseremail());
        if(isUserRegistered){
            
            status="Email Already Registered,Please try again !";
            return status;
        }
        
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps=null;
        try{
           
            ps=conn.prepareStatement("INSERT INTO users values(?,?,?,?,?,?");
            ps.setString(1, user.getUseremail());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getUsermobile());
            ps.setString(4,user.getUseraddress());
            ps.setInt(5,user.getUserpincode());
            ps.setString(6, user.getUserpassoword());
         
            int count =ps.executeUpdate();
            if(count==1){
                
                status="Registration Successfull";
                //code to sent mail 
            }
            
        }
            catch(SQLException ex){
                    System.out.println("Error in Registered user"+ex);
                    ex.printStackTrace();
                    
                    }
        
        DBUtil.closeStatement(ps);
        return status;
        
        
    }
    
    
    
    public String isValidCredentials(String emailId,String password){
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection conn = DBUtil.provideConnection();
        
        String status = "Login Denied,Invalid Username or Password";
        try{
            
            ps = conn.prepareStatement("SELECT * FROM users WHERE useremail=? and password=?");
            ps.setString(1, emailId);
            ps.setString(2, password);
            rs =ps.executeQuery();
            if(rs.next()){
                
                status="Login Successfull";
            }
            
        }
        catch(SQLException ex){
            status ="Error"+ex.getMessage();
            System.out.println("Error in isValidCredentials"+ex);
            ex.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return status;
        
        
        
    }
    
    public UserPojo getUserDetails(String emailId){
        UserPojo user=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        Connection conn = DBUtil.provideConnection();
        
        try{
            
            ps = conn.prepareStatement("SELECT * FROM users WHERE useremail = ?");
            ps.setString(1, emailId);
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new UserPojo();
                user.setUseremail(rs.getString("useremail"));
                user.setUsername(rs.getString("username"));
                user.setUsermobile(rs.getString("mobile"));
                user.setUseraddress(rs.getString("address"));
                user.setUserpincode(rs.getInt("pincode"));
                user.setUseraddress(rs.getString("password"));
            }
        }
        
        catch(SQLException ex){
            
            System.out.println("Error in getUserDetails"+ex);
            ex.printStackTrace();
        }
        
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return user;
        
    }
    
    public String getUserFirstName(String emailId){
        String fName="";
        PreparedStatement ps=null;
        ResultSet rs =null;
        Connection conn = DBUtil.provideConnection();
        try{
            ps = conn.prepareStatement("SELECT username FROM users WHERE useremail=?");
            ps.setString(1,emailId);
            rs=ps.executeQuery();
      
            if(rs.next()){
                String fullName = rs.getString(1);
                fName = fullName.split(" ")[0];
 
            }
            
        }
        catch(SQLException ex){
            
            System.out.println("Error in getFirstName"+ex);
            ex.printStackTrace();
        }
        
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return fName;
        
    }
    
    public String getUserAddr(String emailId){
        
        String userAddress="No Address Found";
        PreparedStatement ps=null;
        ResultSet rs =null;
        Connection conn = DBUtil.provideConnection();
        try{
            ps = conn.prepareStatement("SELECT address FROM users WHERE useremail=?");
            ps.setString(1,emailId);
            rs=ps.executeQuery();
      
            if(rs.next()){

             userAddress= rs.getString(1);
             
          
            }
            
        }
        catch(SQLException ex){
            
            System.out.println("Error in getUserAddr"+ex);
            ex.printStackTrace();
        }
        
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return userAddress;
        
        
        
        
    }
    
    
}
