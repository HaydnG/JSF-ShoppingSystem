/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.StoreDTO;
import Gateway.StoreRowGateway;

/**
 *
 * @author haydn
 */
public class GetStoresCommand implements Command {
    
    private StoreRowGateway StoreRG;

    public GetStoresCommand() {
        this.StoreRG = new StoreRowGateway();
        
        
    }

    @Override
    public Object execute() {
        
        return StoreRG.GetStores();
    }
    
}
