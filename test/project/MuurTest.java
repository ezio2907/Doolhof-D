/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class MuurTest {
    
    public MuurTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of teken method, of class Muur.
     */
    @Test
    public void testTeken() {
        System.out.println("teken");
        Muur instance = new Muur();
        String expResult = "";
        String result = instance.teken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
