/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.Checklistable;
import acquaintance.EnumPhases;
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
public class CheckListTest {
    
    public CheckListTest() {
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
     * Test of checkCollection method, of class CheckList.
     */
    @Test
    public void testCheckCollection() {
        System.out.println("checkCollection");
        Set<Checklistable> info = null;
        EnumPhases phase = null;
        CheckList instance = new CheckList();
        Set<Checklistable> expResult = null;
        Set<Checklistable> result = instance.checkCollection(info, phase);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
