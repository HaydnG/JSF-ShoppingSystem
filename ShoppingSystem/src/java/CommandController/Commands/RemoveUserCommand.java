/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.UserDTO;
import Gateway.AddressRowGateway;
import Gateway.OrderRowGateway;
import Gateway.UserRowGateway;

/**
 *
 * @author haydn
 */
public class RemoveUserCommand implements Command {
    
    private UserDTO User;
    private UserRowGateway UserRG;
    private AddressRowGateway AddressRG;
    private OrderRowGateway OrderRG;

    public RemoveUserCommand(UserDTO userDTO) {
        this.User = userDTO;
        this.UserRG = new UserRowGateway();
        this.AddressRG = new AddressRowGateway();
        this.OrderRG = new OrderRowGateway();
        
        
    }

    @Override
    public Object execute() {
        this.OrderRG.RemoveOrderProducts(User.getID());
        this.OrderRG.RemoveOrder(User.getID());
        
        this.AddressRG.RemoveAddress(User.getAddress().getID());
        
        return this.UserRG.RemoveUser(this.User);
    }
    
}
