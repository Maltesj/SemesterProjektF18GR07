/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.Checklistable;
import acquaintance.EnumPhases;
import java.util.Map;
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
public class UdredTest {
    
    public UdredTest() {
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
     * Test of startAssessment method, of class Udred.
     */
    @Test
    public void testStartAssessment() {
        System.out.println("startAssessment");
        String caseID = "";
        String caseWorkerID = "";
        Udred instance = new Udred();
        boolean expResult = false;
        boolean result = instance.startAssessment(caseID, caseWorkerID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Udred.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Udred instance = new Udred();
        boolean expResult = false;
        boolean result = instance.save();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of done method, of class Udred.
     */
    @Test
    public void testDone() {
        System.out.println("done");
        Udred instance = new Udred();
        Set<Checklistable> expResult = null;
        Set<Checklistable> result = instance.done();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class Udred.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        String text = "";
        Checklistable sourceInfo = null;
        Udred instance = new Udred();
        instance.write(text, sourceInfo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCaseInformation method, of class Udred.
     */
    @Test
    public void testGetCaseInformation() {
        System.out.println("getCaseInformation");
        Udred instance = new Udred();
        Map<Checklistable, String> expResult = null;
        Map<Checklistable, String> result = instance.getCaseInformation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkFields method, of class Udred.
     */
    @Test
    public void testCheckFields() {
        System.out.println("checkFields");
        Udred instance = new Udred();
        Set<Checklistable> expResult = null;
        Set<Checklistable> result = instance.checkFields();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startActionPlan method, of class Udred.
     */
    @Test
    public void testStartActionPlan() {
        System.out.println("startActionPlan");
        String caseWorkerID = "";
        String caseID = "";
        Udred instance = new Udred();
        Map<Checklistable, String> expResult = null;
        Map<Checklistable, String> result = instance.startActionPlan(caseWorkerID, caseID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of continueActionPlan method, of class Udred.
     */
    @Test
    public void testContinueActionPlan() {
        System.out.println("continueActionPlan");
        Udred instance = new Udred();
        Map<Checklistable, String> expResult = null;
        Map<Checklistable, String> result = instance.continueActionPlan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of discardPhase method, of class Udred.
     */
    @Test
    public void testDiscardPhase() {
        System.out.println("discardPhase");
        Udred instance = new Udred();
        instance.discardPhase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savePhase method, of class Udred.
     */
    @Test
    public void testSavePhase() {
        System.out.println("savePhase");
        Udred instance = new Udred();
        boolean expResult = false;
        boolean result = instance.savePhase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setState method, of class Udred.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        EnumPhases phase = null;
        Udred instance = new Udred();
        instance.setState(phase);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
