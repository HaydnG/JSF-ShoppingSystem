/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.OrderDTO;
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
public class OrderRowGatewayTest {
    
    public OrderRowGatewayTest() {
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
     * Test of FindOrder method, of class OrderRowGateway.
     */
    @Test
    public void testFindOrder() {
        System.out.println("FindOrder");
        OrderDTO Order = null;
        OrderRowGateway instance = new OrderRowGateway();
        OrderDTO expResult = null;
        OrderDTO result = instance.FindOrder(Order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetOrders method, of class OrderRowGateway.
     */
    @Test
    public void testGetOrders() {
        System.out.println("GetOrders");
        int UserID = 0;
        OrderRowGateway instance = new OrderRowGateway();
        ArrayList<OrderDTO> expResult = null;
        ArrayList<OrderDTO> result = instance.GetOrders(UserID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PlaceOrder method, of class OrderRowGateway.
     */
    @Test
    public void testPlaceOrder() {
        System.out.println("PlaceOrder");
        OrderDTO order = null;
        OrderRowGateway instance = new OrderRowGateway();
        int expResult = 0;
        int result = instance.PlaceOrder(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddOrderProducts method, of class OrderRowGateway.
     */
    @Test
    public void testAddOrderProducts() {
        System.out.println("AddOrderProducts");
        OrderDTO order = null;
        OrderRowGateway instance = new OrderRowGateway();
        int expResult = 0;
        int result = instance.AddOrderProducts(order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoveOrderProducts method, of class OrderRowGateway.
     */
    @Test
    public void testRemoveOrderProducts() {
        System.out.println("RemoveOrderProducts");
        int userID = 0;
        OrderRowGateway instance = new OrderRowGateway();
        int expResult = 0;
        int result = instance.RemoveOrderProducts(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoveOrder method, of class OrderRowGateway.
     */
    @Test
    public void testRemoveOrder() {
        System.out.println("RemoveOrder");
        int userID = 0;
        OrderRowGateway instance = new OrderRowGateway();
        int expResult = 0;
        int result = instance.RemoveOrder(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
