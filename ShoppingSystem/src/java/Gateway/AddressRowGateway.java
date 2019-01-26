/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.*;
import DbConn.DbManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haydn
 */
public class AddressRowGateway {
    
    public int AddAddress(AddressDTO address){
        int last_inserted_id = -1;
        
        
        String sql = "insert into ADDRESS (EMAIL, ADDRLINE1, ADDRLINE2, CITY, COUNTY, ZIPCODE) values (?, ?, ?, ?, ?, ?)";
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       
    
            stmt.setString(1, address.getEmail());
            stmt.setString(2, address.getAddrline1());
            stmt.setString(3, address.getAddrline2());
            stmt.setString(4, address.getCity());
            stmt.setString(5, address.getCounty());
            stmt.setString(6, address.getZipCode());
            
            
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
    
    public Boolean RemoveAddress(int addressid){
        
        int count = 0;
        boolean added = false;
     
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("DELETE FROM ADDRESS WHERE ID = ?");

            stmt.setInt(1, addressid);
            //stmt.setString(2, SearchString);
            
            count = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return (count > 0);
    }
    
}
