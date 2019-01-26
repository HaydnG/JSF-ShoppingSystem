/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.UserDTO;
import Gateway.CartRowGateway;
import Gateway.UserRowGateway;

/**
 *
 * @author haydn
 */
public class ClearCartCommand implements Command {
    
    private UserDTO User;
    private CartRowGateway CartRG;

    public ClearCartCommand(UserDTO userDTO) {
        this.User = userDTO;
        this.CartRG = new CartRowGateway();
        
    }

    @Override
    public Object execute() {
        return this.CartRG.ClearCart(User.getID());
    }
    
}
