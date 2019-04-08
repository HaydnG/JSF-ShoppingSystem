/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import CommandController.CommandFactory;
import DTO.ProductDTO;
import DTO.StoreDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author haydn
 */
@Named(value = "product")
@SessionScoped
public class ProductBean implements Serializable {
    
    private ProductDTO Product;
    private ProductDTO ProductView;
    private ArrayList<ProductDTO> Products;
    
    private int page = 1;

    
    @Inject
    private UserBean userbean;
    @Inject
    private CartBean cartbean;

    public ProductBean() {
        this.Product = new ProductDTO();
        this.Product.setStore(new StoreDTO());
        this.Product.setPSearch("");
  
       
    }
    
    @PostConstruct
    private void init(){
        
        
        SearchProducts();
    
    }
    
    public String ViewProduct(ProductDTO product, int page){
        this.page = page;
        ProductView = (ProductDTO) CommandFactory.CreateCommand(CommandFactory.GET_PRODUCT, product).execute();
        return "ProductP";
    }

    

    public void SearchProducts(){
        
        this.Products = (ArrayList<ProductDTO>) CommandFactory.CreateCommand(CommandFactory.GET_PRODUCTS, Product,false, false).execute();
        System.out.println("test");
        cartbean.UpdateShoppingCart();
        

    }
    

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    
    
    
    public String getbackpage(){
         switch (page)
        {
            case 0:
                return "CartP";    
            case 1:
                return "HomeP";   
            case 2:
                return "OrderConP"; 
            case 3:
                return "OrderP"; 
            case 4:
                return "AProdP"; 
            default:
                return null;
        }
    }
            

    
    public ArrayList<StoreDTO> getStores(){
        return (ArrayList<StoreDTO>) CommandFactory.CreateCommand(CommandFactory.GET_STORES).execute();
    }

    public ProductDTO getProductView() {
        return ProductView;
    }

    public void setProductView(ProductDTO ProductView) {
        this.ProductView = ProductView;
    }

    
    
    
    public ProductDTO getProduct() {
        return Product;
    }

    public void setProduct(ProductDTO Product) {
        this.Product = Product;
    }

    public ArrayList<ProductDTO> getProducts() {

        return Products;
    }
    
    public void setProducts(ArrayList<ProductDTO> products) {

        this.Products = products;
    }
    
    
    
    
}
