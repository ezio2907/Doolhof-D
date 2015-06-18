/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class FrameDoolhofTest {

    public FrameDoolhofTest() {
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
     * Test of canMove method, of class FrameDoolhof.
     */
    @Test
    public void testCanMoveNorth() throws IOException {
        System.out.println("canMove");
        String direction = "Omhoog";
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        boolean expResult = false;
        boolean result = instance.canMove(direction, instance.S.getX(), instance.S.getY());
        assertEquals(expResult, result);
    }

    @Test
    public void testCanMoveEast() throws IOException {
        System.out.println("canMove");
        String direction = "Rechts";
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        boolean expResult = false;
        boolean result = instance.canMove(direction, instance.S.getX(), instance.S.getY());
        assertEquals(expResult, result);
    }

    @Test
    public void testCanMoveSouth() throws IOException {
        System.out.println("canMove");
        String direction = "Omlaag";
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        boolean expResult = true;
        boolean result = instance.canMove(direction, instance.S.getX(), instance.S.getY());
        assertEquals(expResult, result);
    }

    @Test
    public void testCanMoveWest() throws IOException {
        System.out.println("canMove");
        String direction = "Links";
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        boolean expResult = false;
        boolean result = instance.canMove(direction, instance.S.getX(), instance.S.getY());
        assertEquals(expResult, result);
    }

    @Test
    public void schieten() throws IOException, AWTException {
        System.out.println("Rechts");
        String direction = "Rechts";
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        instance.S.setP(4, 3);
        instance.S.setDirection('E');
        Robot robot = new Robot();
        robot.keyPress(39);
        robot.keyRelease(39);
        robot.keyPress(32);
        robot.keyRelease(32);
        boolean expResult = true;
        boolean result = instance.Doolhof[6][3].loopbaar;
        assertEquals(expResult, result);
    }
}
