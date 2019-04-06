/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import CommandController.CommandFactory;
import DTO.AddressDTO;
import DTO.PasswordDTO;
import DTO.UserDTO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author haydn
 */
@Named(value = "register")
@SessionScoped
public class RegistrationBean implements Serializable{
    
    private String username;

    private String fname;
    private String lname;
    private AddressDTO address;
    private PasswordDTO password;
    private int userID;
    
    public RegistrationBean(){
        this.address = new AddressDTO();
        this.password = new PasswordDTO();
    }
    
    public String Register(){
        
        UserDTO tempUser = new UserDTO();
        tempUser.setUsername(this.username);
        
        if((Boolean)CommandFactory.CreateCommand(CommandFactory.USER_EXISTS, tempUser).execute()){
            FacesContext.getCurrentInstance().addMessage("loginForm:username", new FacesMessage("Username already taken"));
            return "RegisterP";
        }
        
        if(!this.password.getPassword2().equals(this.password.getPassword())){
            FacesContext.getCurrentInstance().addMessage("loginForm:password", new FacesMessage("Passwords dont match"));
            return "RegisterP";
        }
        

        this.password = (PasswordDTO) CommandFactory.CreateCommand(CommandFactory.HASH_PASSWORD, this.password).execute();
        this.address.setID((int) CommandFactory.CreateCommand(CommandFactory.ADD_ADDRESS, this.address).execute());
        
        
        
        tempUser.setPassword(this.password);
        tempUser.setFName(this.fname);
        tempUser.setLName(this.lname);
        tempUser.setAddress(this.address);
        
        
        
        
        
        this.userID = (int) CommandFactory.CreateCommand(CommandFactory.ADD_USER,tempUser).execute();
        
        if(this.userID != -1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registration successful, please login"));
            return "LoginP";
        }else{
            FacesContext.getCurrentInstance().addMessage("LoginForm", new FacesMessage("Registration failed, please try again"));
            return "RegisterP";
        }
        

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    //AddressDTO
    public AddressDTO getAddress() {
        return address;
    }
    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    
   

    public String getEmail() {
        return this.address.getEmail();
    }

    public void setEmail(String Email) {
        this.address.setEmail(Email);
    }

    public String getAddrline1() {
        return this.address.getAddrline1();
    }

    public void setAddrline1(String Addrline1) {
        this.address.setAddrline1(Addrline1);
    }

    public String getAddrline2() {
        return this.address.getAddrline2();
    }

    public void setAddrline2(String Addrline2) {
        this.address.setAddrline2(Addrline2);
    }

    public String getCity() {
        return this.address.getCity();
    }

    public void setCity(String city) {
        this.address.setCity(city);
    }

    public String getCounty() {
        return this.address.getCounty();
    }

    public void setCounty(String County) {
        this.address.setCounty(County);
    }

    public String getZipCode() {
        return this.address.getZipCode();
    }

    public void setZipCode(String ZipCode) {
        this.address.setZipCode(ZipCode);
    }
    
    //PasswordDTO
    public PasswordDTO getPassword() {
        return password;
    }  
    public void setPassword(PasswordDTO password) {
        this.password = password;
    }
    public String getPassword1(String password) {
        return this.password.getPassword();
    }
    public String getPassword2(String password) {
        return this.password.getPassword2();
    }
    
    public void setPassword1(String password) {
        this.password.setPassword(password);
    }
    public void setPassword2(String password) {
        this.password.setPassword2(password);
    }

    

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    
}
