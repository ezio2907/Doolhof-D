/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import javax.swing.JLabel;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class HelperTest {
    
    public HelperTest() {
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
     * Test of teken method, of class Helper.
     */
    @Test
    public void testTeken() {
        System.out.println("teken");
        Helper instance = new Helper();
        String expResult = "";
        String result = instance.teken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pickUp method, of class Helper.
     */
    @Test
    public void testPickUp() {
        System.out.println("pickUp");
        ArrayList<JLabel> labels = null;
        Helper instance = new Helper();
        instance.pickUp(labels);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
