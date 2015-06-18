/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        KeyEvent key = new KeyEvent(instance.frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP);
        instance.frame.getKeyListeners()[0].keyPressed(key);
        int expResult = 1;
        int result = instance.S.getY();
        assertEquals(expResult, result);
    }

    @Test
    public void testCanMoveEast() throws IOException {
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        KeyEvent key = new KeyEvent(instance.frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT);
        instance.frame.getKeyListeners()[0].keyPressed(key);
        int expResult = 1;
        int result = instance.S.getX();
        assertEquals(expResult, result);
    }

    @Test
    public void testCanMoveSouth() throws IOException, AWTException {
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        KeyEvent key = new KeyEvent(instance.frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN);
        instance.frame.getKeyListeners()[0].keyPressed(key);
        int expResult = 2;
        int result = instance.S.getY();
        assertEquals(expResult, result);
    }

    @Test
    public void testCanMoveWest() throws IOException, AWTException {
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        KeyEvent key = new KeyEvent(instance.frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT);
        instance.frame.getKeyListeners()[0].keyPressed(key);
        int expResult = 1;
        int result = instance.S.getX();
        assertEquals(expResult, result);
    }

    @Test
    public void schieten() throws IOException, AWTException {
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        instance.S.setP(4, 3);
        instance.S.setDirection('E');
        KeyEvent key = new KeyEvent(instance.frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT);
        instance.frame.getKeyListeners()[0].keyPressed(key);
        key = new KeyEvent(instance.frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_SPACE);
        instance.frame.getKeyListeners()[0].keyPressed(key);
        key = new KeyEvent(instance.frame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT);
        instance.frame.getKeyListeners()[0].keyPressed(key);
        int expResult = 6;
        int result = instance.S.getX();
        assertEquals(expResult, result);
    }

    @Test
    public void lopen() throws IOException {
        FrameDoolhof instance = new FrameDoolhof();
        instance.opbouw(1);
        instance.startButton.doClick();
        instance.Dh.setStappen(1);
        boolean een;
        boolean twee;
        boolean drie;
        boolean totaal;
        if (instance.canMove("Omlaag", 1, 1)) {
            een = true;
        }
        instance.Dh.setStappen(0);
        if(!instance.canMove("Omlaag",1,1)){
            twee = true;
        }
    }
}
