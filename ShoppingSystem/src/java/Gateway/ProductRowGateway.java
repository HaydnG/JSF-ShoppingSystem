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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haydn
 */
public class ProductRowGateway {
    
    public ArrayList<ProductDTO> GetProducts(String PSearch, boolean ShowDisabled, boolean ShowBoth){
        ArrayList<ProductDTO> Products = new ArrayList<ProductDTO>();
        
        String SearchString = "%" + PSearch + "%";
        ProductDTO Product;
        StoreDTO Store;
        AddressDTO Address;
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        String sql ="SELECT PRODUCT.ID, PRODUCT.NAME,PRODUCT.DISABLED, PRODUCT.STOREID, PRODUCT.LONGNAME, PRODUCT.PRICE, PRODUCT.DESCRIPTION, STORE.ID AS STOREID, STORE.NAME AS STORENAME "
                    + "FROM PRODUCT "
                    + "INNER JOIN STORE ON PRODUCT.STOREID = STORE.ID "
                    + "WHERE LOWER(PRODUCT.NAME) LIKE ? ";
        if(ShowDisabled){
            sql +="AND PRODUCT.DISABLED = TRUE ";
            sql +="FETCH FIRST 36 ROWS ONLY";
        }else if(!ShowBoth){
            sql += "AND PRODUCT.DISABLED = FALSE ";
            sql +="FETCH FIRST 30 ROWS ONLY";
        }else if (ShowBoth){
            sql += "ORDER BY PRODUCT.DISABLED DESC, PRODUCT.NAME ASC ";
            sql +="FETCH FIRST 36 ROWS ONLY";
        }
        
        
        
        try {
            stmt = conn.prepareStatement(sql);
       
    
            stmt.setString(1, SearchString);
            //stmt.setString(2, SearchString);
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                Address = new AddressDTO();
                //Address = new AddressDTO(rs.getInt("ADDRESS_ID"),rs.getString("EMAIL"), rs.getString("ADDRLINE1"), rs.getString("ADDRLINE2"), rs.getString("CITY"), rs.getString("COUNTY"), rs.getString("ZIPCODE"));
                Store = new StoreDTO(rs.getInt("STOREID"), rs.getString("STORENAME"), Address);
                //Store = new StoreDTO();
                Product = new ProductDTO(rs.getInt("ID"),rs.getString("NAME"),rs.getString("LONGNAME"),rs.getDouble("PRICE"), rs.getString("DESCRIPTION"), Store);
                Product.setDisabled(rs.getBoolean("DISABLED"));
                
                
                Products.add(Product);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return Products;
    }
    
    public int CreateProduct(ProductDTO product){
        int last_inserted_id = -1;
        
        
        String sql = "INSERT INTO PRODUCT (NAME, LONGNAME, PRICE, STOREID, DESCRIPTION, DISABLED) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       
    
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getLongName());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStore().getID());
            stmt.setString(5, product.getDescription());
            stmt.setBoolean(6, product.isDisabled());
            
            
            
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
    
    public ArrayList<ProductDTO> GetProductsByStore(String PSearch, int StoreID, boolean ShowDisabled, boolean ShowBoth){
        ArrayList<ProductDTO> Products = new ArrayList<ProductDTO>();
        
        String SearchString = "%" + PSearch + "%";
        ProductDTO Product;
        StoreDTO Store;
        AddressDTO Address;
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        
        String sql = "SELECT PRODUCT.ID, PRODUCT.NAME,PRODUCT.DISABLED, PRODUCT.STOREID, PRODUCT.LONGNAME, PRODUCT.PRICE, PRODUCT.DESCRIPTION, STORE.ID AS STOREID, STORE.NAME AS STORENAME "
                    + "FROM PRODUCT "
                    + "INNER JOIN STORE ON PRODUCT.STOREID = STORE.ID "
                    + "WHERE LOWER(PRODUCT.NAME) LIKE ? AND STORE.ID = ? ";
                    
        if(ShowDisabled){
            sql +="AND PRODUCT.DISABLED = TRUE ";
            sql +="FETCH FIRST 36 ROWS ONLY";
        }else if(!ShowBoth){
            sql += "AND PRODUCT.DISABLED = FALSE ";
            sql +="FETCH FIRST 30 ROWS ONLY";
        }else if (ShowBoth){
            sql += "ORDER BY PRODUCT.DISABLED DESC, PRODUCT.NAME ASC ";
            sql +="FETCH FIRST 36 ROWS ONLY";
        }
        
        try {
            stmt = conn.prepareStatement(sql);
       
    
            stmt.setString(1, SearchString);
            stmt.setInt(2, StoreID);
            //stmt.setString(2, SearchString);
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                Address = new AddressDTO();
                //Address = new AddressDTO(rs.getInt("ADDRESS_ID"),rs.getString("EMAIL"), rs.getString("ADDRLINE1"), rs.getString("ADDRLINE2"), rs.getString("CITY"), rs.getString("COUNTY"), rs.getString("ZIPCODE"));
                Store = new StoreDTO(rs.getInt("STOREID"), rs.getString("STORENAME"), Address);
                //Store = new StoreDTO();
                Product = new ProductDTO(rs.getInt("ID"),rs.getString("NAME"),rs.getString("LONGNAME"),rs.getDouble("PRICE"), rs.getString("DESCRIPTION"), Store);

                Product.setDisabled(rs.getBoolean("DISABLED"));
                
                
                Products.add(Product);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return Products;
    }
    

    public Boolean SetProductState(ProductDTO product){
        
        int count = 0;
        boolean added = false;
     
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        System.out.println(product.getID() + ": " + product.isDisabled());

        
        try {
            stmt = conn.prepareStatement("UPDATE PRODUCT SET DISABLED = ? WHERE ID = ?");
       
    
            stmt.setBoolean(1, product.isDisabled());
            stmt.setInt(2, product.getID());
            //stmt.setString(2, SearchString);
            
            count = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return (count > 0);
    }
    
    public ProductDTO FindProductByID(int ProductID){
        ProductDTO Product = null;
        StoreDTO Store;
        AddressDTO Address;
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("SELECT PRODUCT.ID,PRODUCT.DISABLED, PRODUCT.NAME, PRODUCT.STOREID, PRODUCT.LONGNAME, PRODUCT.PRICE, PRODUCT.DESCRIPTION, STORE.ID AS STOREID, STORE.NAME AS STORENAME "
                    + "FROM PRODUCT "
                    + "INNER JOIN STORE ON PRODUCT.STOREID = STORE.ID "
                    + "WHERE PRODUCT.ID = ?"
                    + "FETCH FIRST 25 ROWS ONLY");
       
    
            stmt.setInt(1, ProductID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                Address = new AddressDTO();
                //Address = new AddressDTO(rs.getInt("ADDRESS_ID"),rs.getString("EMAIL"), rs.getString("ADDRLINE1"), rs.getString("ADDRLINE2"), rs.getString("CITY"), rs.getString("COUNTY"), rs.getString("ZIPCODE"));
                Store = new StoreDTO(rs.getInt("STOREID"), rs.getString("STORENAME"), Address);
                //Store = new StoreDTO();
                Product = new ProductDTO(rs.getInt("ID"),rs.getString("NAME"),rs.getString("LONGNAME"),rs.getDouble("PRICE"), rs.getString("DESCRIPTION"), Store);
                Product.setDisabled(rs.getBoolean("DISABLED"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return Product;
    }
    
}
