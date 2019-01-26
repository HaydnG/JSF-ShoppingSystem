/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author haydn
 */
public class OrderDTO {
    
    private UserDTO user;
    private Timestamp orderDate;
    private int OrderID;
    private ArrayList<ProductDTO> OrderProducts;
    private double price;
    private int productsAmount;
    private int totalProducts;

    public OrderDTO(UserDTO user, Timestamp orderDate, int OrderID, ArrayList<ProductDTO> OrderProducts) {
        this.user = user;
        this.orderDate = orderDate;
        this.OrderID = OrderID;
        this.OrderProducts = OrderProducts;
    }
    
    public OrderDTO() {
        this.user = null;
        this.orderDate = null;
        this.OrderID = 0;
        this.OrderProducts = null;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public ArrayList<ProductDTO> getOrderProducts() {
        return OrderProducts;
    }

    public void setOrderProducts(ArrayList<ProductDTO> OrderProducts) {
        this.OrderProducts = OrderProducts;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductsAmount() {
        return productsAmount;
    }

    public void setProductsAmount(int productsAmount) {
        this.productsAmount = productsAmount;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }
    
    
    
    
    
  
    
}
