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
public class OrderRowGateway {
    
    public OrderDTO FindOrder(OrderDTO Order){
        ArrayList<ProductDTO> Products = new ArrayList<ProductDTO>();
        OrderDTO newOrder = new OrderDTO();
        
        ProductDTO Product;
        StoreDTO Store;
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("SELECT PRODUCT.ID, PRODUCT.NAME, PRODUCT.LONGNAME, PRODUCT.PRICE, PRODUCT.DESCRIPTION, ORDERS.DATETIME, ORDERPRODUCT.QUANTITY "
                    + "FROM PRODUCT, ORDERS, ORDERPRODUCT "
                    + "WHERE PRODUCT.ID = ORDERPRODUCT.PRODUCTID "
                    + "AND ORDERS.ID = ORDERPRODUCT.ORDERID "
                    + "AND ORDERS.ID = ? "
                    + "ORDER BY PRODUCT.ID");

    
            stmt.setInt(1, Order.getOrderID());
            ResultSet rs = stmt.executeQuery();
            newOrder.setOrderID(Order.getOrderID());
            
            while(rs.next())
            {
                newOrder.setOrderDate(rs.getTimestamp("DATETIME"));
                Store = new StoreDTO();
                Product = new ProductDTO(rs.getInt("ID"),rs.getString("NAME"),rs.getString("LONGNAME"),rs.getDouble("PRICE"), rs.getString("DESCRIPTION"), Store);
                Product.setNumInCart(rs.getInt("QUANTITY"));
                Products.add(Product);
            }
            newOrder.setOrderProducts(Products);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return newOrder;
    }
    
    
    public ArrayList<OrderDTO> GetOrders(int UserID){
        ArrayList<OrderDTO> Orders = new ArrayList<OrderDTO>();
        
        OrderDTO order;
        
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;

        
        try {
            stmt = conn.prepareStatement("SELECT o.DATETIME,o.ID, (SELECT COUNT(ORDERID) FROM ORDERPRODUCT op WHERE op.ORDERID = o.ID) AS NUMOFPRODUCTS,"
                    + "(SELECT SUM(QUANTITY) FROM ORDERPRODUCT op WHERE op.ORDERID = o.ID) AS QUANTITYOFPRODUCTS,"
                    + "(SELECT SUM(PRODUCT.PRICE * op.QUANTITY) FROM ORDERPRODUCT op,PRODUCT WHERE op.ORDERID = o.ID AND op.PRODUCTID = PRODUCT.ID) AS TOTALCOST "
                    + "FROM ORDERS o WHERE o.USERID = ? "
                    + "ORDER BY o.DATETIME DESC "
                    + "FETCH FIRST 25 ROWS ONLY");
       
    
            stmt.setInt(1, UserID);
            //stmt.setString(2, SearchString);
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                order = new OrderDTO();
                order.setOrderID(rs.getInt("ID"));
                order.setOrderDate(rs.getTimestamp("DATETIME"));
                order.setPrice(rs.getDouble("TOTALCOST"));
                order.setProductsAmount(rs.getInt("NUMOFPRODUCTS"));
                order.setTotalProducts(rs.getInt("QUANTITYOFPRODUCTS"));
                Orders.add(order);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return Orders;
    }
    
    public int PlaceOrder(OrderDTO order){
        int last_inserted_id = -1;
        
        
        String sql = "insert into ORDERS ( USERID, DATETIME) values ( ?, ?)";
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       
    
            stmt.setInt(1, order.getUser().getID());
            stmt.setTimestamp(2, order.getOrderDate());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                last_inserted_id = rs.getInt(1);
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(OrderRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        return last_inserted_id;
    }
    
    public int AddOrderProducts(OrderDTO order){
        int last_inserted_id = -1;
        
        
        String sql = "insert into ORDERPRODUCT (ORDERID, PRODUCTID, QUANTITY) values (?, ?, ?)";
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
       
            for(ProductDTO p : order.getOrderProducts()){
                stmt.setInt(1, order.getOrderID());
                stmt.setInt(2, p.getID());
                stmt.setInt(3, p.getNumInCart());
                stmt.addBatch();


                
                
            
            }
            stmt.executeBatch();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        return order.getOrderID();
    }
    
    public int RemoveOrderProducts(int userID){
        int last_inserted_id = -1;
        
        
        String sql = "DELETE FROM ORDERPRODUCT WHERE ORDERPRODUCT.ORDERID IN (SELECT ORDERS.ID FROM ORDERS WHERE ORDERS.USERID = ?)";
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
       
    
            stmt.setInt(1, userID);
            
            stmt.executeUpdate();

            
        } catch (SQLException ex) {
            Logger.getLogger(OrderRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        return last_inserted_id;
    }
    
    public int RemoveOrder(int userID){
        int last_inserted_id = -1;
        
        
        String sql = "DELETE FROM ORDERS WHERE ORDERS.USERID = ?";
        
        Connection conn = DbManager.getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
       
    
            stmt.setInt(1, userID);
            
            stmt.executeUpdate();

            
        } catch (SQLException ex) {
            Logger.getLogger(OrderRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        return last_inserted_id;
    }
    
    
    
}
