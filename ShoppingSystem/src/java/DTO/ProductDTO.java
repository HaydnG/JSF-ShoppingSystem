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
public class ProductDTO {
    
    private int ID;
    private String Name;
    private String LongName;
    private Double Price;
    private String Description;
    private StoreDTO Store;
    private String PSearch;
    private int NumInCart;
    private boolean ShowDisabled = false;
    private boolean Disabled = false;
    private boolean ShowBoth = false;

    public ProductDTO(int ID, String Name, String LongName, Double Price, String Description, StoreDTO Store) {
        this.ID = ID;
        this.Name = Name;
        this.LongName = LongName;
        this.Price = Price;
        this.Description = Description;
        this.Store = Store;
    }
    
    public ProductDTO() {
        this.ID = 0;
        this.Name = null;
        this.LongName = null;
        this.Price = null;
        this.Description = null;
        this.Store = null;
        this.PSearch = null;
    }

    public boolean isShowDisabled() {
        return ShowDisabled;
    }

    public boolean isShowBoth() {
        return ShowBoth;
    }

    public void setShowBoth(boolean ShowBoth) {
        this.ShowBoth = ShowBoth;
    }

    
    
    public void setShowDisabled(boolean ShowDisabled) {
        this.ShowDisabled = ShowDisabled;
    }

    public boolean isDisabled() {
        return Disabled;
    }

    public void setDisabled(boolean Disabled) {
        this.Disabled = Disabled;
    }
    
    
    

    public int getNumInCart() {
        return NumInCart;
    }

    public void setNumInCart(int NumInCart) {
        this.NumInCart = NumInCart;
    }
    
    

    public String getPSearch() {
        return PSearch;
    }

    public void setPSearch(String PSearch) {
        this.PSearch = PSearch;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLongName() {
        return LongName;
    }

    public void setLongName(String LongName) {
        this.LongName = LongName;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public StoreDTO getStore() {
        return Store;
    }

    public void setStore(StoreDTO Store) {
        this.Store = Store;
    }
    
    
    
    
}
