/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.UserDTO;
import Gateway.UserRowGateway;

/**
 *
 * @author haydn
 */
public class FindUserCommand implements Command {
    
    
    private final UserDTO user;
    private final UserRowGateway UserRG;

    public FindUserCommand(UserDTO user) {
        this.user = user;
        UserRG = new UserRowGateway();
    }

    @Override
    public Object execute() {
        if(user.getID() != -1){
            return (UserDTO) UserRG.FindUserByID(user.getID());
        }else if(user.getUsername() != null){
            
            return UserRG.FindUserByUsername(user.getUsername());
        }
        
        return null;
        
    }
    
    
    
    
    
}
