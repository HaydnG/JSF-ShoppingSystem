/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import CommandController.CommandFactory;
import DTO.PasswordDTO;
import DTO.UserDTO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author haydn
 */

@Named(value = "user")
@SessionScoped
public class UserBean implements Serializable {
    
    private boolean LoggedIn = false;
    private boolean Admin = false;
    private String username;
    private String password;
    private UserDTO User;
    

    
    
    public boolean LoggedIn(){
        return LoggedIn;
    }
   
    public String Login(){
        UserDTO tempUser = new UserDTO();
        tempUser.setUsername(this.username);
        
        PasswordDTO tempPassword = new PasswordDTO();
        
        
        this.User = (UserDTO) CommandFactory.CreateCommand(CommandFactory.FIND_USER,tempUser).execute();
        
        tempPassword.setPassword(this.password);
        tempPassword.setSalt(this.User.getPassword().getSalt());
        
        tempPassword = (PasswordDTO) CommandFactory.CreateCommand(CommandFactory.HASH_PASSWORD, tempPassword).execute();
        this.setAdmin(this.User.getAdmin());
        
        if(this.User.getPassword().getHashedPassword().equals(tempPassword.getHashedPassword())){
            this.setLoggedIn(true);
            return "HomeP";
            
        }else{
            this.setLoggedIn(false);
            FacesContext.getCurrentInstance().addMessage("LoginForm", new FacesMessage("Login credentials are not correct"));
            
            return "LoginP";
        }
        
    }
    
    public Boolean getAdmin(){
        return User.getAdmin();
    }
    
    public String logout(){
        this.LoggedIn = false;
        this.User = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "LoginP";
    }

    public boolean isLoggedIn() {
        return LoggedIn;
    }

    public boolean IsAdmin() {
        return Admin;
    }

    public void setAdmin(boolean IsAdmin) {
        this.Admin = IsAdmin;
    }
    
    

    public void setLoggedIn(boolean LoggedIn) {
        this.LoggedIn = LoggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO getUser() {
        return User;
    }

    public void setUser(UserDTO User) {
        this.User = User;
    }

    
}
