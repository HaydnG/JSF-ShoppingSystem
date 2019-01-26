/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import CommandController.CommandFactory;
import DTO.*;
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
public class GroceryJUnitTest {
    
    public GroceryJUnitTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test_UT1() {
        ProductDTO product = new ProductDTO();
        product.setID(5);
        
        UserDTO user = new UserDTO();
        user.setID(5);
        user.setProduct(product);
        
        assertNotNull("Product should exist, but product is null", product);
        assertNotNull("User should exist, but user is null", user);
        assertNotNull("Product should exist in user, but product is null", user.getProduct());
        
        assertEquals("ProductID should be 5 -",5, product.getID());
        assertEquals("ProductID should be 5 -",5, user.getProduct().getID());
        assertEquals("UserID should be 5 -",5, user.getID());
        
        CommandFactory.CreateCommand(CommandFactory.CLEAR_CART, user).execute();
        
        boolean incart = (boolean) CommandFactory.CreateCommand(CommandFactory.IS_PRODUCT_IN_CART, user).execute();
        assertFalse("Product 5 should not be in user 5 cart", incart);
        
        boolean addedtocart =  (boolean) CommandFactory.CreateCommand(CommandFactory.ADD_PRODUCT_IN_CART, user).execute();
        assertTrue("Product should've been added to cart, but 0 rows added",addedtocart);
        
        
        
        
    }
}
