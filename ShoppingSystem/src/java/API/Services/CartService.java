/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.Services;

import DTO.ProductDTO;
import DTO.UserDTO;
import Gateway.CartRowGateway;
import Gateway.ProductRowGateway;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author haydn
 */
@Path("/Cart")
public class CartService {
    
    @POST
    @Path("/Increment/{id}")
    @Produces("application/json")
    public String IncrementCart(@PathParam("id") int ProductID, @HeaderParam("authorization") String AuthID){
        CartRowGateway CGate = new CartRowGateway();
        ServiceAuthentication Auth = new ServiceAuthentication();     
        int CartQuantity = 0;
        if(AuthID == null){
            throw new NotAuthorizedException("Access denied");
        }
        
        UserDTO User = Auth.AuthenticateUser(AuthID);
        if(User == null || !User.isLoggedIn()){
            throw new NotAuthorizedException("Access denied");
        }else{
            CartQuantity = CGate.CountProductInCart(ProductID, User.getID());
            System.out.println("ProductID " + ProductID + " Quantity "+ CartQuantity);
            if(!CGate.IsProductInCart(ProductID, User.getID())){
                CGate.AddToCart(ProductID, User.getID());
            }else{
                CGate.IncrementItemInCart(ProductID, User.getID());
            }
            
            return CartQuantity + 1 + "";
        }
    }
    
    @POST
    @Path("/Decrement/{id}")
    @Produces("application/json")
    public String DecrementCart(@PathParam("id") int ProductID, @HeaderParam("authorization") String AuthID){
        CartRowGateway CGate = new CartRowGateway();
        ServiceAuthentication Auth = new ServiceAuthentication();     
        int CartQuantity = 0;
        if(AuthID == null){
            throw new NotAuthorizedException("Access denied");
        }
        
        UserDTO User = Auth.AuthenticateUser(AuthID);
        if(User == null || !User.isLoggedIn()){
            throw new NotAuthorizedException("Access denied");
        }else{
            CartQuantity = CGate.CountProductInCart(ProductID, User.getID());
            System.out.println("ProductID " + ProductID + " Quantity "+ CartQuantity);
            if(CartQuantity == 0){
                return CartQuantity + "";
            }else{
                CGate.DecrementItemInCart(ProductID, User.getID());
                return CartQuantity - 1 + "";
            }
            
            
        }
    }
    
    @GET
    @Path("/Get")
    @Produces("application/json")
    public ArrayList<ProductDTO>  GetCart(@HeaderParam("authorization") String AuthID){
        CartRowGateway CGate = new CartRowGateway();
        ServiceAuthentication Auth = new ServiceAuthentication();   
        
        ArrayList<ProductDTO> cart = new ArrayList<ProductDTO>();

        if(AuthID == null){
            throw new NotAuthorizedException("Access denied");
        }
        
        UserDTO User = Auth.AuthenticateUser(AuthID);
        if(User == null || !User.isLoggedIn()){
            throw new NotAuthorizedException("Access denied");
        }else{
            cart = CGate.GetShoppingCart(User.getID());
            
            return cart;
        }
    }
    
    
}
