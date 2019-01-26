/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.AddressDTO;
import Gateway.AddressRowGateway;

/**
 *
 * @author haydn
 */
public class AddAddressCommand implements Command {

    private AddressDTO addressDTO;
    private AddressRowGateway AddressRG;
    
    public AddAddressCommand(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
        AddressRG = new AddressRowGateway();
        
    }

    @Override
    public Object execute() {
        return AddressRG.AddAddress(this.addressDTO);
    }
    
}
