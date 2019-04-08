/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.Services;

import CommandController.CommandFactory;
import DTO.PasswordDTO;
import DTO.UserDTO;
import java.io.IOException;
import sun.misc.BASE64Decoder;

/**
 *
 * @author haydn
 */
public class ServiceAuthentication {
    
    public UserDTO AuthenticateUser(String EncodedString){
        String DecodedString = DecodeBase64(EncodedString);
        String Username = "",PasswordString = "";
        UserDTO User = null;

        
        try{
            Username = DecodedString.split(":")[0];
            PasswordString = DecodedString.split(":")[1];
            
            User = new UserDTO();
            User.setUsername(Username);   

            User = (UserDTO) CommandFactory.CreateCommand(CommandFactory.FIND_USER,User).execute();

            PasswordDTO Password = new PasswordDTO();
            Password.setPassword(PasswordString);
            Password.setSalt(User.getPassword().getSalt());

            Password = (PasswordDTO) CommandFactory.CreateCommand(CommandFactory.HASH_PASSWORD, Password).execute();

            if(User.getPassword().getHashedPassword().equals(Password.getHashedPassword())){
                User.setLoggedIn(true);

            }else{
                User.setLoggedIn(false);  
            }   
        }catch(ArrayIndexOutOfBoundsException ex){}
            
            
        return User;
    }
    
    private String DecodeBase64(String authString){
         
        String decodedAuth = "";


        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authString);
        } catch (IOException e) {

            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        return decodedAuth;
         
    }
    
}
