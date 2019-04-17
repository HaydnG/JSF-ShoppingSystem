/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.Services;

import DTO.ProductDTO;
import DTO.StoreDTO;
import DTO.UserDTO;
import Gateway.ProductRowGateway;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author haydn
 */

@Path("/Product")
public class ProductService {
    
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public ProductDTO GetProduct(@PathParam("id") int ProductID, @HeaderParam("authorization") String AuthID){
        ProductRowGateway PGate = new ProductRowGateway();
        ServiceAuthentication Auth = new ServiceAuthentication();     
        
        if(AuthID == null){
            throw new NotAuthorizedException("Access denied");
        }
        
        UserDTO User = Auth.AuthenticateUser(AuthID);
        if(User == null || !User.isLoggedIn()){
            throw new NotAuthorizedException("Access denied");
        }else{
            return PGate.FindProductByID(ProductID);
        }
    }
    
    @GET
    @Path("/All/{search}")
    @Produces("application/json")
    public  ArrayList<ProductDTO> GetProducts(@PathParam("search") String Search,@HeaderParam("authorization") String AuthID){
        ProductRowGateway PGate = new ProductRowGateway();
        ServiceAuthentication Auth = new ServiceAuthentication();     
        
        if(AuthID == null){
            throw new NotAuthorizedException("Access denied");
        }
        
        UserDTO User = Auth.AuthenticateUser(AuthID);
        if(User == null || !User.isLoggedIn()){
            throw new NotAuthorizedException("Access denied");
        }else{
            return PGate.GetProducts(Search, false, false);
        }
    }
    
    @GET
    @Path("/All/{search}/Store/{id}")
    @Produces("application/json")
    public  ArrayList<ProductDTO> GetProductsByStore(@PathParam("search") String Search,@HeaderParam("authorization") String AuthID,@PathParam("id") int StoreID){
        ProductRowGateway PGate = new ProductRowGateway();
        ServiceAuthentication Auth = new ServiceAuthentication();     
        
        if(AuthID == null){
            throw new NotAuthorizedException("Access denied");
        }
        
        UserDTO User = Auth.AuthenticateUser(AuthID);
        if(User == null || !User.isLoggedIn()){
            throw new NotAuthorizedException("Access denied");
        }else{
            return PGate.GetProductsByStore(Search, StoreID, false, false);
        }
    }
}
