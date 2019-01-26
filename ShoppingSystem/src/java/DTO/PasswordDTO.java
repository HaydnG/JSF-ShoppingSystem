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
public class PasswordDTO {
    
    private String Password;
    private String Password2;
    private String HashedPassword;
    private String Salt;

    public PasswordDTO(String Password, String HashedPassword, String Salt) {
        this.Password = Password;
        this.HashedPassword = HashedPassword;
        this.Salt = Salt;
    }

    public PasswordDTO() {       
        this.Password = null;
        this.HashedPassword = null;
        this.Salt = null;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword2() {
        return Password2;
    }

    public void setPassword2(String Password2) {
        this.Password2 = Password2;
    }
    
    
    public String getHashedPassword() {
        return HashedPassword;
    }

    public void setHashedPassword(String HashedPassword) {
        this.HashedPassword = HashedPassword;
    }

    public String getSalt() {
        return Salt;
    }

    public void setSalt(String Salt) {
        this.Salt = Salt;
    }
    
    
    
    
    
    
}
