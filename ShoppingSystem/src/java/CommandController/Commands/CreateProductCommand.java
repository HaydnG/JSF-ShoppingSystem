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
public class CreateProductCommand implements Command {
    
    private ProductDTO Product;
    private ProductRowGateway ProductRG;

    public CreateProductCommand(ProductDTO productDTO) {
        this.Product = productDTO;
        this.ProductRG = new ProductRowGateway();
    }

    @Override
    public Object execute() {
        return this.ProductRG.CreateProduct(this.Product);
    }
    
}
