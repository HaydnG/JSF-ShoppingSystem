/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import CommandController.CommandFactory;
import DTO.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author haydn
 */
@Named(value = "order")
@SessionScoped
public class OrderBean implements Serializable {
    
    private OrderDTO OrderView;
    
    @Inject
    private CartBean cartbean;
    @Inject
    private UserBean userbean;
    
    public String Order() {
        cartbean.UpdateShoppingCart();
        OrderDTO temporder = new OrderDTO();
        temporder.setUser(userbean.getUser());
        temporder.setOrderProducts(cartbean.getShoppingCart());
        temporder.setOrderDate(new java.sql.Timestamp(new java.util.Date().getTime()));
        
        int OrderID = (int) CommandFactory.CreateCommand(CommandFactory.PLACE_ORDER, temporder).execute();
        System.out.println("OrderID: " + OrderID);
        
        temporder.setOrderID(OrderID);
        
        cartbean.ClearCart();
        

        return ViewOrder(temporder);
    }
    
    public int totalProducts(OrderDTO Order){
        int products = 0;
        for(ProductDTO p : Order.getOrderProducts()){   
            products += p.getNumInCart();
        
        }
        return products;
    }
    
    public double totalPrice(OrderDTO Order){
        double price = 0;
        for(ProductDTO p : Order.getOrderProducts()){   
            price += (p.getNumInCart() * p.getPrice());
        
        }
        return price;
    }
    
    
    public String ViewOrder(OrderDTO Order){
        OrderView = (OrderDTO) CommandFactory.CreateCommand(CommandFactory.FIND_ORDER, Order).execute();
        return "OrderP";
    }
    
    public ArrayList<OrderDTO> getOrders(){
        return (ArrayList<OrderDTO>) CommandFactory.CreateCommand(CommandFactory.GET_ORDERS, userbean.getUser()).execute();
    }

    public OrderDTO getOrderView() {
        return OrderView;
    }

    public void setOrderView(OrderDTO OrderView) {
        this.OrderView = OrderView;
    }
    
    
    
    
}
