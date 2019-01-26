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
public class ProductRowGatewayTest {
    
    public ProductRowGatewayTest() {
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
     * Test of GetProducts method, of class ProductRowGateway.
     */
    @Test
    public void testGetProducts() {
        System.out.println("GetProducts");
        String PSearch = "";
        boolean ShowDisabled = false;
        boolean ShowBoth = false;
        ProductRowGateway instance = new ProductRowGateway();
        ArrayList<ProductDTO> expResult = null;
        ArrayList<ProductDTO> result = instance.GetProducts(PSearch, ShowDisabled, ShowBoth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateProduct method, of class ProductRowGateway.
     */
    @Test
    public void testCreateProduct() {
        System.out.println("CreateProduct");
        ProductDTO product = null;
        ProductRowGateway instance = new ProductRowGateway();
        int expResult = 0;
        int result = instance.CreateProduct(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetProductsByStore method, of class ProductRowGateway.
     */
    @Test
    public void testGetProductsByStore() {
        System.out.println("GetProductsByStore");
        String PSearch = "";
        int StoreID = 0;
        boolean ShowDisabled = false;
        boolean ShowBoth = false;
        ProductRowGateway instance = new ProductRowGateway();
        ArrayList<ProductDTO> expResult = null;
        ArrayList<ProductDTO> result = instance.GetProductsByStore(PSearch, StoreID, ShowDisabled, ShowBoth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetProductState method, of class ProductRowGateway.
     */
    @Test
    public void testSetProductState() {
        System.out.println("SetProductState");
        ProductDTO product = null;
        ProductRowGateway instance = new ProductRowGateway();
        Boolean expResult = null;
        Boolean result = instance.SetProductState(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FindProductByID method, of class ProductRowGateway.
     */
    @Test
    public void testFindProductByID() {
        System.out.println("FindProductByID");
        int ProductID = 0;
        ProductRowGateway instance = new ProductRowGateway();
        ProductDTO expResult = null;
        ProductDTO result = instance.FindProductByID(ProductID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
