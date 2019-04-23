/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.Services;

import CommandController.Command;
import CommandController.CommandFactory;
import DTO.DTOConverter;
import DTO.PasswordDTO;
import DTO.ProductDTO;
import DTO.StoreDTO;
import DTO.UserDTO;
import Gateway.ProductRowGateway;
import Gateway.UserRowGateway;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.json.Json;
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
import org.json.JSONObject;



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
        
        
        
        DTOConverter Con = new DTOConverter();
        
        UserDTO User = Con.JsonTOUserDTO(NewUser);
                
        if(!URG.UserExists(User)){
            
            
            
            User.setPassword((PasswordDTO)CommandFactory.CreateCommand(CommandFactory.HASH_PASSWORD, User.getPassword()).execute());
            
            User.getAddress().setID((int)CommandFactory.CreateCommand(CommandFactory.ADD_ADDRESS, User.getAddress()).execute());
   
            
            return (int) CommandFactory.CreateCommand(CommandFactory.ADD_USER,User).execute() + "";
            
        }else{
            return "-1";
        }
        
       
    }

}
