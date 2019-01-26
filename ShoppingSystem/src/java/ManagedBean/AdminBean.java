/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import CommandController.CommandFactory;
import DTO.AddressDTO;
import DTO.PasswordDTO;
import DTO.ProductDTO;
import DTO.StoreDTO;
import DTO.UserDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author haydn
 */

@Named(value = "admin")
@SessionScoped
public class AdminBean implements Serializable {
    
    private ProductDTO Product;
    private ArrayList<ProductDTO> Products;
    private ProductDTO CreateProduct;
    
    private ArrayList<UserDTO> Users;
    private UserDTO User;
    private UserDTO CreateUser;
    private UserDTO RemoveUser;
    private UserDTO UserView;
    
    @Inject
    private UserBean userbean;
    @Inject
    private ProductBean productbean;
    @Inject
    private CartBean cartbean;
    
    public AdminBean(){
        this.User = new UserDTO();
        this.User.setUsearch("");
        
        this.CreateUser = new UserDTO();
        this.CreateUser.setAddress(new AddressDTO());
        this.CreateUser.setPassword(new PasswordDTO());
        
        this.CreateProduct = new ProductDTO();
        this.CreateProduct.setStore(new StoreDTO());
     
        this.Product = new ProductDTO();
        this.Product.setShowDisabled(false);
        this.Product.setShowBoth(true);
        this.Product.setStore(new StoreDTO());
        this.Product.setPSearch("");
        SearchProducts();
        
    }

    public String ViewProduct(ProductDTO product){
        
        productbean.setProductView((ProductDTO) CommandFactory.CreateCommand(CommandFactory.GET_PRODUCT, product).execute());
        return "AProdP";
    }
    
    public String ViewUser(UserDTO user){
        
        this.setUserView((UserDTO) CommandFactory.CreateCommand(CommandFactory.FIND_USER, user).execute());
        return "AViewUserP";
    }
    
    public String CreateProduct(){
        ProductDTO tempProd = this.CreateProduct;
        
        int ProductID = (int) CommandFactory.CreateCommand(CommandFactory.ADD_PRODUCT,tempProd).execute();
        tempProd.setID(ProductID);
        
        this.CreateProduct = new ProductDTO();
        this.CreateProduct.setStore(new StoreDTO());
                
        return ViewProduct(tempProd);
    }
    
    
    public void SearchProducts(){
        this.Product.setShowBoth(true);
        Products = (ArrayList<ProductDTO>) CommandFactory.CreateCommand(CommandFactory.GET_PRODUCTS, this.Product).execute();
        

    }
    
   @PostConstruct
    private void init(){
        
        
        SearchUsers();
    
    }

    public ProductDTO getCreateProduct() {
        return CreateProduct;
    }

    public void setCreateProduct(ProductDTO CreateProduct) {
        this.CreateProduct = CreateProduct;
    }
    
    

    public ProductDTO getProduct() {
        return Product;
    }

    public void setProduct(ProductDTO product) {
        this.Product = product;
    }
    

    public ArrayList<ProductDTO> getProducts() {

        return Products;
    }
    
    public void DisableProduct(ProductDTO product, boolean reload){
        product.setDisabled(true);
        CommandFactory.CreateCommand(CommandFactory.SET_PRODUCT_STATE, product).execute();
        cartbean.UpdateShoppingCart();
        if(reload){
            SearchProducts();
        }
    
    }

    public UserDTO getUserView() {
        return UserView;
    }

    public void setUserView(UserDTO UserView) {
        this.UserView = UserView;
    }
    
    
    
    public void EnableProduct(ProductDTO product, boolean reload){
        product.setDisabled(false);
        CommandFactory.CreateCommand(CommandFactory.SET_PRODUCT_STATE, product).execute();
        cartbean.UpdateShoppingCart();
        if(reload){
            SearchProducts();
        }
    
    }
    
    public void RemoveUser(UserDTO user){
        CommandFactory.CreateCommand(CommandFactory.REMOVE_USER, user).execute();
        CommandFactory.CreateCommand(CommandFactory.CLEAR_CART, user).execute();
        SearchUsers();
    
    }
    
    public String RemoveUserFromView(UserDTO user){
        CommandFactory.CreateCommand(CommandFactory.REMOVE_USER, user).execute();
        CommandFactory.CreateCommand(CommandFactory.CLEAR_CART, user).execute();
        SearchUsers();
        return "AUserP";
    }
    
    
    public void DemoteUser(UserDTO user, boolean reload){
        if(userbean.getUser().getID() != user.getID()){
        
            user.setAdmin(false);
            CommandFactory.CreateCommand(CommandFactory.SET_USER_ROLE, user).execute();
            if(reload){
                SearchUsers();
            }
            
        }
        
        
    
    }
     public void PromoteUser(UserDTO user, boolean reload){
        if(userbean.getUser().getID() != user.getID()){
        
            user.setAdmin(true);
            CommandFactory.CreateCommand(CommandFactory.SET_USER_ROLE, user).execute();
            if(reload){
                SearchUsers();
            }
        }
    
    }

    public String CreateUser(){
        
        
        
        if((Boolean)CommandFactory.CreateCommand(CommandFactory.USER_EXISTS, this.CreateUser).execute()){
            FacesContext.getCurrentInstance().addMessage("createuser:username", new FacesMessage("Username already taken"));
            return "ACreateUserP";
        }
        
        if(!this.CreateUser.getPassword().getPassword2().equals(this.CreateUser.getPassword().getPassword())){
            FacesContext.getCurrentInstance().addMessage("createuser:password", new FacesMessage("Passwords dont match"));
            return "ACreateUserP";
        }
        

        this.CreateUser.setPassword((PasswordDTO) CommandFactory.CreateCommand(CommandFactory.HASH_PASSWORD, this.CreateUser.getPassword()).execute());
        this.CreateUser.getAddress().setID((int) CommandFactory.CreateCommand(CommandFactory.ADD_ADDRESS, this.CreateUser.getAddress()).execute());
        
        
        
        
        
        
        
        this.CreateUser.setID((int) CommandFactory.CreateCommand(CommandFactory.ADD_USER,this.CreateUser).execute());
        
        if(this.CreateUser.getID() != -1){
            SearchUsers();
            return ViewUser(this.CreateUser);
        }else{
            FacesContext.getCurrentInstance().addMessage("createuser", new FacesMessage("User creation failed, please try again"));
            return "ACreateUserP";
        }
        

    }
    
   
    
    public void SearchUsers(){
        this.User.setID(userbean.getUser().getID());
        this.Users = (ArrayList<UserDTO>) CommandFactory.CreateCommand(CommandFactory.GET_USERS, this.User).execute();
        System.out.println("test");


    }
    
    public void setProducts(ArrayList<ProductDTO> products) {

        this.Products = products;
    }

    public UserDTO getUser() {
        return User;
    }

    public void setUser(UserDTO User) {
        this.User = User;
    }

    public UserDTO getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(UserDTO CreateUser) {
        this.CreateUser = CreateUser;
    }

    public ArrayList<UserDTO> getUsers() {
        return Users;
    }

    public void setUsers(ArrayList<UserDTO> Users) {
        this.Users = Users;
    }
    
    
    

    
    
    
}
