/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Admin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({project.DoolhofTest.class, project.ProjectDDoolhofTest.class, project.BazookaTest.class, project.MuurTest.class, project.HelperTest.class, project.UitgangTest.class, project.SpelerTest.class, project.FrameDoolhofTest.class, project.ValsspelerTest.class})
public class ProjectSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
