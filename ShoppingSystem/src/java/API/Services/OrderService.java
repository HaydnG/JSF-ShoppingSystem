/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.Services;

import CommandController.CommandFactory;
import DTO.DTOConverter;
import DTO.OrderDTO;
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

@Path("/Order")
public class OrderService {
    
    
    @POST
    @Path("Place")
    @Consumes("application/json")
    @Produces("application/json")
    public String AddUser(String OrderText , @HeaderParam("authorization") String AuthID){
        
        
        UserRowGateway URG = new UserRowGateway();
        ServiceAuthentication Auth = new ServiceAuthentication();   
        
        

        if(AuthID == null){
            throw new NotAuthorizedException("Access denied");
        }
        
        UserDTO User = Auth.AuthenticateUser(AuthID);
        if(User == null || !User.isLoggedIn()){
            throw new NotAuthorizedException("Access denied");
        }else{
            DTOConverter con = new DTOConverter();
            OrderDTO Order =  con.JsonArrayToOrderDTO(OrderText);
            CommandFactory.CreateCommand(CommandFactory.CLEAR_CART,User).execute();
            
            return (int)CommandFactory.CreateCommand(CommandFactory.PLACE_ORDER,Order).execute() + "";
            
         
        }    
    }
}
