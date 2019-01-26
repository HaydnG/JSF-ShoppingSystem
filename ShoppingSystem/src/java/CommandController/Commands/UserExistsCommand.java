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
public class UserExistsCommand implements Command {

    private UserDTO userDTO;
    private UserRowGateway UserRG;
    
    public UserExistsCommand(UserDTO userDTO) {
        this.userDTO = userDTO;
        this.UserRG = new UserRowGateway();
    }

    @Override
    public Object execute() {
        return UserRG.UserExists(this.userDTO);
    }
    
}
