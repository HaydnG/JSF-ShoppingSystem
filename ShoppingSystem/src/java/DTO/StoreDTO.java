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
public class StoreDTO {
    
    private int ID;
    private String Name;
    private AddressDTO Address;

    public StoreDTO(int ID, String Name, AddressDTO Address) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
    }
    
    public StoreDTO() {
        this.ID = 0;
        this.Name = null;
        this.Address = null;
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

    public AddressDTO getAddress() {
        return Address;
    }

    public void setAddress(AddressDTO Address) {
        this.Address = Address;
    }
    
    
    
}
