/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.Checklistable;
import java.util.HashMap;
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
public class ActionplanInformationTest {
    
    public ActionplanInformationTest() {
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
     * Test of getFilledFields method, of class ActionplanInformation.
     */
    @Test
    public void testGetFilledFields() {
        System.out.println("getFilledFields");
        ActionplanInformation instance = null;
        Set<Checklistable> expResult = null;
        Set<Checklistable> result = instance.getFilledFields();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ActionplanInformation.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        String text = "";
        Checklistable sourceInfo = null;
        ActionplanInformation instance = null;
        instance.write(text, sourceInfo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInformation method, of class ActionplanInformation.
     */
    @Test
    public void testGetInformation() {
        System.out.println("getInformation");
        ActionplanInformation instance = null;
        HashMap<Checklistable, String> expResult = null;
        HashMap<Checklistable, String> result = instance.getInformation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
