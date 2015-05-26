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
public class ValsspelerTest {
    
    public ValsspelerTest() {
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
     * Test of teken method, of class Valsspeler.
     */
    @Test
    public void testTeken() {
        System.out.println("teken");
        Valsspeler instance = new Valsspeler();
        String expResult = "";
        String result = instance.teken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
