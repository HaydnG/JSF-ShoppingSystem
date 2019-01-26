/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.OrderDTO;
import Gateway.OrderRowGateway;

/**
 *
 * @author haydn
 */
public class FindOrderCommand implements Command {
    
    private OrderDTO Order;
    private OrderRowGateway OrderRG;

    public FindOrderCommand(OrderDTO orderDTO) {
        this.Order = orderDTO;
        this.OrderRG = new OrderRowGateway();
    }

    @Override
    public Object execute() {
        return this.OrderRG.FindOrder(Order);
    }
    
}
