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
public class CartRowGateway {
    
    public int CountProductInCart(int ProductID, int UserID){

        int Count = 0;
     
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("SELECT SHOPPINGCART.QUANTITY FROM SHOPPINGCART,PRODUCT WHERE PRODUCTID = ? AND USERID = ? AND PRODUCT.ID = PRODUCTID AND PRODUCT.DISABLED = FALSE");
       
    
            stmt.setInt(1, ProductID);
            stmt.setInt(2, UserID);
            //stmt.setString(2, SearchString);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Count += rs.getInt("QUANTITY");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return Count;
    }
    
    public boolean IsProductInCart(int ProductID, int UserID){

        boolean exists = false;
     
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("SELECT SHOPPINGCART.QUANTITY FROM SHOPPINGCART WHERE PRODUCTID = ? AND USERID = ? ");
       
    
            stmt.setInt(1, ProductID);
            stmt.setInt(2, UserID);
            //stmt.setString(2, SearchString);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                exists = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        System.out.println("InCart: " + exists);
        
        return exists;
    }
    
    public Boolean AddToCart(int ProductID, int UserID){
        int count = 0;
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("INSERT INTO SHOPPINGCART (USERID, PRODUCTID, QUANTITY) VALUES (?, ?, 1)");
       
    
            stmt.setInt(1, UserID);
            stmt.setInt(2, ProductID);
            //stmt.setString(2, SearchString);
            count = stmt.executeUpdate();
                
           
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return (count > 0);
    }
    
    public int ClearCart(int UserID){
        int count = 0;
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("DELETE FROM SHOPPINGCART WHERE USERID = ?");
       
    
            stmt.setInt(1, UserID);
            //stmt.setString(2, SearchString);
            count = stmt.executeUpdate();
                
           
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return count;
    }
    
    public Boolean IncrementItemInCart(int ProductID, int UserID){
        
        int count = 0;
        boolean added = false;
     
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("UPDATE SHOPPINGCART SET QUANTITY = QUANTITY + 1 WHERE USERID = ? AND PRODUCTID = ?");
       
    
            stmt.setInt(1, UserID);
            stmt.setInt(2, ProductID);
            //stmt.setString(2, SearchString);
            
            count = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return (count > 0);
    }
    
    public Boolean DecrementItemInCart(int ProductID, int UserID){
        
        int count = 0;
        boolean added = false;
     
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("UPDATE SHOPPINGCART SET QUANTITY = QUANTITY - 1 WHERE USERID = ? AND PRODUCTID = ?");
       
    
            stmt.setInt(1, UserID);
            stmt.setInt(2, ProductID);
            //stmt.setString(2, SearchString);
            
            count = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return (count > 0);
    }
    
    public ArrayList<ProductDTO> GetShoppingCart(int UserID){
        
        ArrayList<ProductDTO> Products = new ArrayList<ProductDTO>();
        
        ProductDTO Product;
        StoreDTO Store;
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("SELECT PRODUCT.ID, PRODUCT.NAME, PRODUCT.LONGNAME, PRODUCT.PRICE, PRODUCT.DESCRIPTION, SHOPPINGCART.QUANTITY "
                    + "FROM PRODUCT, SHOPPINGCART,USERS "
                    + "WHERE PRODUCT.ID = SHOPPINGCART.PRODUCTID "
                    + "AND USERS.ID = SHOPPINGCART.USERID "
                    + "AND USERS.ID = ? "
                    + "AND SHOPPINGCART.QUANTITY != 0 "
                    + "AND PRODUCT.DISABLED = FALSE "
                    + "ORDER BY PRODUCT.ID");

    
            stmt.setInt(1, UserID);
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                Store = new StoreDTO();
                Product = new ProductDTO(rs.getInt("ID"),rs.getString("NAME"),rs.getString("LONGNAME"),rs.getDouble("PRICE"), rs.getString("DESCRIPTION"), Store);
                Product.setNumInCart(rs.getInt("QUANTITY"));
                Products.add(Product);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return Products;
    }

    
}
