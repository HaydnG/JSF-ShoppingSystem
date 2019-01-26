/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.UserDTO;
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
public class UserBeanTest {
    
    public UserBeanTest() {
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
     * Test of LoggedIn method, of class UserBean.
     */
    @Test
    public void testLoggedIn() {
        System.out.println("LoggedIn");
        UserBean instance = new UserBean();
        boolean expResult = false;
        boolean result = instance.LoggedIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Login method, of class UserBean.
     */
    @Test
    public void testLogin() {
        System.out.println("Login");
        UserBean instance = new UserBean();
        String expResult = "";
        String result = instance.Login();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdmin method, of class UserBean.
     */
    @Test
    public void testGetAdmin() {
        System.out.println("getAdmin");
        UserBean instance = new UserBean();
        Boolean expResult = null;
        Boolean result = instance.getAdmin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class UserBean.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        UserBean instance = new UserBean();
        String expResult = "";
        String result = instance.logout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLoggedIn method, of class UserBean.
     */
    @Test
    public void testIsLoggedIn() {
        System.out.println("isLoggedIn");
        UserBean instance = new UserBean();
        boolean expResult = false;
        boolean result = instance.isLoggedIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IsAdmin method, of class UserBean.
     */
    @Test
    public void testIsAdmin() {
        System.out.println("IsAdmin");
        UserBean instance = new UserBean();
        boolean expResult = false;
        boolean result = instance.IsAdmin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdmin method, of class UserBean.
     */
    @Test
    public void testSetAdmin() {
        System.out.println("setAdmin");
        boolean IsAdmin = false;
        UserBean instance = new UserBean();
        instance.setAdmin(IsAdmin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoggedIn method, of class UserBean.
     */
    @Test
    public void testSetLoggedIn() {
        System.out.println("setLoggedIn");
        boolean LoggedIn = false;
        UserBean instance = new UserBean();
        instance.setLoggedIn(LoggedIn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class UserBean.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        UserBean instance = new UserBean();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class UserBean.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        UserBean instance = new UserBean();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class UserBean.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserBean instance = new UserBean();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class UserBean.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        UserBean instance = new UserBean();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserBean.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        UserBean instance = new UserBean();
        UserDTO expResult = null;
        UserDTO result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class UserBean.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        UserDTO User = null;
        UserBean instance = new UserBean();
        instance.setUser(User);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
