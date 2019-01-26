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
public class AddUserCommand implements Command {

    private UserDTO user;
    private final UserRowGateway UserRG;

    public AddUserCommand(UserDTO user) {
        this.user = user;
        UserRG = new UserRowGateway();
    }

    @Override
    public Object execute() {
        return UserRG.AddUser(user);
    }
    
}
