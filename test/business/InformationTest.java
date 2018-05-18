/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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
public class InformationTest {
    
    public InformationTest() {
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
     * Test of getAssessmentInformation method, of class Information.
     */
    @Test
    public void testGetAssessmentInformation() {
        System.out.println("getAssessmentInformation");
        Information instance = null;
        AssessmentInformation expResult = null;
        AssessmentInformation result = instance.getAssessmentInformation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAssessmentInformation method, of class Information.
     */
    @Test
    public void testSetAssessmentInformation() {
        System.out.println("setAssessmentInformation");
        AssessmentInformation assessmentInformation = null;
        Information instance = null;
        instance.setAssessmentInformation(assessmentInformation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCaseInformation method, of class Information.
     */
    @Test
    public void testSetCaseInformation() {
        System.out.println("setCaseInformation");
        CaseInformation caseInformation = null;
        Information instance = null;
        instance.setCaseInformation(caseInformation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCaseInformation method, of class Information.
     */
    @Test
    public void testGetCaseInformation() {
        System.out.println("getCaseInformation");
        Information instance = null;
        CaseInformation expResult = null;
        CaseInformation result = instance.getCaseInformation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActionplanInformation method, of class Information.
     */
    @Test
    public void testSetActionplanInformation() {
        System.out.println("setActionplanInformation");
        ActionplanInformation actionplanInformation = null;
        Information instance = null;
        instance.setActionplanInformation(actionplanInformation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActionplanInformation method, of class Information.
     */
    @Test
    public void testGetActionplanInformation() {
        System.out.println("getActionplanInformation");
        Information instance = null;
        ActionplanInformation expResult = null;
        ActionplanInformation result = instance.getActionplanInformation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCaseID method, of class Information.
     */
    @Test
    public void testGetCaseID() {
        System.out.println("getCaseID");
        Information instance = null;
        String expResult = "";
        String result = instance.getCaseID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
