/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.UserDTO;
import Gateway.OrderRowGateway;

/**
 *
 * @author haydn
 */
public class GetOrdersCommand implements Command {
    
    private UserDTO User;
    private OrderRowGateway OrderRG;

    public GetOrdersCommand(UserDTO userDTO) {
        this.User = userDTO;
        this.OrderRG = new OrderRowGateway();
    }

    @Override
    public Object execute() {
        return this.OrderRG.GetOrders(User.getID());
    }
    
}
