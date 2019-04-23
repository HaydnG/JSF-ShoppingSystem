/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.Services;

import CommandController.Command;
import CommandController.CommandFactory;
import DTO.PasswordDTO;
import DTO.ProductDTO;
import DTO.StoreDTO;
import DTO.UserDTO;
import Gateway.ProductRowGateway;
import Gateway.UserRowGateway;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author haydn
 */

@Path("/User")
public class UserService {
    
    
    @GET
    @Produces("application/json")
    public UserDTO GetUser(@HeaderParam("authorization") String AuthID){
        ServiceAuthentication Auth = new ServiceAuthentication();     
        
        if(AuthID == null){
            throw new NotAuthorizedException("Access denied");
        }
        
        UserDTO User = Auth.AuthenticateUser(AuthID);
        if(User == null || !User.isLoggedIn()){
            throw new NotAuthorizedException("Access denied");
        }else{
            User.setPassword(null);
            User.setUsearch(null);
            
            return User;
        }
    }
    
    
    @POST
    @Path("Register")
    @Consumes("application/json")
    @Produces("application/json")
    public String AddUser(String NewUser){
        System.out.println(NewUser);
        
        UserRowGateway URG = new UserRowGateway();
        
//        if(!URG.UserExists(NewUser)){
//            
//            NewUser.setPassword((PasswordDTO)CommandFactory.CreateCommand(CommandFactory.HASH_PASSWORD, NewUser.getPassword()).execute());
//            
//            return URG.AddUser(NewUser) + "";
//            
//        }else{
//            return "-1";
//        }
        
        return  NewUser;
    }

}
