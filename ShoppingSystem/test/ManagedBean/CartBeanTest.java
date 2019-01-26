/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

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
public class CartBeanTest {
    
    public CartBeanTest() {
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
     * Test of UpdateShoppingCart method, of class CartBean.
     */
    @Test
    public void testUpdateShoppingCart() {
        System.out.println("UpdateShoppingCart");
        CartBean instance = new CartBean();
        instance.UpdateShoppingCart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShoppingCart method, of class CartBean.
     */
    @Test
    public void testGetShoppingCart() {
        System.out.println("getShoppingCart");
        CartBean instance = new CartBean();
        ArrayList<ProductDTO> expResult = null;
        ArrayList<ProductDTO> result = instance.getShoppingCart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onload method, of class CartBean.
     */
    @Test
    public void testOnload() {
        System.out.println("onload");
        CartBean instance = new CartBean();
        instance.onload();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ProductInCart method, of class CartBean.
     */
    @Test
    public void testProductInCart() {
        System.out.println("ProductInCart");
        ProductDTO product = null;
        CartBean instance = new CartBean();
        Boolean expResult = null;
        Boolean result = instance.ProductInCart(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetCartQuantity method, of class CartBean.
     */
    @Test
    public void testGetCartQuantity() {
        System.out.println("GetCartQuantity");
        int ProductID = 0;
        CartBean instance = new CartBean();
        int expResult = 0;
        int result = instance.GetCartQuantity(ProductID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ClearCart method, of class CartBean.
     */
    @Test
    public void testClearCart() {
        System.out.println("ClearCart");
        CartBean instance = new CartBean();
        instance.ClearCart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TakeFromCart method, of class CartBean.
     */
    @Test
    public void testTakeFromCart() {
        System.out.println("TakeFromCart");
        ProductDTO product = null;
        CartBean instance = new CartBean();
        instance.TakeFromCart(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddToCart method, of class CartBean.
     */
    @Test
    public void testAddToCart() {
        System.out.println("AddToCart");
        ProductDTO product = null;
        CartBean instance = new CartBean();
        instance.AddToCart(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalCostOfCart method, of class CartBean.
     */
    @Test
    public void testGetTotalCostOfCart() {
        System.out.println("getTotalCostOfCart");
        CartBean instance = new CartBean();
        double expResult = 0.0;
        double result = instance.getTotalCostOfCart();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalProdInCart method, of class CartBean.
     */
    @Test
    public void testGetTotalProdInCart() {
        System.out.println("getTotalProdInCart");
        CartBean instance = new CartBean();
        int expResult = 0;
        int result = instance.getTotalProdInCart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
