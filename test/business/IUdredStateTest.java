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
public class IUdredStateTest {
    
    public IUdredStateTest() {
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
     * Test of savePhase method, of class IUdredState.
     */
    @Test
    public void testSavePhase() {
        System.out.println("savePhase");
        Information information = null;
        IUdredState instance = new IUdredStateImpl();
        boolean expResult = false;
        boolean result = instance.savePhase(information);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class IUdredState.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        String text = "";
        Checklistable sourceInfo = null;
        Information information = null;
        IUdredState instance = new IUdredStateImpl();
        instance.write(text, sourceInfo, information);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkFields method, of class IUdredState.
     */
    @Test
    public void testCheckFields() {
        System.out.println("checkFields");
        Information information = null;
        IUdredState instance = new IUdredStateImpl();
        Set<Checklistable> expResult = null;
        Set<Checklistable> result = instance.checkFields(information);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of done method, of class IUdredState.
     */
    @Test
    public void testDone() {
        System.out.println("done");
        Information information = null;
        IUdredState instance = new IUdredStateImpl();
        Set<Checklistable> expResult = null;
        Set<Checklistable> result = instance.done(information);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of discard method, of class IUdredState.
     */
    @Test
    public void testDiscard() {
        System.out.println("discard");
        Information information = null;
        IUdredState instance = new IUdredStateImpl();
        instance.discard(information);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IUdredStateImpl implements IUdredState {

        public boolean savePhase(Information information) {
            return false;
        }

        public void write(String text, Checklistable sourceInfo, Information information) {
        }

        public Set<Checklistable> checkFields(Information information) {
            return null;
        }

        public Set<Checklistable> done(Information information) {
            return null;
        }

        public void discard(Information information) {
        }
    }
    
}
