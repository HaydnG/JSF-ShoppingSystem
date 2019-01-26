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
public class AddressDTO {
    
    private int ID;
    private String Email;
    private String Addrline1;
    private String Addrline2;
    private String city;
    private String County;
    private String ZipCode;

    public AddressDTO(int ID, String Email, String Addrline1, String Addrline2, String city, String County, String ZipCode) {
        this.ID = ID;
        this.Email = Email;
        this.Addrline1 = Addrline1;
        this.Addrline2 = Addrline2;
        this.city = city;
        this.County = County;
        this.ZipCode = ZipCode;
    }

    
    public AddressDTO() {
        this.ID = -1;
        this.Email = "";
        this.Addrline1 = "";
        this.Addrline2 = "";
        this.city = "";
        this.County = "";
        this.ZipCode = "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddrline1() {
        return Addrline1;
    }

    public void setAddrline1(String Addrline1) {
        this.Addrline1 = Addrline1;
    }

    public String getAddrline2() {
        return Addrline2;
    }

    public void setAddrline2(String Addrline2) {
        this.Addrline2 = Addrline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String County) {
        this.County = County;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }
    
    
    
    
    
    
}
