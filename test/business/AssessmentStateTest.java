/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.Checklistable;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Simon
 */
public class AssessmentStateTest {
    
    public AssessmentStateTest() {
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
     * Test of savePhase method, of class AssessmentState.
     */
    @Test
    public void testSavePhase() {
        System.out.println("savePhase");
        Information info = null;
        AssessmentState instance = new AssessmentState();
        boolean expResult = false;
        boolean result = instance.savePhase(info);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class AssessmentState.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        String text = "";
        Checklistable sourceInfo = null;
        Information info = null;
        AssessmentState instance = new AssessmentState();
        instance.write(text, sourceInfo, info);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkFields method, of class AssessmentState.
     */
    @Test
    public void testCheckFields() {
        System.out.println("checkFields");
        Information info = null;
        AssessmentState instance = new AssessmentState();
        Set<Checklistable> expResult = null;
        Set<Checklistable> result = instance.checkFields(info);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of done method, of class AssessmentState.
     */
    @Test
    public void testDone() {
        System.out.println("done");
        Information info = null;
        AssessmentState instance = new AssessmentState();
        Set<Checklistable> expResult = null;
        Set<Checklistable> result = instance.done(info);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of discard method, of class AssessmentState.
     */
    @Test
    public void testDiscard() {
        System.out.println("discard");
        Information info = null;
        AssessmentState instance = new AssessmentState();
        instance.discard(info);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
