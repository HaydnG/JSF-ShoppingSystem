/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.AddressDTO;
import DTO.PasswordDTO;
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
public class RegistrationBeanTest {
    
    public RegistrationBeanTest() {
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
     * Test of Register method, of class RegistrationBean.
     */
    @Test
    public void testRegister() {
        System.out.println("Register");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.Register();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class RegistrationBean.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class RegistrationBean.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class RegistrationBean.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        RegistrationBean instance = new RegistrationBean();
        AddressDTO expResult = null;
        AddressDTO result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class RegistrationBean.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        AddressDTO address = null;
        RegistrationBean instance = new RegistrationBean();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class RegistrationBean.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class RegistrationBean.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String Email = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setEmail(Email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddrline1 method, of class RegistrationBean.
     */
    @Test
    public void testGetAddrline1() {
        System.out.println("getAddrline1");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getAddrline1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddrline1 method, of class RegistrationBean.
     */
    @Test
    public void testSetAddrline1() {
        System.out.println("setAddrline1");
        String Addrline1 = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setAddrline1(Addrline1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddrline2 method, of class RegistrationBean.
     */
    @Test
    public void testGetAddrline2() {
        System.out.println("getAddrline2");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getAddrline2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddrline2 method, of class RegistrationBean.
     */
    @Test
    public void testSetAddrline2() {
        System.out.println("setAddrline2");
        String Addrline2 = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setAddrline2(Addrline2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCity method, of class RegistrationBean.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getCity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCity method, of class RegistrationBean.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setCity(city);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCounty method, of class RegistrationBean.
     */
    @Test
    public void testGetCounty() {
        System.out.println("getCounty");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getCounty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCounty method, of class RegistrationBean.
     */
    @Test
    public void testSetCounty() {
        System.out.println("setCounty");
        String County = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setCounty(County);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZipCode method, of class RegistrationBean.
     */
    @Test
    public void testGetZipCode() {
        System.out.println("getZipCode");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getZipCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZipCode method, of class RegistrationBean.
     */
    @Test
    public void testSetZipCode() {
        System.out.println("setZipCode");
        String ZipCode = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setZipCode(ZipCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class RegistrationBean.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        RegistrationBean instance = new RegistrationBean();
        PasswordDTO expResult = null;
        PasswordDTO result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class RegistrationBean.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        PasswordDTO password = null;
        RegistrationBean instance = new RegistrationBean();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword1 method, of class RegistrationBean.
     */
    @Test
    public void testGetPassword1() {
        System.out.println("getPassword1");
        String password = "";
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getPassword1(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword2 method, of class RegistrationBean.
     */
    @Test
    public void testGetPassword2() {
        System.out.println("getPassword2");
        String password = "";
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getPassword2(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword1 method, of class RegistrationBean.
     */
    @Test
    public void testSetPassword1() {
        System.out.println("setPassword1");
        String password = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setPassword1(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword2 method, of class RegistrationBean.
     */
    @Test
    public void testSetPassword2() {
        System.out.println("setPassword2");
        String password = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setPassword2(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFname method, of class RegistrationBean.
     */
    @Test
    public void testGetFname() {
        System.out.println("getFname");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getFname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFname method, of class RegistrationBean.
     */
    @Test
    public void testSetFname() {
        System.out.println("setFname");
        String fname = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setFname(fname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLname method, of class RegistrationBean.
     */
    @Test
    public void testGetLname() {
        System.out.println("getLname");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.getLname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLname method, of class RegistrationBean.
     */
    @Test
    public void testSetLname() {
        System.out.println("setLname");
        String lname = "";
        RegistrationBean instance = new RegistrationBean();
        instance.setLname(lname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
