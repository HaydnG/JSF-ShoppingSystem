/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.ProductDTO;
import Gateway.ProductRowGateway;

/**
 *
 * @author haydn
 */
public class GetProductCommand implements Command {

    private ProductDTO Product;
    private ProductRowGateway ProductRG;
    
    public GetProductCommand(ProductDTO productDTO) {
        this.Product = productDTO;
        this.ProductRG = new ProductRowGateway();
    }

    @Override
    public Object execute() {
        return this.ProductRG.FindProductByID(Product.getID());
    }
    
}
