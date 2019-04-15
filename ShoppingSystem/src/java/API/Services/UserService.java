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

@Path("/{AuthID}/User")
public class UserService {
    
    
    @GET
    @Produces("application/json")
    public UserDTO GetProduct(@PathParam("AuthID") String AuthID){
        ServiceAuthentication Auth = new ServiceAuthentication();     
        
        UserDTO User = Auth.AuthenticateUser(AuthID);
        if(User == null || !User.isLoggedIn()){
            throw new NotAuthorizedException("Access denied");
        }else{
            User.setPassword(null);
            User.setUsearch(null);
            
            return User;
        }
    }

}
