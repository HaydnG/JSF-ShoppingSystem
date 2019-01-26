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
import Gateway.UserRowGateway;

/**
 *
 * @author haydn
 */
public class SetUserRoleCommand implements Command {
    
    private UserDTO User;
    private UserRowGateway UserRG;

    public SetUserRoleCommand(UserDTO userdto) {
        this.User = userdto;
        this.UserRG = new UserRowGateway();
    }

    @Override
    public Object execute() {
        return this.UserRG.SetUserRole(this.User);
    }
    
}
