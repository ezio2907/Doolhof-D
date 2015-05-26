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
public class UitgangTest {
    
    public UitgangTest() {
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
     * Test of teken method, of class Uitgang.
     */
    @Test
    public void testTeken() {
        System.out.println("teken");
        Uitgang instance = new Uitgang();
        String expResult = "";
        String result = instance.teken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pickUp method, of class Uitgang.
     */
    @Test
    public void testPickUp() {
        System.out.println("pickUp");
        Uitgang instance = new Uitgang();
        instance.pickUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
