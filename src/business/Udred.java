/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.IDataFacade;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author malte
 */
public class Udred {
    
    /**
     * ID of the current case worker
     */
    private String currentCaseWorkerID;
    /**
     * ID of the current case
     */
    private String currentCaseID;
    /**
     * A map containing information about the cases and the case IDs as keys
     */
    private Map<String, Information> cases;
    /**
     * A CheckList object
     */
    private CheckList checkList;
    
    Udred(){
        this.checkList = new CheckList();
        this.cases = new HashMap<>();
    }
    
    /**
     * The method loads case information and sets up for the assessment.
     *
     * @param caseID The ID of the current case
     * @param caseWorkerID The ID of the current caseworker
     * @return Returns true if there was case information in the database
     */
    boolean startAssessment(String caseID, String caseWorkerID) {
        this.currentCaseID = caseID;
        this.currentCaseWorkerID = caseWorkerID;
        this.cases = new HashMap<String, Information>();
        
        //test data initializering:
//        HashMap testInfo = new HashMap<String,String>();
//        testInfo.put("hello", "World");
        
        BusinessFacade business = BusinessFacade.getInstance();
        IDataFacade data = business.getDataFacade();
//        CaseInformation Cinfo = new CaseInformation(testInfo);//(CaseInformation) data.getInfo();
        CaseInformation Cinfo = (CaseInformation) data.getcCasenfo(this.currentCaseID);
        
        Information info = new Information(caseID, Cinfo);
        cases.put(caseID, info);
        if (info == null) {
            return false;
        }
        return true;
    }
    
    /**
     * The method sends the current case to the database
     * @return Returns true if the current case wasn't null
     */
    boolean save() {
        BusinessFacade business = BusinessFacade.getInstance();
        IDataFacade data = business.getDataFacade();
        
        data.save(cases.get(currentCaseID), currentCaseID);
        
        if (currentCaseID == null) {
            return false;
        }
        return true;
    }
    
    /**
     * The method goes through the assessmentsfields and returns the missing fields after saving the case
     * @return Returns a set with the missing obligatory fields
     */
    Set<String> done() {
        Information info = cases.get(currentCaseID);
        Set<String> filledAssessment = info.getFilledAssessmentFields();
        //sout for testing.
        for (String string : filledAssessment) {
            System.out.println(string);
        }
        System.out.println(filledAssessment);
        
        //dummy checkList
        checkList = new CheckList();
        
        Set<String> missingFields = checkList.checkCollection(filledAssessment);
        
        BusinessFacade business = BusinessFacade.getInstance();
        IDataFacade data = business.getDataFacade();
//        data.save(info);
        
        return missingFields;
    }
    
    /**
     * The method writes a string and it's source to an Information class
     * @param text
     * @param sourceInfo
     */
    public void write(String text, String sourceInfo) {
        Information info = cases.get("1"); //Hard coded case as input
        info.write(text, sourceInfo);
    }
    
    /**
     * The method returns the case information
     * @return Returns a map with information and its source
     */
    Map<String, String> getCaseInformation() {
        Information info = cases.get(currentCaseID);
        Map<String, String> caseinfo = info.getCaseInformation();
        
        return caseinfo;
    }
    
}