/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandController.Commands;

import CommandController.Command;
import DTO.PasswordDTO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haydn
 */
public class HashPasswordCommand implements Command {
    
    private PasswordDTO Password;

    public HashPasswordCommand(PasswordDTO passwordDTO) {
        this.Password = passwordDTO; 
    }

    @Override
    public Object execute() {
        if(Password.getSalt() == null){
            Password.setSalt(getSalt());
        }
        
           
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        
            md.update(Password.getSalt().getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(Password.getPassword().getBytes(StandardCharsets.UTF_8));

            Password.setHashedPassword(ByteToString(bytes));
        
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashPasswordCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Password;
        
    }
    
    public String getSalt() {
        final Random r = new SecureRandom();
        byte[] salt = new byte[8];
        r.nextBytes(salt);
        return ByteToString(salt);
    }
    
    private String ByteToString(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
           sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    
    }
    
}
