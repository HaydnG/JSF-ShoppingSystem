/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author haydn
 */
public class UserDTO {
    
    private PasswordDTO Password;
    private AddressDTO Address;
    private int ID;
    private String FName;
    private String LName;
    private String Username;
    private ProductDTO Product;
    private boolean Admin;
    private String Usearch;
    private boolean ShowAdmins = false;
    
    
    public UserDTO(PasswordDTO password, AddressDTO address, int id, String fname, String lname, String username){
        this.Password = password;
        this.Address = address;
        this.ID = id;
        this.FName = fname;
        this.LName = lname;
        this.Username = username;   
        this.Admin = false;
        this.Usearch = "";
    }
    
    public UserDTO(){
        this.Password = null;
        this.Address = null;
        this.ID = -1;
        this.FName = null;
        this.LName = null;
        this.Username = null;
        this.Admin = false;
        this.Usearch = "";
    }

    public Boolean getAdmin() {
        return Admin;
    }

    public void setAdmin(Boolean Admin) {
        this.Admin = Admin;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean Admin) {
        this.Admin = Admin;
    }

    public boolean isShowAdmins() {
        return ShowAdmins;
    }

    public void setShowAdmins(boolean ShowAdmins) {
        this.ShowAdmins = ShowAdmins;
    }
    
    

    public ProductDTO getProduct() {
        return Product;
    }

    public void setProduct(ProductDTO Product) {
        this.Product = Product;
    }
    
    
    
    public PasswordDTO getPassword() {
        return Password;
    }

    public void setPassword(PasswordDTO Password) {
        this.Password = Password;
    }

    public AddressDTO getAddress() {
        return Address;
    }

    public void setAddress(AddressDTO Address) {
        this.Address = Address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getUsearch() {
        return Usearch;
    }

    public void setUsearch(String Usearch) {
        this.Usearch = Usearch;
    }
    
    
    
}
