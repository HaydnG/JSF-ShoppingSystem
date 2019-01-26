/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.AddressDTO;
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
public class AddressRowGatewayTest {
    
    public AddressRowGatewayTest() {
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
     * Test of AddAddress method, of class AddressRowGateway.
     */
    @Test
    public void testAddAddress() {
        System.out.println("AddAddress");
        AddressDTO address = null;
        AddressRowGateway instance = new AddressRowGateway();
        int expResult = 0;
        int result = instance.AddAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoveAddress method, of class AddressRowGateway.
     */
    @Test
    public void testRemoveAddress() {
        System.out.println("RemoveAddress");
        int addressid = 0;
        AddressRowGateway instance = new AddressRowGateway();
        Boolean expResult = null;
        Boolean result = instance.RemoveAddress(addressid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
