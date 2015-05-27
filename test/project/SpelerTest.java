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
public class SpelerTest {
    
    public SpelerTest() {
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
     * Test of getX method, of class Speler.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Speler instance = new Speler();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Speler.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Speler instance = new Speler();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLabels method, of class Speler.
     */
    @Test
    public void testGetLabels() {
        System.out.println("getLabels");
        Speler instance = new Speler();
        ArrayList expResult = null;
        ArrayList result = instance.getLabels();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDoolhof method, of class Speler.
     */
    @Test
    public void testSetDoolhof() {
        System.out.println("setDoolhof");
        Doolhof Dh = null;
        Speler instance = new Speler();
        instance.setDoolhof(Dh);
    }

    /**
     * Test of setLabels method, of class Speler.
     */
    @Test
    public void testSetLabels() {
        System.out.println("setLabels");
        ArrayList<JLabel> labels = null;
        Speler instance = new Speler();
        instance.setLabels(labels);
    }

    /**
     * Test of setP method, of class Speler.
     */
    @Test
    public void testSetP() {
        System.out.println("setP");
        int X = 0;
        int Y = 0;
        Speler instance = new Speler();
        instance.setP(X, Y);
    }

    /**
     * Test of setP method, of class Speler.
     */
    @Test
    public void testSetPmin() {
        System.out.println("setPmin");
        int X = -1;
        int Y = -1;
        Speler instance = new Speler();
        instance.setP(X, Y);
    }
    
    /**
     * Test of setP method, of class Speler.
     */
    @Test
    public void testSetPteGroot() {
        System.out.println("setPteGroot");
        int X = 35;
        int Y = 35;
        Speler instance = new Speler();
        instance.setP(X, Y);
    }
    
    /**
     * Test of setLabels method, of class Speler.
     */
    @Test
    public void testCanMove() {
        System.out.println("setLabels");
        String directie = "Rechts";
        Speler instance = new Speler();
        boolean expResult = false;
        boolean result = instance.canMove(directie);
        assertEquals(expResult, result);
    }
}
