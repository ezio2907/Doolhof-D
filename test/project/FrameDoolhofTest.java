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
     * Test of LevelCreater method, of class FrameDoolhof.
     */
    @Test
    public void testLevelCreater() {
        System.out.println("LevelCreater");
        int level = 0;
        FrameDoolhof instance = new FrameDoolhof();
        instance.LevelCreater(level);
    }
}
