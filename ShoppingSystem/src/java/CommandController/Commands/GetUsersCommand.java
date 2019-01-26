/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.ProductDTO;
import DTO.UserDTO;
import Gateway.ProductRowGateway;
import Gateway.StoreRowGateway;
import Gateway.UserRowGateway;

/**
 *
 * @author haydn
 */
public class GetUsersCommand implements Command {
    
    private UserDTO User;
    private UserRowGateway UserRG;

    public GetUsersCommand(UserDTO user) {
        this.User = user;
        this.UserRG = new UserRowGateway();
        
        
    }

    @Override
    public Object execute() {
        return UserRG.GetUsers(User);
        
        
        
    }
    
}
