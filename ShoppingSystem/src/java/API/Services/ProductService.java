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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author haydn
 */

@Path("/{AuthID}/Product")
public class ProductService {
    
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public ProductDTO GetProduct(@PathParam("id") int ProductID, @PathParam("AuthID") String AuthID){
        ProductRowGateway PGate = new ProductRowGateway();
        ServiceAuthentication Auth = new ServiceAuthentication();     
        
        UserDTO User = Auth.AuthenticateUser(AuthID);
        if(User == null || !User.isLoggedIn()){
            return new ProductDTO(-1, "Authentication Failed", null, null, null, null);
        }else{
            return PGate.FindProductByID(ProductID);
        }
    }
    
}
