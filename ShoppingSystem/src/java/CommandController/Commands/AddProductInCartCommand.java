/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.UserDTO;
import Gateway.CartRowGateway;

/**
 *
 * @author haydn
 */
public class AddProductInCartCommand implements Command {
    
    private UserDTO User;
    private CartRowGateway CartRG;

    public AddProductInCartCommand(UserDTO userDTO) {
        this.User = userDTO;
        this.CartRG = new CartRowGateway();
    }

    @Override
    public Object execute() {
        return CartRG.AddToCart(this.User.getProduct().getID(), this.User.getID());
    }
    
}
