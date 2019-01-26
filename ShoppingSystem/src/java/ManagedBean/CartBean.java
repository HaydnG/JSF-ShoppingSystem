/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import CommandController.CommandFactory;
import DTO.ProductDTO;
import DTO.UserDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author haydn
 */

@Named(value = "cart")
@SessionScoped
public class CartBean implements Serializable {
    
    private ArrayList<ProductDTO> ShoppingCart;
    @Inject
    private UserBean userbean;
    
    @PostConstruct
    private void init(){
        UpdateShoppingCart();
    
    }
    
    
    
    public void UpdateShoppingCart(){
        System.out.println("updatecart");
        UserDTO user = userbean.getUser();
        this.ShoppingCart = (ArrayList<ProductDTO>) CommandFactory.CreateCommand(CommandFactory.GET_SHOPPING_CART, user).execute();
    }
    
    public ArrayList<ProductDTO> getShoppingCart(){
        return this.ShoppingCart;
    }
    
    public void onload(){
        UpdateShoppingCart();
    }
    
    public Boolean ProductInCart(ProductDTO product){
        if(GetCartQuantity(product.getID()) == 0){
            return false;
        }else{
            return true;
        }
    }
    
    public int GetCartQuantity(int ProductID){
        for(ProductDTO p : ShoppingCart){
            if(p.getID() == ProductID){
                return p.getNumInCart();
            }
        }
        
        return 0;
    }
    
    public void ClearCart(){
        UserDTO tempuser = userbean.getUser();
        int rows = (int) CommandFactory.CreateCommand(CommandFactory.CLEAR_CART, tempuser).execute();
        System.out.println("Cart cleared: " + rows);
        UpdateShoppingCart();
    
    }
    
    public void TakeFromCart(ProductDTO product){
        UserDTO user = userbean.getUser();
        user.setProduct(product);
        
        int count = (int) CommandFactory.CreateCommand(CommandFactory.COUNT_PRODUCT_IN_CART,user).execute();
        boolean success = false;
        
        if(count > 0){
            success = (boolean) CommandFactory.CreateCommand(CommandFactory.DECREMENT_PRODUCT_IN_CART,user).execute();
        }else{
            success = false;
        }

 
        UpdateShoppingCart();

        
        
    }
    
    public void AddToCart(ProductDTO product){
        UserDTO user = userbean.getUser();
        user.setProduct(product);
        
        boolean exists = (boolean) CommandFactory.CreateCommand(CommandFactory.IS_PRODUCT_IN_CART,user).execute();
        boolean success = false;
        
        if(!exists){
            success = (boolean) CommandFactory.CreateCommand(CommandFactory.ADD_PRODUCT_IN_CART,user).execute();
        }else{
            success = (boolean) CommandFactory.CreateCommand(CommandFactory.INCREMENT_PRODUCT_IN_CART,user).execute();
        }
        

        UpdateShoppingCart();

    }
    
    public double getTotalCostOfCart(){
        
        double cost = 0;
        for(ProductDTO p: ShoppingCart){
            cost += p.getPrice() * p.getNumInCart();
        }
        System.out.println("cost of cart: " + cost);
        return cost;
    }
    
    public int getTotalProdInCart(){
        
        int amount = 0;
        for(ProductDTO p: ShoppingCart){
            amount += p.getNumInCart();
        }
        System.out.println("num in cart: " + amount);
        return amount;
    }
    
}
