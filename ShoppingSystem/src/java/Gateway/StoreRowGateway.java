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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haydn
 */
public class StoreRowGateway {
    
    public ArrayList<StoreDTO> GetStores(){
        ArrayList<StoreDTO> Stores = new ArrayList<StoreDTO>();
        

        StoreDTO Store;
        AddressDTO Address;
 
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("SELECT STORE.ID, STORE.NAME, STORE.ADDRESSID FROM STORE FETCH FIRST 20 ROWS ONLY");
       
    
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                Address = new AddressDTO();
                Address.setID(rs.getInt("ADDRESSID"));
                //Address = new AddressDTO(rs.getInt("ADDRESS_ID"),rs.getString("EMAIL"), rs.getString("ADDRLINE1"), rs.getString("ADDRLINE2"), rs.getString("CITY"), rs.getString("COUNTY"), rs.getString("ZIPCODE"));
                Store = new StoreDTO(rs.getInt("ID"), rs.getString("NAME"), Address);

                Stores.add(Store);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return Stores;
    }
    
}
