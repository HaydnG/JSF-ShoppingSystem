/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gateway;

import DTO.ProductDTO;
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
public class CartRowGatewayTest {
    
    public CartRowGatewayTest() {
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
     * Test of CountProductInCart method, of class CartRowGateway.
     */
    @Test
    public void testCountProductInCart() {
        System.out.println("CountProductInCart");
        int ProductID = 0;
        int UserID = 0;
        CartRowGateway instance = new CartRowGateway();
        int expResult = 0;
        int result = instance.CountProductInCart(ProductID, UserID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IsProductInCart method, of class CartRowGateway.
     */
    @Test
    public void testIsProductInCart() {
        System.out.println("IsProductInCart");
        int ProductID = 0;
        int UserID = 0;
        CartRowGateway instance = new CartRowGateway();
        boolean expResult = false;
        boolean result = instance.IsProductInCart(ProductID, UserID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddToCart method, of class CartRowGateway.
     */
    @Test
    public void testAddToCart() {
        System.out.println("AddToCart");
        int ProductID = 0;
        int UserID = 0;
        CartRowGateway instance = new CartRowGateway();
        Boolean expResult = null;
        Boolean result = instance.AddToCart(ProductID, UserID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ClearCart method, of class CartRowGateway.
     */
    @Test
    public void testClearCart() {
        System.out.println("ClearCart");
        int UserID = 0;
        CartRowGateway instance = new CartRowGateway();
        int expResult = 0;
        int result = instance.ClearCart(UserID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IncrementItemInCart method, of class CartRowGateway.
     */
    @Test
    public void testIncrementItemInCart() {
        System.out.println("IncrementItemInCart");
        int ProductID = 0;
        int UserID = 0;
        CartRowGateway instance = new CartRowGateway();
        Boolean expResult = null;
        Boolean result = instance.IncrementItemInCart(ProductID, UserID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DecrementItemInCart method, of class CartRowGateway.
     */
    @Test
    public void testDecrementItemInCart() {
        System.out.println("DecrementItemInCart");
        int ProductID = 0;
        int UserID = 0;
        CartRowGateway instance = new CartRowGateway();
        Boolean expResult = null;
        Boolean result = instance.DecrementItemInCart(ProductID, UserID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetShoppingCart method, of class CartRowGateway.
     */
    @Test
    public void testGetShoppingCart() {
        System.out.println("GetShoppingCart");
        int UserID = 0;
        CartRowGateway instance = new CartRowGateway();
        ArrayList<ProductDTO> expResult = null;
        ArrayList<ProductDTO> result = instance.GetShoppingCart(UserID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
