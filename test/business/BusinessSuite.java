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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Simon
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({business.AssessmentInformationTest.class, business.AssessmentStateTest.class, business.TestStarterMainTest.class, business.UdredTest.class, business.InformationTest.class, business.IUdredStateTest.class, business.ActionplanStateTest.class, business.ActionplanInformationTest.class, business.CaseInformationTest.class, business.CheckListTest.class, business.BusinessFacadeTest.class})
public class BusinessSuite {

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
