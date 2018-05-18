/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.Checklistable;
import acquaintance.EnumPhases;
import acquaintance.IActionplan;
import acquaintance.ICaseInformation;
import acquaintance.IDataFacade;
import acquaintance.IWork;
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
public class BusinessFacadeTest {
    
    public BusinessFacadeTest() {
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
     * Test of getInstance method, of class BusinessFacade.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        BusinessFacade expResult = null;
        BusinessFacade result = BusinessFacade.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of injectDataFacade method, of class BusinessFacade.
     */
    @Test
    public void testInjectDataFacade() {
        System.out.println("injectDataFacade");
        IDataFacade dataFacade = null;
        BusinessFacade instance = null;
        instance.injectDataFacade(dataFacade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startAssessment method, of class BusinessFacade.
     */
    @Test
    public void testStartAssessment() {
        System.out.println("startAssessment");
        String caseID = "";
        String caseWorkerID = "";
        BusinessFacade instance = null;
        boolean expResult = false;
        boolean result = instance.startAssessment(caseID, caseWorkerID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class BusinessFacade.
     */
    @Test
    public void testSave_0args() {
        System.out.println("save");
        BusinessFacade instance = null;
        boolean expResult = false;
        boolean result = instance.save();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of done method, of class BusinessFacade.
     */
    @Test
    public void testDone() {
        System.out.println("done");
        BusinessFacade instance = null;
        Set<Checklistable> expResult = null;
        Set<Checklistable> result = instance.done();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class BusinessFacade.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        String text = "";
        Checklistable sourceInfo = null;
        BusinessFacade instance = null;
        instance.write(text, sourceInfo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCaseInformation method, of class BusinessFacade.
     */
    @Test
    public void testGetCaseInformation() {
        System.out.println("getCaseInformation");
        String CaseID = "";
        BusinessFacade instance = null;
        Map<Checklistable, String> expResult = null;
        Map<Checklistable, String> result = instance.getCaseInformation(CaseID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCaseIDs method, of class BusinessFacade.
     */
    @Test
    public void testGetCaseIDs() {
        System.out.println("getCaseIDs");
        BusinessFacade instance = null;
        Set<String> expResult = null;
        Set<String> result = instance.getCaseIDs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkFields method, of class BusinessFacade.
     */
    @Test
    public void testCheckFields() {
        System.out.println("checkFields");
        BusinessFacade instance = null;
        Set<Checklistable> expResult = null;
        Set<Checklistable> result = instance.checkFields();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startActionPlan method, of class BusinessFacade.
     */
    @Test
    public void testStartActionPlan() {
        System.out.println("startActionPlan");
        String caseWorkerID = "";
        String caseID = "";
        BusinessFacade instance = null;
        Map<Checklistable, String> expResult = null;
        Map<Checklistable, String> result = instance.startActionPlan(caseWorkerID, caseID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of continueActionPlan method, of class BusinessFacade.
     */
    @Test
    public void testContinueActionPlan() {
        System.out.println("continueActionPlan");
        BusinessFacade instance = null;
        Map<Checklistable, String> expResult = null;
        Map<Checklistable, String> result = instance.continueActionPlan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of discardPhase method, of class BusinessFacade.
     */
    @Test
    public void testDiscardPhase() {
        System.out.println("discardPhase");
        BusinessFacade instance = null;
        instance.discardPhase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savePhase method, of class BusinessFacade.
     */
    @Test
    public void testSavePhase_0args() {
        System.out.println("savePhase");
        BusinessFacade instance = null;
        boolean expResult = false;
        boolean result = instance.savePhase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setState method, of class BusinessFacade.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        EnumPhases phase = null;
        BusinessFacade instance = null;
        instance.setState(phase);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savePhase method, of class BusinessFacade.
     */
    @Test
    public void testSavePhase_3args() {
        System.out.println("savePhase");
        Information info = null;
        EnumPhases phase = null;
        String caseID = "";
        BusinessFacade instance = null;
        boolean expResult = false;
        boolean result = instance.savePhase(info, phase, caseID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of discard method, of class BusinessFacade.
     */
    @Test
    public void testDiscard() {
        System.out.println("discard");
        EnumPhases phase = null;
        String caseID = "";
        BusinessFacade instance = null;
        boolean expResult = false;
        boolean result = instance.discard(phase, caseID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActionPlan method, of class BusinessFacade.
     */
    @Test
    public void testGetActionPlan() {
        System.out.println("getActionPlan");
        BusinessFacade instance = null;
        IActionplan expResult = null;
        IActionplan result = instance.getActionPlan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWork method, of class BusinessFacade.
     */
    @Test
    public void testGetWork() {
        System.out.println("getWork");
        BusinessFacade instance = null;
        IWork expResult = null;
        IWork result = instance.getWork();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class BusinessFacade.
     */
    @Test
    public void testSave_Information_String() {
        System.out.println("save");
        Information info = null;
        String caseID = "";
        BusinessFacade instance = null;
        instance.save(info, caseID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCaseInfo method, of class BusinessFacade.
     */
    @Test
    public void testGetCaseInfo() {
        System.out.println("getCaseInfo");
        String caseID = "";
        BusinessFacade instance = null;
        ICaseInformation expResult = null;
        ICaseInformation result = instance.getCaseInfo(caseID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
