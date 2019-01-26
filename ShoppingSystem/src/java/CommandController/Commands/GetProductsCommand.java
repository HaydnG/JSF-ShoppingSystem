/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.ProductDTO;
import Gateway.ProductRowGateway;
import Gateway.StoreRowGateway;

/**
 *
 * @author haydn
 */
public class GetProductsCommand implements Command {
    
    private ProductDTO Product;
    private ProductRowGateway ProductRG;

    public GetProductsCommand(ProductDTO product) {
        this.Product = product;
        this.ProductRG = new ProductRowGateway();
        
        
    }

    @Override
    public Object execute() {
        if(Product.getStore().getID() == 0){
            return ProductRG.GetProducts(Product.getPSearch(), Product.isShowDisabled(), Product.isShowBoth());
        }else{
            return ProductRG.GetProductsByStore(Product.getPSearch(),Product.getStore().getID(), Product.isShowDisabled(), Product.isShowBoth());
        }
        
        
        
    }
    
}
