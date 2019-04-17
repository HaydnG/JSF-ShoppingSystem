/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.*;
import DbConn.DbManager;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haydn
 */
public class UserRowGateway {
    
    
    public UserDTO FindUserByID(int UserID){
        UserDTO user = null;
        AddressDTO address = null;
        PasswordDTO password = null;
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("SELECT USERS.ID AS USERID, USERS.FNAME, USERS.LNAME,USERS.ADMIN, USERS.USERNAME, USERS.SALT, USERS.PASSWORD, USERS.ADDRESSID, " +
                                        "ADDRESS.ID AS ADDRESSID, ADDRESS.EMAIL, ADDRESS.ADDRLINE1, ADDRESS.ADDRLINE2, ADDRESS.CITY, ADDRESS.COUNTY, ADDRESS.ZIPCODE " +
                                        "FROM USERS, ADDRESS " +
                                        "WHERE USERS.ID = ? " +
                                        "AND USERS.ADDRESSID = ADDRESS.ID");
       
    
            stmt.setInt(1, UserID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                password = new PasswordDTO(null, rs.getString("PASSWORD"), rs.getString("SALT"));
                address = new AddressDTO(rs.getInt("ADDRESSID"),rs.getString("EMAIL"), rs.getString("ADDRLINE1"), rs.getString("ADDRLINE2"), rs.getString("CITY"), rs.getString("COUNTY"), rs.getString("ZIPCODE"));
                
                user = new UserDTO(password, address, rs.getInt("USERID"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("USERNAME"));
                user.setAdmin(rs.getBoolean("ADMIN"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return user;
    }
    
    public UserDTO FindUserByUsername(String username){
        UserDTO user = null;
        AddressDTO address = null;
        PasswordDTO password = null;
        String sql = "SELECT USERS.ID AS USERID, USERS.FNAME,USERS.ADMIN, USERS.LNAME, USERS.USERNAME, "
                + "USERS.SALT, USERS.PASSWORD, USERS.ADDRESSID, ADDRESS.ID AS ADDRESSID, ADDRESS.EMAIL, "
                + "ADDRESS.ADDRLINE1, ADDRESS.ADDRLINE2, ADDRESS.CITY, ADDRESS.COUNTY, ADDRESS.ZIPCODE "
                + "FROM USERS, ADDRESS "
                + "WHERE LOWER(USERS.USERNAME) = LOWER(?) "
                + "AND USERS.ADDRESSID = ADDRESS.ID";
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
       
    
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                password = new PasswordDTO(null, rs.getString("PASSWORD"), rs.getString("SALT"));
                address = new AddressDTO(rs.getInt("ADDRESSID"),rs.getString("EMAIL"), rs.getString("ADDRLINE1"), rs.getString("ADDRLINE2"), rs.getString("CITY"), rs.getString("COUNTY"), rs.getString("ZIPCODE"));
                
                user = new UserDTO(password, address, rs.getInt("USERID"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("USERNAME"));
                user.setAdmin(rs.getBoolean("ADMIN"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        return user;
    }
    
    public Boolean RemoveUser(UserDTO user){
        
        int count = 0;
        boolean added = false;
     
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("DELETE FROM USERS WHERE ID = ?");

            stmt.setInt(1, user.getID());
            //stmt.setString(2, SearchString);
            
            count = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return (count > 0);
    }
    
    public Boolean SetUserRole(UserDTO user){
        
        int count = 0;
        boolean added = false;
     
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("UPDATE USERS SET ADMIN = ? WHERE ID = ?");
       
    
            stmt.setBoolean(1, user.getAdmin());
            stmt.setInt(2, user.getID());
            //stmt.setString(2, SearchString);
            
            count = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return (count > 0);
    }
    
    public ArrayList<UserDTO> GetUsers(UserDTO User){
        ArrayList<UserDTO> Users = new ArrayList<UserDTO>();
        
        String SearchString = "%" + User.getUsearch() + "%";
        UserDTO user = null;
        AddressDTO address = null;
        PasswordDTO password = null;
        
        System.out.println("SearchString: " + User.getUsearch());
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        String sql = "SELECT USERS.ID AS USERID, USERS.FNAME,USERS.ADMIN, USERS.LNAME, USERS.USERNAME, USERS.SALT, USERS.PASSWORD, USERS.ADDRESSID, " +
                                        "ADDRESS.ID AS ADDRESSID, ADDRESS.EMAIL, ADDRESS.ADDRLINE1, ADDRESS.ADDRLINE2, ADDRESS.CITY, ADDRESS.COUNTY, ADDRESS.ZIPCODE " +
                                        "FROM USERS, ADDRESS " +
                                        "WHERE (LOWER(USERS.FNAME) LIKE ? OR LOWER(USERS.LNAME) LIKE ? OR LOWER(USERS.USERNAME) LIKE ?) " +
                                        "AND USERS.ADDRESSID = ADDRESS.ID "
                                        + "AND USERS.ID != ? ";
        if(User.isShowAdmins()){
            sql += "AND USERS.ADMIN = TRUE ";
        }
        
        sql += "ORDER BY USERS.ADMIN DESC, USERS.FNAME ASC, USERS.LNAME ASC "
            + "FETCH FIRST 36 ROWS ONLY";
        
        try {
            stmt = conn.prepareStatement(sql);
       
    
            stmt.setString(1, SearchString);
            stmt.setString(2, SearchString);
            stmt.setString(3, SearchString);
            stmt.setInt(4, User.getID());
            //stmt.setString(2, SearchString);
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                password = new PasswordDTO(null, rs.getString("PASSWORD"), rs.getString("SALT"));
                address = new AddressDTO(rs.getInt("ADDRESSID"),rs.getString("EMAIL"), rs.getString("ADDRLINE1"), rs.getString("ADDRLINE2"), rs.getString("CITY"), rs.getString("COUNTY"), rs.getString("ZIPCODE"));
                
                user = new UserDTO(password, address, rs.getInt("USERID"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("USERNAME"));
                user.setAdmin(rs.getBoolean("ADMIN"));
                
                
                Users.add(user);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return Users;
    }
    
    public int AddUser(UserDTO user){
        int last_inserted_id = -1;
        
        
        String sql = "insert into USERS (FNAME, LNAME, USERNAME, SALT, PASSWORD, ADDRESSID,ADMIN) values (?, ?, ?, ?, ?, ?,?)";
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       
    
            stmt.setString(1, user.getFName());
            stmt.setString(2, user.getLName());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword().getSalt());
            stmt.setString(5,  user.getPassword().getHashedPassword());
            stmt.setInt(6, user.getAddress().getID());
            stmt.setBoolean(7, user.getAdmin());
            
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                last_inserted_id = rs.getInt(1);
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("PRINT: " + last_inserted_id );
        return last_inserted_id;
    }

    public Boolean UserExists(UserDTO user) {
        String sql = "SELECT USERS.ID FROM USERS WHERE USERS.USERNAME = ?";
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
       
    
            stmt.setString(1, user.getUsername());
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return true;
            }else{
                return false;
            }
            
            

            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
    
    
    
    
    
}
