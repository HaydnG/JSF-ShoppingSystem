/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DTO.ProductDTO;
import DTO.StoreDTO;
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
public class ProductBeanTest {
    
    public ProductBeanTest() {
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
     * Test of ViewProduct method, of class ProductBean.
     */
    @Test
    public void testViewProduct() {
        System.out.println("ViewProduct");
        ProductDTO product = null;
        int page = 0;
        ProductBean instance = new ProductBean();
        String expResult = "";
        String result = instance.ViewProduct(product, page);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SearchProducts method, of class ProductBean.
     */
    @Test
    public void testSearchProducts() {
        System.out.println("SearchProducts");
        ProductBean instance = new ProductBean();
        instance.SearchProducts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPage method, of class ProductBean.
     */
    @Test
    public void testGetPage() {
        System.out.println("getPage");
        ProductBean instance = new ProductBean();
        int expResult = 0;
        int result = instance.getPage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPage method, of class ProductBean.
     */
    @Test
    public void testSetPage() {
        System.out.println("setPage");
        int page = 0;
        ProductBean instance = new ProductBean();
        instance.setPage(page);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getbackpage method, of class ProductBean.
     */
    @Test
    public void testGetbackpage() {
        System.out.println("getbackpage");
        ProductBean instance = new ProductBean();
        String expResult = "";
        String result = instance.getbackpage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStores method, of class ProductBean.
     */
    @Test
    public void testGetStores() {
        System.out.println("getStores");
        ProductBean instance = new ProductBean();
        ArrayList<StoreDTO> expResult = null;
        ArrayList<StoreDTO> result = instance.getStores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductView method, of class ProductBean.
     */
    @Test
    public void testGetProductView() {
        System.out.println("getProductView");
        ProductBean instance = new ProductBean();
        ProductDTO expResult = null;
        ProductDTO result = instance.getProductView();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductView method, of class ProductBean.
     */
    @Test
    public void testSetProductView() {
        System.out.println("setProductView");
        ProductDTO ProductView = null;
        ProductBean instance = new ProductBean();
        instance.setProductView(ProductView);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class ProductBean.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        ProductBean instance = new ProductBean();
        ProductDTO expResult = null;
        ProductDTO result = instance.getProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProduct method, of class ProductBean.
     */
    @Test
    public void testSetProduct() {
        System.out.println("setProduct");
        ProductDTO Product = null;
        ProductBean instance = new ProductBean();
        instance.setProduct(Product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducts method, of class ProductBean.
     */
    @Test
    public void testGetProducts() {
        System.out.println("getProducts");
        ProductBean instance = new ProductBean();
        ArrayList<ProductDTO> expResult = null;
        ArrayList<ProductDTO> result = instance.getProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducts method, of class ProductBean.
     */
    @Test
    public void testSetProducts() {
        System.out.println("setProducts");
        ArrayList<ProductDTO> products = null;
        ProductBean instance = new ProductBean();
        instance.setProducts(products);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
