/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.UserDTO;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author haydn
 */
public class UserRowGatewayTest {
    
    public UserRowGatewayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of FindUserByID method, of class UserRowGateway.
     */
    @Test
    public void testFindUserByID() {
        System.out.println("FindUserByID");
        int UserID = 0;
        UserRowGateway instance = new UserRowGateway();
        UserDTO expResult = null;
        UserDTO result = instance.FindUserByID(UserID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FindUserByUsername method, of class UserRowGateway.
     */
    @Test
    public void testFindUserByUsername() {
        System.out.println("FindUserByUsername");
        String username = "";
        UserRowGateway instance = new UserRowGateway();
        UserDTO expResult = null;
        UserDTO result = instance.FindUserByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoveUser method, of class UserRowGateway.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("RemoveUser");
        UserDTO user = null;
        UserRowGateway instance = new UserRowGateway();
        Boolean expResult = null;
        Boolean result = instance.RemoveUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetUserRole method, of class UserRowGateway.
     */
    @Test
    public void testSetUserRole() {
        System.out.println("SetUserRole");
        UserDTO user = null;
        UserRowGateway instance = new UserRowGateway();
        Boolean expResult = null;
        Boolean result = instance.SetUserRole(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetUsers method, of class UserRowGateway.
     */
    @Test
    public void testGetUsers() {
        System.out.println("GetUsers");
        UserDTO User = null;
        UserRowGateway instance = new UserRowGateway();
        ArrayList<UserDTO> expResult = null;
        ArrayList<UserDTO> result = instance.GetUsers(User);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddUser method, of class UserRowGateway.
     */
    @Test
    public void testAddUser() {
        System.out.println("AddUser");
        UserDTO user = null;
        UserRowGateway instance = new UserRowGateway();
        int expResult = 0;
        int result = instance.AddUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UserExists method, of class UserRowGateway.
     */
    @Test
    public void testUserExists() {
        System.out.println("UserExists");
        UserDTO user = null;
        UserRowGateway instance = new UserRowGateway();
        Boolean expResult = null;
        Boolean result = instance.UserExists(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
