/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

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
public class OrderBeanTest {
    
    public OrderBeanTest() {
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
     * Test of Order method, of class OrderBean.
     */
    @Test
    public void testOrder() {
        System.out.println("Order");
        OrderBean instance = new OrderBean();
        String expResult = "";
        String result = instance.Order();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalProducts method, of class OrderBean.
     */
    @Test
    public void testTotalProducts() {
        System.out.println("totalProducts");
        OrderDTO Order = null;
        OrderBean instance = new OrderBean();
        int expResult = 0;
        int result = instance.totalProducts(Order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalPrice method, of class OrderBean.
     */
    @Test
    public void testTotalPrice() {
        System.out.println("totalPrice");
        OrderDTO Order = null;
        OrderBean instance = new OrderBean();
        double expResult = 0.0;
        double result = instance.totalPrice(Order);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ViewOrder method, of class OrderBean.
     */
    @Test
    public void testViewOrder() {
        System.out.println("ViewOrder");
        OrderDTO Order = null;
        OrderBean instance = new OrderBean();
        String expResult = "";
        String result = instance.ViewOrder(Order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrders method, of class OrderBean.
     */
    @Test
    public void testGetOrders() {
        System.out.println("getOrders");
        OrderBean instance = new OrderBean();
        ArrayList<OrderDTO> expResult = null;
        ArrayList<OrderDTO> result = instance.getOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderView method, of class OrderBean.
     */
    @Test
    public void testGetOrderView() {
        System.out.println("getOrderView");
        OrderBean instance = new OrderBean();
        OrderDTO expResult = null;
        OrderDTO result = instance.getOrderView();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderView method, of class OrderBean.
     */
    @Test
    public void testSetOrderView() {
        System.out.println("setOrderView");
        OrderDTO OrderView = null;
        OrderBean instance = new OrderBean();
        instance.setOrderView(OrderView);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
